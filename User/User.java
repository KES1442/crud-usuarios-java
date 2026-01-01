package User;

public class User {
    // os usuarios deve ter Id, nome, e-mail

    private int id;
    private String nome;
    private String email;
    
    public User(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public User() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id - " + id + " | Nome - " + nome + "| Email - " + email;
    }

    
}
