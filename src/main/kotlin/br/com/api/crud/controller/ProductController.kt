package br.com.api.crud.controller

import br.com.api.crud.domain.dto.ProductDtoResponse
import br.com.api.crud.domain.dto.ProductPatchDtoRequest
import br.com.api.crud.domain.dto.ProductPostDtoRequest
import br.com.api.crud.domain.dto.ProductReportDtoResponse
import br.com.api.crud.service.ProductService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/products")
@Api(description = "RESPONSÁVEL POR GERENCIAR REQUISIÇÕES NA API DE PRODUTOS")
class ProductController(private val service: ProductService) {

    @PostMapping
    @Transactional
    @CacheEvict(value = ["cacheProductsList"], allEntries = true)
    @ApiOperation(value = "MÉTODO POST UTILIZADO PARA INSESIR INFORMAÇÕES DE PRODUTO")
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

    @GetMapping
    @Cacheable("cacheProductsList")
    @ApiOperation(value = "Consulta de todos produtos. Disponível consulta por produtos de uma mesma rua e paginação padrão, consulte opções abaixo.")
    fun getAll(
        @RequestParam(required = false) locationStreet: String?,
        @PageableDefault(size = 5, sort = ["id"], direction = Sort.Direction.ASC) pagination: Pageable
    ): Page<ProductDtoResponse> {
        return service.find(locationStreet, pagination)
    }

    @GetMapping("/{id_product}")
    @ApiOperation(value = "Consulta de produto com base no ID do produto.")
    fun getById(@PathVariable id_product: Long): ProductDtoResponse {
        return service.findById(id_product)
    }

    @GetMapping("/report")
    @Cacheable("cacheProductsList")
    @ApiOperation(value = "Consulta de relatório de produtos (descrição + quantidade).")
    fun getAllCustom(): List<ProductReportDtoResponse> {
        return service.reportCustom()
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["cacheProductsList"], allEntries = true)
    @ApiOperation(value = "Alteração de dados de produtos.")
    fun put(@RequestBody @Valid dto: ProductPatchDtoRequest): ResponseEntity<ProductDtoResponse> {
        val productResponse = service.update(dto)

        return ResponseEntity.ok(productResponse)
    }

    @DeleteMapping("/{id_product}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["cacheProductsList"], allEntries = true)
    @ApiOperation(value = "Exclusão de produto com base no seu ID")
    fun delete(@PathVariable id_product: Long) {
        return service.delete(id_product)
    }
}