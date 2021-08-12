package br.com.api.crud.controller

import br.com.api.crud.dto.ProductDtoResponse
import br.com.api.crud.dto.ProductPatchDtoRequest
import br.com.api.crud.dto.ProductPostDtoRequest
import br.com.api.crud.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/products")
class ProductController(private val service: ProductService) {

    @GetMapping
    fun getAll(): List<ProductDtoResponse> {
        return service.find()
    }

    @GetMapping("/{id_product}")
    fun getById(@PathVariable id_product: Long): ProductDtoResponse {
        return service.findById(id_product)
    }

    @PostMapping
    fun post(
        @RequestBody @Valid dto: ProductPostDtoRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ProductDtoResponse> {
        val productResponse = service.save(dto)

        val uri = uriBuilder
            .path("products/${productResponse.id}")
            .build()
            .toUri()

        return ResponseEntity.created(uri).body(productResponse)
    }

    @PutMapping
    fun patch(@RequestBody @Valid dto: ProductPatchDtoRequest): ResponseEntity<ProductDtoResponse> {
        val productResponse = service.update(dto)

        return ResponseEntity.ok(productResponse)
    }

    @DeleteMapping("/{id_product}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id_product: Long) {
        return service.delete(id_product)
    }
}