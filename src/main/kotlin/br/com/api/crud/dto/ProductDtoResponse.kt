package br.com.api.crud.dto

import java.time.LocalDateTime

data class ProductDtoResponse(
    val id: Long? = null,
    val description: String,
    val quantity: Int = 0,
    val createAt: LocalDateTime = LocalDateTime.now()
)