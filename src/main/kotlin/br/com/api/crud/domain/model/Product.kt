package br.com.api.crud.domain.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var description: String,
    var quantity: Int? = 0,
    @OneToOne
    var location: LocationProduct? = null,
    val createAt: LocalDateTime = LocalDateTime.now()
)