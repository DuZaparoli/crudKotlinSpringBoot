package br.com.api.crud.domain.dto

import java.time.LocalDateTime

data class ErrorDto(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val patch: String
)