package br.com.api.crud.repository

import br.com.api.crud.domain.model.LocationProduct
import org.springframework.data.jpa.repository.JpaRepository

interface LocationProductRepository : JpaRepository<LocationProduct, Long> {
}