package br.com.api.crud.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class ProductPostDtoRequest(
    @field:NotEmpty(message = "Description cannot be empty")
    @field:Size(min = 5, max = 100)
    val description: String,

    @field:NotNull(message = "IdAddress cannot be null")
    val idAddress: Long
)