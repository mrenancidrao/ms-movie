# Desafio Java

# 🚨 Requisitos

- A API deve ser construída em Java (8 ou superior) utilizando Spring Framework (2.2 ou superior)
- Implementar autenticação seguindo o padrão ***JWT***, lembrando que o token a ser recebido deve estar no formado ***Bearer***
- Implementar operações no banco de dados utilizando ***Spring Data JPA*** & ***Hibernate***
- **Bancos relacionais permitidos**
    - *MySQL* (prioritariamente)
    - *PostgreSQL*
- As entidades deversão ser criadas como tabelas utilizando a ferramenta de migração **Flyway**. Portanto, os scripts de **migrations** para geração das tabelas devem ser enviados no teste
- Sua API deverá seguir os padrões REST na construção das rotas e retornos
- Sua API deverá conter documentação viva utilizando a *OpenAPI Specification* (**Swagger**)
- Caso haja alguma particularidade de implementação, instruções para execução do projeto deverão ser enviadas

# 🎁 Extra

- Testes unitários
- Teste de integração da API em linguagem de sua preferência (damos importância para pirâmide de testes)
- Cobertura de testes utilizando Sonarqube
- Utilização de *Docker* (enviar todos os arquivos e instruções necessárias para execução do projeto)
- Estrutura do projeto
- Utilização de código limpo e princípios **SOLID**
- Segurança da API, como autenticação, senhas salvas no banco, *SQL Injection* e outros
- Boas práticas da Linguagem/Framework

# 🖥 O que desenvolver?

Criar uma API que o site [IMDb](https://www.imdb.com/) irá consultar para exibir seu conteúdo, sua API deverá conter as seguintes funcionalidades:

- Administrador
    - Cadastro
    - Edição
    - Exclusão lógica (desativação)
    - Listagem de usuários não administradores ativos
        - Opção de trazer registros paginados
        - Retornar usuários por ordem alfabética
- Usuário
    - Cadastro
    - Edição
    - Exclusão lógica (desativação)
- Filmes
    - Cadastro (somente um usuário administrador poderá realizar esse cadastro)
    - Voto (a contagem de votos será feita por usuário de 0-4 que indica quanto o usuário gostou do filme)
    - Listagem
        - Opção de filtros por diretor, nome, gênero e/ou atores
        - Opção de trazer registros paginados
        - Retornar a lista ordenada por filmes mais votados e por ordem alfabética
    - Detalhes do filme trazendo todas as informações sobre o filme, inclusive a média dos votos

**Obs.:** 

**Apenas os usuários poderão votar nos filmes e a API deverá validar quem é o usuário que está acessando, ou seja, se é um usuário administrador ou não.**

**Caso não consiga concluir todos os itens propostos, é importante que nos envie a implementação até onde foi possível para que possamos avaliar**
