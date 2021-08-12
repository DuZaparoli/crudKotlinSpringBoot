## Cração de API Kotlin com SpringBoot

### Assuntos abordados 
````
* CRUD completo
* Criação de Controller => Service => Repository
* DTOs para representar dados da API de entrada e saída
* Mappers para conversão de DTO para Dominio e inverso
* Validação de campos com Bean Validation
* Tratamento de erros na API
````

### Execução de testes via POSTMAN
````
Importar no Postman o arquivo "CRUD API Kotlin SpringBoot.postman_collection" contido na pasta "postman_collection".
Dentro da collection consta as seguintes operações de testes:
* POST
* GET_ALL
* GET_BY_ID
* PUT
* DELETE
````

## Banco de Dados
````
Esse exemplo de API foi escrita para salvar o dados em memória nesse primeiro momento.
Dentro do diretório "mock", criamos a classe ProductRepository no qual simulamos uma tabela de Produtos para que os dados sejam salvos em memória.
Posteriormente iremos implementar o uso de banco de dados via Docker.
````