package CadastroUser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


import User.User;

public class MetodosCadastro {
    //criar usuarios, listar usuarios, atualizar usuario, e deletar usuario.

    //POSSIVEIS MELHORIAS: validação de entrada (impedir email duplicado ("Feito"), nome e/ou email nao podem ficar vazios) | Busca de usuario -> nao só por id mas tambem por nome ou email | ordenação -> Colocar os usuarios em ordem alfabetica.
    //POSSIVEIS NOVAS FUNCIONALIDADES: Gerar ID's automaticos mais seguros | salvar/ler arquivo (persistencia) 
    //POSSIVEIS ATUALIZAÇÕES DE PROJETO FUTUROS: Passar para SpringBoot e tornar uma API REST e banco de dados (Postgres ou mysql) 

    
    ArrayList<User> users;
    Scanner scanner = new Scanner(System.in);
    static int idnext = 1;
    
    public void create(ArrayList<User> users){
        
        
        System.out.println("Digite o nome do usuario: ");
        String name = scanner.nextLine();
        
        //Impedir campo nome vazio

        if(name.isBlank()){
            System.out.println("Usuario Inválido, o campo nao pode estar vazio!");
            return;
        }

        System.out.println("Digite o email: ");
        String email = scanner.nextLine();

        //Impedir campo email vazio

        if(email.isBlank()){
            System.out.println("Email Inválido, o campo nao pode estar vazio!");
            return;
        }
        
        //Impedir email duplicado
        
        for (User user : users){
            if(email.equals(user.getEmail())){
                System.out.println("Nao é possivel criar usuario, email ja existente!");
                return;
            }
         }
        
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
                
                //Impedir campo nome vazio
                
                if(newname.isBlank()){
                    System.out.println("Usuario inválido, o campo nao pode estar vazio!");
                    return;
                }

                System.out.println("Digite o novo email: ");
                String newemail = scanner.nextLine();
                
                //Impedir campo email vazio
                
                if(newemail.isBlank()){
                    System.out.println("Email inválido, o campo nao pode estar vazio!");
                    return;
                }

                //impedir email duplicado 

                for (User user : users){
                    if(newemail.equals(user.getEmail()) && user.getId() != u.getId()){
                        System.out.println("Nao é possivel atualizar usuario, email ja existente!");
                        return;
                    }
                }

            u.setNome(newname);
            u.setEmail(newemail);
            System.out.println("Atualizado com sucesso!");
            atualizado = true;
                
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
            System.out.println("ID inválido, não é possivel deletar usuario!");
        }
        
       
    }


}
