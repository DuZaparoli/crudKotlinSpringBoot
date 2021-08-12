package br.com.api.crud.model

data class AddressProduct(
    val id: Long? = null,
    val street: String,
    val number: Int,
    val apartment: Int
)
