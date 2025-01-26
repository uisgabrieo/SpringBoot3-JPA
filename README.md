# Back-End com Spring e JPA

Este projeto foi desenvolvido como parte dos meus estudos iniciais em Spring e JPA, realizado durante um curso na plataforma Udemy. Ele simula um sistema de gerenciamento de usuários, pedidos, produtos e categorias, implementando conceitos fundamentais de desenvolvimento back-end com Java e o framework Spring, utilizando o JPA para a persistência de dados.

Foi desenvolvido no curso Java COMPLETO Programação Orientada a Objetos + Projetos; Prof Nelio Alves.

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Spring Framework**: Para facilitar a criação de aplicações robustas e escaláveis.
  - Spring Boot: Configurações simplificadas para inicialização do projeto.
  - Spring Data JPA: Integração com o JPA para manipulação de dados.
  - Spring Web: Para criação de APIs REST.
- **Banco de Dados**:
  - Utilizado para armazenamento persistente dos dados.
  - **H2 Database**: Banco de dados em memória para testes.
- **Maven**: Gerenciador de dependências.

## Funcionalidades

- Criação, leitura, atualização e exclusão (CRUD) de entidades no banco de dados.
- Exposição de endpoints RESTful para interação com o cliente.
- Uso de padrões de projeto como MVC (Model-View-Controller).

## Estrutura do Projeto

O projeto segue uma estrutura simples e organizada para facilitar a compreensão:

```
src/main/java/
|-- com.example.project
    |-- configuration/      # Criação das entidades fictícias
    |-- resource/           # Contêm os controladores REST
    |-- entities/           # Contêm as entidades do banco de dados
    |-- repository/         # Interfaces para acesso aos dados
    |-- service/            # Lógica de negócios
```

## Endpoints Principais

- **GET /users**: Retorna todos os usuários cadastrados.
- **GET /users/{id}**: Retorna um usuário específico pelo ID.
- **POST /users**: Cria um novo usuário.
- **PUT /users/{id}**: Atualiza os dados de um usuário existente.
- **DELETE /users/{id}**: Remove um usuário pelo ID.

- **GET /orders**: Retorna todos os pedidos.
- **GET /orders/{id}**: Retorna os detalhes de um pedido específico.

- **GET /products**: Retorna todos os produtos disponíveis.
- **GET /products/{id}**: Retorna os detalhes de um produto específico.

- **GET /categories**: Retorna todas as categorias de produtos.
- **GET /categories/{id}**: Retorna os detalhes de uma categoria específica.

## Aprendizados

Durante o desenvolvimento deste projeto, aprofundei meu conhecimento nos seguintes tópicos:

- Configuração e inicialização de projetos Spring.
- Uso do Spring Data JPA para manipulação de dados.
- Implementação de APIs RESTful.
- Configuração de um banco de dados H2 para testes.

## Considerações

Este projeto foi uma experiência enriquecedora para explorar o ecossistema Spring, abrangendo desde a configuração inicial até a implementação de funcionalidades completas para manipulação de dados. Ele proporcionou uma base sólida em desenvolvimento back-end e me ajudou a compreender melhor os padrões de projeto, bem como a importância de uma estrutura organizada e de boas práticas no código. Este aprendizado será valioso para futuros projetos mais avançados.
