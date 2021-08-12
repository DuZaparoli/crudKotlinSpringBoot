package br.com.api.crud.dto

import java.time.LocalDateTime

data class ErrorDto(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val patch: String
)