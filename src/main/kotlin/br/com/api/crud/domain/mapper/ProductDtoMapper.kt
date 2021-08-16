package br.com.api.crud.domain.mapper

import br.com.api.crud.domain.dto.ProductDtoResponse
import br.com.api.crud.domain.dto.ProductPatchDtoRequest
import br.com.api.crud.domain.dto.ProductPostDtoRequest
import br.com.api.crud.domain.model.LocationProduct
import br.com.api.crud.domain.model.Product
import org.springframework.stereotype.Component

@Component
class ProductDtoMapper {
    fun mapToProductResponse(product: Product): ProductDtoResponse {
        return ProductDtoResponse(
            id = product.id,
            description = product.description,
            quantity = product.quantity,
            location = product.location,
            createAt = product.createAt
        )
    }

    fun mapToProduct(dto: ProductPostDtoRequest): Product {
        return Product(
            description = dto.description,
            quantity = dto.quantity
        )
    }
}