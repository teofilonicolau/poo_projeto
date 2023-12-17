# Projeto de Catálogo de Filmes IMDb

Esse é um projeto em Java que visa explorar os conceitos de programação orientada a objetos para criar um catálogo de filmes interativo.

).

## Funcionalidades

O sistema permite ao usuário:

1. Cadastrar filmes.
2. Cadastrar atores.
3. Associar um filme com seus atores e diretores.
4. Pesquisar filmes cadastrados pelo nome, desconsiderando letras maiúsculas e minúsculas.

## Observações

- Utilize os conceitos de programação orientada a objetos, como encapsulamento, herança, polimorfismo e classes abstratas.

## Estrutura do Projeto

poo_projeto_catalogo_imdb
|-- .idea
|-- .gitignore
|-- out
|-- src
| |-- imdb
| |-- Ator.java
| |-- CatalogoFilmes.java
| |-- Diretor.java
| |-- Filme.java
|-- .gitignore
|-- poo_projeto_catalogo_imdb.iml


## Classes do Projeto

### Ator

A classe `Ator` representa um ator e possui um atributo `nomeAtor`.

### Diretor

A classe `Diretor` representa um diretor e possui um atributo `nomeDiretor`.

### Filme

A classe `Filme` representa um filme e possui atributos como `nomeFilme`, `diretor` e `atorPrincipal`. Além disso, ela contém métodos para associar diretores e atores ao filme.

### CatalogoFilmes

A classe `CatalogoFilmes` contém o método `main` que inicia a aplicação e interage com o usuário. Ela permite cadastrar filmes, atores, associar atores e diretores a filmes, e pesquisar filmes por nome.

## Utilização

Para executar a aplicação, basta rodar o método `main` na classe `CatalogoFilmes`.


