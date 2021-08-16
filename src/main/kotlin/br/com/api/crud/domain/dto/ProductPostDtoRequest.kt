package br.com.api.crud.domain.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class ProductPostDtoRequest(
    @field:NotEmpty(message = "Description cannot be empty")
    @field:Size(min = 5, max = 100)
    val description: String,
    val quantity: Int?,
    val locationId: Long?
)