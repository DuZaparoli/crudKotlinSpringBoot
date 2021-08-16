package br.com.api.crud.service

import br.com.api.crud.domain.dto.ProductDtoResponse
import br.com.api.crud.domain.dto.ProductPatchDtoRequest
import br.com.api.crud.domain.dto.ProductPostDtoRequest
import br.com.api.crud.domain.dto.ProductReportDtoResponse
import br.com.api.crud.domain.exceptions.NotFoundException
import br.com.api.crud.domain.mapper.ProductDtoMapper
import br.com.api.crud.repository.LocationProductRepository
import br.com.api.crud.repository.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ProductService(
    private var productRepository: ProductRepository,
    private var locationProductRepository: LocationProductRepository,
    private val productDtoMapper: ProductDtoMapper
) {

    fun find(
        locationStreet: String?,
        pagination: Pageable
    ): Page<ProductDtoResponse> {
        var listResponse = if (locationStreet != null) {
            productRepository
                .findByLocationStreet(locationStreet, pagination)
        } else {
            productRepository
                .findAll(pagination)
        }

        return listResponse
            .map { product ->
                productDtoMapper.mapToProductResponse(product)
            }
    }

    fun findById(idProduct: Long): ProductDtoResponse {
        val product = productRepository
            .findById(idProduct)
            .orElseThrow {
                NotFoundException("Product not found!")
            }

        return productDtoMapper.mapToProductResponse(product)
    }

    fun save(dto: ProductPostDtoRequest): ProductDtoResponse {
        var productRequest = productDtoMapper.mapToProduct(dto)

        dto.locationId.let {
            productRequest.location = locationProductRepository.getById(it!!)
        }

        val product = productRepository
            .save(productRequest)

        return productDtoMapper.mapToProductResponse(product)
    }

    fun update(dto: ProductPatchDtoRequest): ProductDtoResponse {
        val product = productRepository
            .findById(dto.id)
            .orElseThrow { NotFoundException("Product not found!") }
        product.description = dto.description
        product.quantity = dto.quantity

        return productDtoMapper
            .mapToProductResponse(
                productRepository
                    .save(product)
            )
    }

    fun delete(idProduct: Long) {
        productRepository.deleteById(idProduct)
    }

    fun reportCustom(): List<ProductReportDtoResponse> {
        return productRepository.reportCustom()
    }
}