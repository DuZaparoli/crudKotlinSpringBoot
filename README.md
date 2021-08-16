## Cração de API Kotlin com SpringBoot

### Assuntos abordados 
````
* CRUD completo
* Criação de Controller => Service => Repository
* DTOs para representar dados da API de entrada e saída
* Mappers para conversão de DTO para Dominio e inverso
* Validação de campos com Bean Validation
* Paginação para controle de quantidade de itens retornados na consulta
* Ordenação dos itens retornados na consulta
* Filtros de consultas via url
* Tratamento de erros na API
* Uso de banco de dados MySQL 
* Migrations gerenciados via Flyway, configurações no arquivo "application.yml" e arquivos no diretório "src/main/resources/db/migrations"
* Consultas com quary personalizadas no repository
* Cache (em memória) para armazenamento de consultas
    ** O cache normalmente é utilizado somente para dados que dificilmente são alterados pois se armazenarmos um dado em cache que altera frequentemente, corremos o risco de retornar informações incorretas. No caso de um cadastro de produto, normalmente o produto altera muitas vezes, então implementei somente para uso didático.
* Docker para utilização do banco de dados MySql, configurações no arquivo "docker-compose.yml" 
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
Esse exemplo de API foi utilizado banco de dados MySQL com migrations versionados via Flayway.
Dentro do diretório "mock", criamos a classe ProductRepository no qual simulamos uma tabela de Produtos para que os dados sejam salvos em memória.
Posteriormente iremos implementar o uso de banco de dados via Docker.
````

## Docker
````
Caso possua o banco de dados MySQL instalado, basta configurar as propriedades do aquivo "docker-compose.yml" apontando para o endereço e configurando os dados de usuário e senha.
Se não possuir o banco de dados MySQL instalado, deverá instalar o Docker na máquina e antes de dar um start na aplicação, deverá usar o comando "docker-compose up" para subir o docker e uma instância do banco de dados localmente. 

Comandos úteis utilizados no Docker

* Subir o docker e todas as imagens configuradas no arquivo "docker-compose.yml": "docker-compose up"
* Listar todos containers: "docker ps -aq"
* Stop todos containers: "docker stop $(docker ps -aq)"
* Remover todos containers: "docker rm $(docker ps -aq)"
* Remover todas imagens: "docker rmi $(docker images -q)"
````