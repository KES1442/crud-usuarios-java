package Test;

import java.util.ArrayList;
import java.util.Scanner;

import CadastroUser.MetodosCadastro;
import User.User;

public class CadastrarUser {
    public static void main(String[] args) {
        //criar usuarios, listar usuarios, atualizar usuario, e deletar usuario.

        MetodosCadastro metodos = new MetodosCadastro();
        ArrayList<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        int option;

        do{
            System.out.println("======== Menu ========");
            System.out.println("1 - Criar usuario");
            System.out.println("2 - Listar usuarios");
            System.out.println("3 - Atualizar usuario");
            System.out.println("4 - Deletar usuario");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    metodos.create(users);
                    break;
                
                case 2:
                    metodos.list(users);
                    break;

                case 3:
                    metodos.update(users);
                    break;

                case 4:
                    metodos.delete(users);
                    break;

                case 0:
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while( option != 0);
    scanner.close();
    }
}