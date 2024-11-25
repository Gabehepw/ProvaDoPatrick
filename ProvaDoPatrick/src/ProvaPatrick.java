import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProvaPatrick {
    public static ArrayList<usuario> usuarios = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastro de Usuário");
            System.out.println("2. Listagem de Usuários");
            System.out.println("3. Exclusão de Usuário");
            System.out.println("4. Ordenar Lista por Idade");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    excluirUsuario();
                    break;
                case 4:
                    ordenarPorIdade();
                    break;
                case 5:
                    System.out.println("Encerrando o Programa...");
                    break;
                default:
                    System.out.println("\nOpção Inválida, tente novamente :D");
            }
        } while (opcao != 5);
    }

    private static void cadastrarUsuario() {
        System.out.print("\nDigite o Nome do Usuário: ");
        String nome = scanner.nextLine();
        System.out.print("\nDigite a Idade do Usuário: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        usuarios.add(new usuario(nome, idade));
        System.out.println("\nUsuário Cadastrado com Sucesso!");
    }

    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("\nNenhum Usuário Cadastrado.");
        } else {
            System.out.println("\nLista de Usuários:");
            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println((i + 1) + ". " + usuarios.get(i));
            }
        }
    }

    private static void excluirUsuario() {
        listarUsuarios();
        if (!usuarios.isEmpty()) {
            System.out.print("\nDigite o Número do Usuário que Deseja Excluir: ");
            int indice = scanner.nextInt();
            scanner.nextLine();

            if (indice > 0 && indice <= usuarios.size()) {
                usuarios.remove(indice - 1);
                System.out.println("\nUsuário Excluído com Sucesso!");
            } else {
                System.out.println("\nNúmero Inválido, tente novamente :D");
            }
        }
    }

    private static void ordenarPorIdade() {
        if (usuarios.isEmpty()) {
            System.out.println("\nNenhum Usuário Cadastrado para Ordenar.");
        } else {

            usuarios.sort(Comparator.comparingInt(usuario::getIdade));
            System.out.println("\nLista de Usuários Ordenada por Idade!");
            listarUsuarios();
        }
    }
}
