package br.com.api.crud.domain.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL) //Esta anotação oculta qualquer campo do objeto caso ele esteja null
data class ProductReportDtoResponse(
    val description: String,
    val quantity: Int? = 0
)