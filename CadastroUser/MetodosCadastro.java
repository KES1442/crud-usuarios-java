package CadastroUser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Test.CadastrarUser;
import User.User;

public class MetodosCadastro {
    //criar usuarios, listar usuarios, atualizar usuario, e deletar usuario.
    ArrayList<User> users;
    Scanner scanner = new Scanner(System.in);
    static int idnext = 1;
    
    public void create(ArrayList<User> users){
        System.out.println("Digite o nome do usuario: ");
        String name = scanner.nextLine();
        System.out.println("Digite o email: ");
        String email = scanner.nextLine();

        User user = new User(idnext++, name, email);
        users.add(user);

        System.out.println("Usuario criado com sucesso!");
        
    }

    public void list(ArrayList<User> users){
        if(users.isEmpty()){
            System.out.println("Sem Usuários");
            
        }
        for (User user : users){
            System.out.println(user);
        }
    
    }

    public void update(ArrayList<User> users){
        
        boolean atualizado = false;

        System.out.print("Digite o id do usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        for ( User u : users) {
            if (u.getId() == id) {
                System.out.println("Digite o novo nome de usuario: ");
                String newname = scanner.nextLine();
                u.setNome(newname);
                System.out.println("Digite o novo email: ");
                String newemail = scanner.nextLine();
                u.setEmail(newemail);
                System.out.println("Atualizado com sucesso!");
                
            }
        }
        if(!atualizado){
            System.out.println("Usuario nao encontrado");
        }
    
    }

    public void delete(ArrayList<User> users){
        System.out.print("Digite o id do usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Iterator<User> it = users.iterator();

        boolean removido = false;

        while(it.hasNext()){
            User u = it.next();
            if(u.getId() == id){
                System.out.println(u);
                System.out.println("Deseja deletar esse usuario? [S/N] ");
                String del = scanner.nextLine(); 
                if (del.equalsIgnoreCase("S")){
                    it.remove();
                    removido = true;
                    System.out.println("Usuario removido com sucesso!");
                }

            }
        }
        if (!removido){
            System.out.println("Não é possivel deletar usuario!");
        }
        
       
    }


}
