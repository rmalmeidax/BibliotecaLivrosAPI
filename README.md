📚 BibliotecaLivrosAPI

API REST desenvolvida em Java com Spring Boot para gerenciamento de uma biblioteca, permitindo o cadastro de livros, autores, usuários, empréstimos e devoluções.

🚀 Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Spring Security + JWT
- Maven
- Lombok
- Swagger UI

📁 Estrutura de Pacotes

- controller – Endpoints da API
- service – Regras de negócio
- repository – Persistência com Spring Data
- entity – Entidades do banco de dados
- DTO – Objetos de transferência de dados
- mapper – Conversão entre entidades e DTOs
- security – Autenticação com JWT

▶️ Como Executar

1. Clone o repositório:

    git clone https://github.com/seu-usuario/BibliotecaLivrosAPI.git

2. Configure o banco PostgreSQL:

    CREATE DATABASE biblioteca;

3. Altere as configurações no application.properties (usuário, senha, etc).

4. Compile e execute:

    ./mvnw spring-boot:run

5. Acesse a documentação Swagger em:
   http://localhost:8080/swagger-ui.html

✅ Funcionalidades

- Cadastro, listagem e atualização de livros
- Gerenciamento de autores
- Controle de usuários e autenticação JWT
- Registro de empréstimos e devoluções
- Filtros e paginação

🙏 Agradecimentos

Este projeto foi desenvolvido com apoio do ChatGPT da OpenAI, que forneceu sugestões, explicações de erros e boas práticas para arquitetura Java com Spring Boot.

📝 Licença

Este projeto é livre para uso educacional. Sinta-se à vontade para estudar, modificar e aprimorar.
