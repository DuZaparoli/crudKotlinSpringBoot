package br.com.api.crud.domain.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class ProductPatchDtoRequest(
    @field:NotNull
    val id: Long,

    @field:NotEmpty(message = "Description cannot be empty")
    @field:Size(min = 5, max = 100)
    val description: String,

    @field:NotNull(message = "Quantity cannot be null")
    val quantity: Int = 0,

    @field:NotNull(message = "Status cannot be null")
    val status: Int
)