import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<PessoalFisica> listaPf = new ArrayList<>();
        PessoalFisica metodoPf = new PessoalFisica();

        ArrayList<PessoaJuridica> listaPj = new ArrayList<>();
        PessoaJuridica metodoPj = new PessoaJuridica();

        System.out.println("Bem vinde ao sisteme de cadastro de Pessoas Físicas e Jurídicas");

        Scanner leitor = new Scanner(System.in);

        //variavel deve ser criada antes do DO WHILE
        String opcao;

        do {

            System.out.println("escolha uma opção: 1 - Pessoa Física / 2 - Pessoa Jurídica / 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao) {

                case "1":

                    String opcaoPf;

                    do {
                        System.out.println("Digite uma opção: 1 - Cadastrar PF / 2 - Listar PF / 0 - Voltar");
                        opcaoPf = leitor.nextLine();

                        switch (opcaoPf) {

                            case "1":

                                PessoalFisica novaPf = new PessoalFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.println("Digite o nome: ");
                                novaPf.nome = leitor.nextLine();

                                System.out.println("Digite o CPF: ");
                                novaPf.cpf = leitor.nextLine();

                                System.out.println("Digite o rendimento: ");
                                novaPf.rendimento = leitor.nextFloat();

                                System.out.println("Digite a data de nascimento: (dd/mm/aaaa) ");
                                novaPf.dataNasc = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                                Period idade = Period.between(novaPf.dataNasc, LocalDate.now());

                                if (idade.getYears() >= 18) {
                                    System.out.println("idade válida!");
                                } else {
                                    System.out.println("idade inválida");
                                    break;
                                }

                                System.out.println("Digite o logradouro");
                                novoEndPf.logradouro = leitor.next();

                                System.out.println("Digite o número: ");
                                novoEndPf.numero = leitor.nextInt();

                                //leitor.nextLine();
                                System.out.println("Este endereço é comercial: S/N");
                                String endCom = leitor.next();

                                if (endCom.equals("S") || endCom.equals("s")) {
                                    novoEndPf.endComercial = true;
                                } else {
                                    novoEndPf.endComercial = false;
                                }

                                novaPf.endereco = novoEndPf;

                                listaPf.add(novaPf);
                                System.out.println("cadastro realizado com sucesso!");

                                break;

                            case "2":
                                if (listaPf.size() > 0) {

                                    for (PessoalFisica cadaPf : listaPf) {
                                        System.out.println("Nome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Data de Nascimento: " + cadaPf.dataNasc.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
                                        System.out.println("Imposto a ser pago: " + metodoPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println("Endereco: " + cadaPf.endereco.logradouro + "-" + cadaPf.endereco.numero);
                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar");
                                        leitor.nextLine(); //sequencia para dar tempo de digitar e ler

                                    }
                                } else {
                                    System.out.println("Lista Vazia!");
                                }
                                break;

                            case "0":
                                System.out.println("Volta");
                                break;

                            default:
                                System.out.println("Opção Inválida");
                                break;
                        }

                    } while (!opcaoPf.equals("0"));

                    break;

                case "2":

                    String opcaoPj;

                    do {
                        System.out.println("Digite uma opção: 1 - Cadastrar PJ / 2 - Listar PJ / 0 - Voltar");
                        opcaoPj = leitor.nextLine();

                        switch (opcaoPj) {

                            case "1":
                                PessoaJuridica novaPj = new PessoaJuridica();
                                Endereco novoEndPj = new Endereco();

                                System.out.println("Digite o nome: ");
                                novaPj.nome = leitor.nextLine();

                                System.out.println("Digite o CNPJ: ");
                                novaPj.cnpj = leitor.nextLine();

                                System.out.println("Digite o rendimento: ");
                                novaPj.rendimento = leitor.nextFloat();

                                System.out.println("Digite a Razão Social: ");
                                novaPj.razaoSocial = leitor.next();

                                System.out.println("Digite o Logradouro: ");
                                novoEndPj.logradouro = leitor.next();

                                System.out.println("Digite o número: ");
                                novoEndPj.numero = leitor.nextInt();

                                System.out.println("Este endereço é comercial: S/N");
                                String endCom = leitor.next();

                                if (endCom.equals("S") || endCom.equals("s")) {
                                    novoEndPj.endComercial = true;
                                } else {
                                    novoEndPj.endComercial = false;
                                }

                                novaPj.endereco = novoEndPj;

                                listaPj.add(novaPj);
                                System.out.println("Cadastro realizado com sucesso!");

                                break;

                            case "2":

                                if (listaPj.size() > 0) {

                                    for (PessoaJuridica cadaPj : listaPj) {
                                        System.out.println("Nome: " + cadaPj.nome);
                                        System.out.println("CNPJ: " + cadaPj.cnpj);
                                        System.out.println("Razão Social: " + cadaPj.razaoSocial);
                                        System.out.println("Imposto à ser pago: " + metodoPj.CalcularImposto(cadaPj.rendimento));
                                        System.out.println("Endereço: " + cadaPj.endereco.logradouro + "-" + cadaPj.endereco.numero);

                                        System.out.println();
                                        System.out.println("Aperte o ENTER para continuar");
                                        leitor.nextLine();
                                    }

                                } else {
                                    System.out.println("Lista vazia!");
                                }
                                break;

                            case "0":
                                System.out.println("Volta");
                                break;

                            default:
                                System.out.println("Opção Inválida!");
                                break;

                        }


                    } while (!opcaoPj.equals("0"));

                    break;


                case "0":
                    System.out.println("case 0");
                    break;

                default:
                    System.out.println("default");
                    break;
            }

        } while (!opcao.equals("0"));

    }

}