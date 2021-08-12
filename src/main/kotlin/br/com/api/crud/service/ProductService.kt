package br.com.api.crud.service

import br.com.api.crud.dto.ProductDtoResponse
import br.com.api.crud.dto.ProductPatchDtoRequest
import br.com.api.crud.dto.ProductPostDtoRequest
import br.com.api.crud.mapper.ProductDtoMapper
import br.com.api.crud.mock.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private var productRepository: ProductRepository,
    private val productDtoMapper: ProductDtoMapper
) {

    fun find(): List<ProductDtoResponse> {
        var listResponse = listOf<ProductDtoResponse>()

        productRepository
            .find()
            .map { product ->
                listResponse = listResponse.plus(productDtoMapper.mapToProductResponse(product))
            }

        return listResponse
    }

    fun findById(idProduct: Long): ProductDtoResponse {
        val product = productRepository
            .findById(idProduct)

        return productDtoMapper.mapToProductResponse(product)
    }

    fun save(dto: ProductPostDtoRequest): ProductDtoResponse {
        val product = productRepository
            .save(
                productDtoMapper
                    .mapToProduct(dto)
            )

        return productDtoMapper.mapToProductResponse(product)
    }

    fun update(dto: ProductPatchDtoRequest): ProductDtoResponse {
        val product = productRepository.update(productDtoMapper.mapToProduct(dto))

        return productDtoMapper.mapToProductResponse(product)
    }

    fun delete(idProduct: Long) {
        productRepository.delete(idProduct)
    }
}