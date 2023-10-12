import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> listaLivro = new ArrayList<>();

        System.out.println("Bem vinde ao sistema de Cadastro de Livros");

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {

            //System.out.println("Bem vinde ao sistema de Cadastro de Livros");
            System.out.println("escolha uma opção: 1 - Cadastrar um livro / 2 - Listar livros / 0 - Sair");

            opcao = leitor.nextLine();

            switch (opcao) {

                case "1":
                    Livro novoLivro = new Livro();
                    Autor novoAutor = new Autor();

                    System.out.println("***Cadastro permitido apenas para livros com mais de 5 anos***");
                    System.out.println("Digite a data de lançamento do livro: (dd/mm/aaaa) ");
                    novoLivro.dataLancamento = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Period idadeLivro = Period.between(novoLivro.dataLancamento, LocalDate.now());

                    if (idadeLivro.getYears() >= 5) {
                        System.out.println("Livro lançado hã mais de 5 anos!!! :) Continue o cadastro!");

                    } else {
                        System.out.println("Não é possível fazer o cadastro! :(  Livro lançado há menos de 5 anos! ");
                        break;
                    }


                    System.out.println("Digite o título");
                    novoLivro.titulo = leitor.next();

                    System.out.println("Digite o nome do Autor: ");
                    novoAutor.nome = leitor.next();

                    System.out.println("Digite local de Nascimento do Autor: (Cidade - Estado");
                    novoAutor.localNasc = leitor.next();

                    System.out.println("Digite o Preço: ");
                    novoLivro.preco = leitor.nextFloat();

                    novoLivro.autor = novoAutor;
                    novoLivro.localNasc = novoAutor;

                    listaLivro.add(novoLivro);
                    System.out.println("cadastro realizado com sucesso!");

                    break;

                case "2":
                    if (listaLivro.size() > 0) {

                        for (Livro cadaLivro : listaLivro) {
                            System.out.println("Ano Lançamento: " + cadaLivro.dataLancamento);
                            System.out.println("Titulo: " + cadaLivro.titulo);
                            System.out.println("Autor: " + cadaLivro.autor.nome);
                            System.out.println("Local de Nascimento do autor: " + cadaLivro.autor.localNasc);
                            System.out.println("Preço: " + cadaLivro.preco);
                            System.out.println();
                            System.out.println("Aperte ENTER para continuar");
                            leitor.nextLine(); //sequencia para dar tempo de digitar e ler
                        }

                        break;


                    } else {
                        System.out.println("Lista Vazia!");

                        break;
                    }


                case "0":
                    System.out.println("Volta");
                    break;

                default:
                    System.out.println("Opção Inválida");
                    break;

            }
        }

        while (!opcao.equals("0"));
    }
}

