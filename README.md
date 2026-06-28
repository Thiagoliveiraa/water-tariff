# API de Tabela Tarifária de Água

API REST desenvolvida em **Java 25** com **Spring Boot** para gerenciamento de tabelas tarifárias e cálculo de tarifas de água com base em categorias de consumidores e faixas de consumo progressivas.

O projeto foi desenvolvido seguindo os princípios de **Clean Code**, **SOLID** e **RESTful APIs**, permitindo que alterações nas faixas de consumo e valores tarifários sejam realizadas diretamente no banco de dados, sem necessidade de alteração de código.

---

# Tecnologias utilizadas

* Java 25
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Validation (Bean Validation)
* PostgreSQL
* Docker / Docker Compose
* pgAdmin
* Maven
* JUnit 5
* Mockito

---

# Pré-requisitos

Antes de executar a aplicação é necessário possuir instalado:

* JDK 25
* Maven 3.9+
* Docker
* Docker Compose

---

# Executando o projeto

## 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

```bash
cd seu-repositorio
```

---

## 2. Suba os containers

O projeto possui um `docker-compose.yml` responsável por iniciar:

* PostgreSQL
* pgAdmin

Execute:

```bash
docker compose up -d
```

ou

```bash
docker-compose up -d
```

Após alguns segundos os serviços estarão disponíveis.

---

## PostgreSQL

| Configuração | Valor        |
| ------------ | ------------ |
| Host         | localhost    |
| Porta        | 5432         |
| Database     | water_tariff |
| Usuário      | postgres     |
| Senha        | postgres     |

*(Caso tenha alterado essas informações no `docker-compose.yml`, utilize as credenciais correspondentes.)*

---

## pgAdmin

Acesse:

```
http://localhost:5050
```

Credenciais (conforme docker-compose):

```
Email:
admin@admin.com

Senha:
admin
```

---

# Configuração da aplicação

No arquivo `application.yml` configure as propriedades do banco:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/water_tariff
    username: postgres
    password: postgres

  jpa:
    hibernate:
      ddl-auto: update
```

---

# Executando a aplicação

Execute utilizando o Maven:

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:

```
http://localhost:8080
```

---

# Endpoints

## Criar tabela tarifária

**POST**

```
/api/tabelas-tarifarias
```

### Exemplo de Request

```json
{
  "nome": "Tabela Tarifária 2026",
  "dataVigencia": "2026-01-01",
  "categorias": [
    {
      "categoria": "INDUSTRIAL",
      "faixas": [
        {
          "inicio": 0,
          "fim": 10,
          "valorUnitario": 1.00
        },
        {
          "inicio": 11,
          "fim": 20,
          "valorUnitario": 2.00
        },
        {
          "inicio": 21,
          "fim": 999999,
          "valorUnitario": 5.00
        }
      ]
    }
  ]
}
```

### Response

```http
201 Created
```

---

## Listar tabelas tarifárias

**GET**

```
/api/tabelas-tarifarias
```

### Response

```json
[
  {
    "id": 1,
    "nome": "Tabela Tarifária 2026",
    "dataVigencia": "2026-01-01",
    "ativa": true
  }
]
```

---

## Excluir tabela tarifária

**DELETE**

```
/api/tabelas-tarifarias/{id}
```

### Response

```http
204 No Content
```

---

## Calcular tarifa

**POST**

```
/api/calculos
```

### Request

```json
{
  "categoria": "INDUSTRIAL",
  "consumo": 18
}
```

### Response

```json
{
  "categoria": "INDUSTRIAL",
  "consumoTotal": 18,
  "valorTotal": 26.00,
  "detalhamento": [
    {
      "faixa": {
        "inicio": 0,
        "fim": 10
      },
      "m3Cobrados": 10,
      "valorUnitario": 1.00,
      "subtotal": 10.00
    },
    {
      "faixa": {
        "inicio": 11,
        "fim": 20
      },
      "m3Cobrados": 8,
      "valorUnitario": 2.00,
      "subtotal": 16.00
    }
  ]
}
```

---

# Validações implementadas

A API utiliza **Spring Validation (Bean Validation)** para validação dos dados recebidos.

Além disso, regras de negócio garantem:

* Não sobreposição de faixas de consumo;
* Faixas com intervalo válido (`início < fim`);
* Primeira faixa iniciando obrigatoriamente em **0 m³**;
* Cobertura contínua das faixas de consumo;
* Existência de faixa suficiente para qualquer consumo informado.

Caso alguma validação falhe, a API retorna mensagens de erro apropriadas com seus respectivos códigos HTTP.

---

# Como testar a aplicação

## Executando os testes

```bash
./mvnw test
```

ou

```bash
mvn test
```

Os testes automatizados utilizam:

* JUnit 5
* Mockito

---

# Estrutura do projeto

```
src
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── validation
├── exception
└── config
```

---

# Arquitetura

O projeto segue uma arquitetura em camadas:

* Controller
* Service
* Repository
* DTO
* Entity
* Validation

As regras de negócio permanecem centralizadas na camada de serviço, enquanto as validações estruturais e de entrada são realizadas por meio do Spring Validation e validadores específicos do domínio.

---

# Autor

Thiago Oliveira
