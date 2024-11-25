import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class usuario {
    public final String nome;
    public int idade;

    public usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }
    
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade;
    }
}

public class Prova {
    public static ArrayList<usuario> usuarios = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastro de usuário");
            System.out.println("2. Listagem de usuários");
            System.out.println("3. Exclusão de usuário");
            System.out.println("4. Ordenar lista por idade");
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
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static void cadastrarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do usuário: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        usuarios.add(new usuario(nome, idade));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("\nLista de usuários:");
            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println((i + 1) + ". " + usuarios.get(i));
            }
        }
    }

    private static void excluirUsuario() {
        listarUsuarios();
        if (!usuarios.isEmpty()) {
            System.out.print("Digite o número do usuário que deseja excluir: ");
            int indice = scanner.nextInt();
            scanner.nextLine();

            if (indice > 0 && indice <= usuarios.size()) {
                usuarios.remove(indice - 1);
                System.out.println("Usuário excluído com sucesso!");
            } else {
                System.out.println("Número inválido. Tente novamente.");
            }
        }
    }

    private static void ordenarPorIdade() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado para ordenar.");
        } else {

            usuarios.sort(Comparator.comparingInt(usuario::getIdade));
            System.out.println("Lista de usuários ordenada por idade!");
            listarUsuarios();
        }
    }
}
