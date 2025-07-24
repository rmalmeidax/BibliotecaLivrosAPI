# 📚 BibliotecaLivrosAPI

Este é um projeto Java com Spring Boot que simula o gerenciamento de uma biblioteca de livros. Ele permite o cadastro de livros, usuários, além do controle de empréstimos e devoluções.

## 🚀 Funcionalidades

- Cadastro de livros
- Cadastro de usuários
- Empréstimo de livros
- Devolução automática com prazo definido
- Listagem de empréstimos
- Autenticação de login

## 🛠️ Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Lombok
- Maven

## 🏁 Como rodar o projeto

1. **Pré-requisitos:**
   - Java 17+
   - PostgreSQL
   - Maven
   - IDE (Eclipse, IntelliJ ou VS Code)

2. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/BibliotecaLivrosAPI.git
   cd BibliotecaLivrosAPI
   ```

3. **Configure o banco de dados:**

   Altere as configurações de acesso no arquivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

4. **Crie o banco de dados:**

   No PostgreSQL:

   ```sql
   CREATE DATABASE biblioteca;
   ```

5. **Execute o projeto:**

   Na IDE ou via terminal:

   ```bash
   ./mvnw spring-boot:run
   ```

6. **Testar os endpoints:**

   Utilize ferramentas como o Postman ou Insomnia para testar as requisições HTTP.

## 📂 Estrutura de Pastas

```
src/
├── main/
│   ├── java/
│   │   └── com.rmalmeidax.biblioteca/
│   │       ├── controller/
│   │       ├── entity/
│   │       ├── repository/
│   │       ├── service/
│   │       └── DTO/
│   └── resources/
│       └── application.properties
```

## 🤝 Créditos

Este projeto foi desenvolvido com o apoio do [ChatGPT](https://chat.openai.com/) da OpenAI, que auxiliou na criação de código, estrutura do projeto, comentários, boas práticas e documentação.

## 📄 Licença

Este projeto é livre para uso educacional. Sinta-se à vontade para estudar, modificar e aprimorar.
