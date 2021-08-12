package br.com.api.crud.mapper

import br.com.api.crud.dto.ProductDtoResponse
import br.com.api.crud.dto.ProductPatchDtoRequest
import br.com.api.crud.dto.ProductPostDtoRequest
import br.com.api.crud.model.Product
import br.com.api.crud.service.AddressService
import org.springframework.stereotype.Component

@Component
class ProductDtoMapper(
    private val addressService: AddressService
) {
    fun mapToProductResponse(product: Product): ProductDtoResponse {
        return ProductDtoResponse(
            id = product.id,
            description = product.description,
            quantity = product.quantity,
            createAt = product.createAt
        )
    }

    fun mapToProduct(dto: ProductPostDtoRequest): Product {
        return Product(
            description = dto.description,
            addressProduct = addressService.findById(dto.idAddress)
        )
    }

    fun mapToProduct(dto: ProductPatchDtoRequest): Product {
        return Product(
            id = dto.id,
            description = dto.description,
            quantity = dto.quantity
        )
    }
}