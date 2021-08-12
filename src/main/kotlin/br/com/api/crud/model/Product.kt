package br.com.api.crud.model

import java.time.LocalDateTime

data class Product(
    var id: Long? = null,
    val description: String,
    val quantity: Int = 0,
    val addressProduct: AddressProduct? = null,
    val createAt: LocalDateTime = LocalDateTime.now()
)