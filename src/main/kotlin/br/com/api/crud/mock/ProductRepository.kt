package br.com.api.crud.mock

import br.com.api.crud.exceptions.NotFoundException
import br.com.api.crud.model.Product
import org.springframework.stereotype.Repository

@Repository
class ProductRepository(
    private var products: List<Product> = listOf()
) {
    fun find(): List<Product> {
        return products
    }

    fun findById(idProduct: Long): Product {
        return products
            .stream()
            .filter {
                it.id == idProduct
            }
            .findFirst()
            .orElseThrow { NotFoundException("Product not found!") }
    }

    fun save(product: Product): Product {
        product.id = products.size.toLong() + 1
        products = products.plus(product)

        return product
    }

    fun update(product: Product): Product {
        val productOld = products
            .stream()
            .filter {
                it.id == product.id
            }
            .findFirst()
            .orElseThrow { NotFoundException("Product not found!") }

        val productUpdated = Product(
            id = product.id,
            description = product.description,
            quantity = product.quantity,
            addressProduct = productOld.addressProduct,
            createAt = productOld.createAt
        )

        products = products
            .minus(product)
            .plus(productUpdated)

        return productUpdated
    }

    fun delete(idProduct: Long) {
        val product = products
            .stream()
            .filter {
                it.id == idProduct
            }
            .findFirst()
            .orElseThrow { NotFoundException("Product not found!") }

        products = products
            .minus(product)
    }
}