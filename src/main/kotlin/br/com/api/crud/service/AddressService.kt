package br.com.api.crud.service

import br.com.api.crud.model.AddressProduct
import org.springframework.stereotype.Service

@Service
class AddressService(var adresses: List<AddressProduct>) {

    init {
        val addressProduct = AddressProduct(
            id = 1,
            street = "Street 1",
            number = 10,
            apartment = 3
        )

        adresses = listOf(addressProduct)
    }

    fun findById(id: Long): AddressProduct {
        return adresses
            .stream()
            .filter {
                it.id == id
            }
            .findFirst()
            .orElse(null)
    }
}
