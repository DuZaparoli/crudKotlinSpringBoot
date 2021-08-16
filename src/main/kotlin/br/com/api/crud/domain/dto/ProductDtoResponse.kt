package br.com.api.crud.domain.dto

import br.com.api.crud.domain.model.LocationProduct
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL) //Esta anotação oculta qualquer campo do objeto caso ele esteja null
data class ProductDtoResponse(
    val id: Long? = null,
    val description: String,
    val quantity: Int? = 0,
    val location: LocationProduct? = null,
    val createAt: LocalDateTime = LocalDateTime.now()
)