package adatech.poo.imdb;

import java.util.Scanner;

public class CatalogoFilmes {

    public static void main(String[] args) {
        Filme[] catalogo = new Filme[10];
        inicializarCatalogo(catalogo);  // Inicializa o array com alguns filmes de exemplo
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n--- Catálogo de Filmes ---");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Cadastrar ator");
            System.out.println("3. Associar atores e diretor a um filme");
            System.out.println("4. Pesquisar filme por nome");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção (1-5): ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarFilme(scanner, catalogo);
                    break;
                case 2:
                    cadastrarAtor(scanner, catalogo);
                    break;
                case 3:
                    associarAtorDiretor(scanner, catalogo);
                    break;
                case 4:
                    pesquisarFilmePorNome(scanner, catalogo);
                    break;
                case 5:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 5);
    }

    // Método para inicializar o array de filmes com alguns exemplos
    static void inicializarCatalogo(Filme[] catalogo) {
        catalogo[0] = new Filme("Cidade de Deus", new Diretor("Fernando Meirelles"), new Ator("Alexandre Rodrigues"));
        catalogo[1] = new Filme("Tropa de Elite", new Diretor("José Padilha"), new Ator("Wagner Moura"));
        catalogo[2] = new Filme("O Auto da Compadecida", new Diretor("Luiz Carlos Barreto"), new Ator("Marco Nanini"));
        catalogo[3] = new Filme("Central do Brasil", new Diretor("Walter Salles"), new Ator("Fernanda Montenegro"));
        catalogo[4] = new Filme("Coraline e o Mundo Secreto", new Diretor("Henry Selick"), new Ator("Dakota Fanning"));
        catalogo[5] = new Filme("O Rei Leão", new Diretor("Roger Allers e Rob Minkoff"), new Ator("Matthew Broderick"));
        catalogo[6] = new Filme("Toy Story", new Diretor("John Lasseter e Lee Unkrich"), new Ator("Tom Hanks"));
        catalogo[7] = new Filme("Up: Altas Aventuras", new Diretor("Pete Docter e Bob Peterson"), new Ator("Ed Asner"));
        catalogo[8] = new Filme("A Viagem de Chihiro", new Diretor("Hayao Miyazaki"), new Ator("Rumi Hiiragi"));
        catalogo[9] = new Filme("O Castelo Animado", new Diretor("Hayao Miyazaki"), new Ator("Chihiro Ogino"));
    }

    static void cadastrarFilme(Scanner scanner, Filme[] catalogo) {
        scanner.nextLine(); // Limpa o buffer do scanner

        System.out.print("Digite o nome do filme: ");
        String nomeFilme = scanner.nextLine();

        System.out.print("Digite o nome do diretor: ");
        String nomeDiretor = scanner.nextLine();
        Diretor diretor = new Diretor(nomeDiretor);

        System.out.print("Digite o nome do ator principal: ");
        String nomeAtor = scanner.nextLine();
        Ator atorPrincipal = new Ator(nomeAtor);

        Filme novoFilme = new Filme(nomeFilme, diretor, atorPrincipal);


        int posicaoVazia = -1;
        for (int i = 0; i < catalogo.length; i++) {
            if (catalogo[i] == null) {
                posicaoVazia = i;
                break;
            }
        }


        if (posicaoVazia != -1) {
            catalogo[posicaoVazia] = novoFilme;
            System.out.println("Filme cadastrado com sucesso!");
        } else {
            System.out.println("Catálogo de filmes está cheio. Não foi possível cadastrar o filme.");
        }
    }

    static void cadastrarAtor(Scanner scanner, Filme[] catalogo) {
        scanner.nextLine(); // Limpa o buffer do scanner

        System.out.print("Digite o nome do ator: ");
        String nomeAtor = scanner.nextLine();

        Ator novoAtor = new Ator(nomeAtor);


        int posicaoVazia = -1;
        for (int i = 0; i < catalogo.length; i++) {
            if (catalogo[i] == null) {
                posicaoVazia = i;
                break;
            }
        }


        if (posicaoVazia != -1) {
            catalogo[posicaoVazia] = new Filme("Ator", null, novoAtor);
            System.out.println("Ator cadastrado com sucesso!");
        } else {
            System.out.println("Catálogo de filmes está cheio. Não foi possível cadastrar o ator.");
        }
    }


    static void associarAtorDiretor(Scanner scanner, Filme[] catalogo) {
        scanner.nextLine(); // Limpa o buffer do scanner

        System.out.print("Digite o nome do filme para associar ator e diretor: ");
        String nomeFilme = scanner.nextLine();


        Filme filmeEncontrado = null;
        for (Filme filme : catalogo) {
            if (filme != null && filme.getNomeFilme().equalsIgnoreCase(nomeFilme)) {
                filmeEncontrado = filme;
                break;
            }
        }

        if (filmeEncontrado != null) {
            System.out.print("Digite o nome do novo ator para associar ao filme: ");
            String nomeNovoAtor = scanner.nextLine();
            Ator novoAtor = new Ator(nomeNovoAtor);

            System.out.print("Digite o nome do novo diretor para associar ao filme: ");
            String nomeNovoDiretor = scanner.nextLine();
            Diretor novoDiretor = new Diretor(nomeNovoDiretor);


            filmeEncontrado.setAtorPrincipal(novoAtor);
            filmeEncontrado.setDiretor(novoDiretor);

            System.out.println("Ator e diretor associados ao filme com sucesso!");
        } else {
            System.out.println("Filme não encontrado no catálogo.");
        }
    }


    static void pesquisarFilmePorNome(Scanner scanner, Filme[] catalogo) {
        scanner.nextLine(); // Limpa o buffer do scanner

        System.out.print("Digite o nome do filme para pesquisa: ");
        String nomePesquisado = scanner.nextLine();

        boolean encontrado = false;
        for (Filme filme : catalogo) {
            if (filme != null && filme.getNomeFilme().equalsIgnoreCase(nomePesquisado)) {
                System.out.println("\nFilme encontrado:");
                exibirDetalhesFilme(filme);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\nFilme não encontrado no catalogo.");
        }
    }

    static void exibirDetalhesFilme(Filme filme) {
        System.out.println("Nome do Filme: " + filme.getNomeFilme());

        Diretor diretor = filme.getDiretor();
        if (diretor != null) {
            System.out.println("Nome do Diretor: " + diretor.getNomeDiretor());
        }

        Ator atorPrincipal = filme.getAtorPrincipal();
        if (atorPrincipal != null) {
            System.out.println("Nome do Ator Principal: " + atorPrincipal.getNomeAtor());
        }
    }

}