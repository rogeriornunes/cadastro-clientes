# API Cadastro de Clientes

## Descrição
API que gerencia um cadastro de clientes.

## Funcionalidades

* Cadastrar cliente
* Cadastrar Endereço
* Cadastrar Estado e Cidade;
* Remover cliente;
* Editar cliente;
* Buscar clientes e cidades;

## Powered By

* Spring Boot 2.1.1.RELEASE;
* MySQL 5.7.38;
* FlyWay (migrations);
* Swagger;
* Java 8;
* Docker-Compose;

**Na execução do Docker-Compose, o banco de dados será automaticamente criado, utilizando MYSQL.

## Como Usar
### Docker-Compose

Baixa ou clone o projeto, faça o build do pacote da  aplicação estando dentro do diretorio do projeto, execute o comando abaixo:
 `mvn package`


Com o Docker e Docker-Compose instalados na máquina, acesse a pasta do projeto e rode o comando `docker-compose up --build --force-recreate`. 
Após execução deste será criado a imagem Docker da aplicação, será criado o container no qual irar executar imagem do banco MYSQL e aplicação conforme abaixo:      

* Banco de dados
container_name: softnunes-mysql 
image: mysql/mysql-server:5.7 

* Aplicação
container_name: cadastro-clientes_app
image: cadastro-clientes_app_1

Aguarde alguns segundos e tente acessar qualquer endpoint (["Swagger, Endpoints"](#swagger-endpoints)).


## Swagger, Endpoints 

A API dispõe de acesso ao Swagger para fácil utilização. Após subir o serviço, acesse http://localhost:8080/swagger-ui.html.

Os endpoints disponíveis estão presentes nele.

## Dados de Testes

A aplicação cria alguns dados para testes, **caso o banco de dados estiver vazio**.

São dois usuários, 2 cidades,  2 Estados e 23 Endereços.

## Tabelas e Migrations
As tabelas usadas pelo MySQL estão no arquivo `./src/main/resources/db/migration`. Usamos o [FlyWay](https://flywaydb.org/) para criar as tabelas no banco e versionar as migrations. **O Hibernate não cria ou atualiza as tabelas.**

## Testes 
Há alguns testes de integração na controllers na pasta `./src/test/java/br/com/softnunes/cadastroclientes/controllers`.
