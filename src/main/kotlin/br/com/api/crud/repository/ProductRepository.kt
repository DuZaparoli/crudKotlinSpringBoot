package br.com.api.crud.repository

import br.com.api.crud.domain.dto.ProductReportDtoResponse
import br.com.api.crud.domain.model.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProductRepository : JpaRepository<Product, Long> {
    fun findByLocationStreet(locationStreet: String, pagination: Pageable): Page<Product>

    @Query("SELECT new br.com.api.crud.domain.dto.ProductReportDtoResponse(description, quantity) FROM Product")
    fun reportCustom(): List<ProductReportDtoResponse>
}