package Models;


public class Cliente{

    private String nome;
    private String telefone;
    private String email;
    private Endereco endereço;

    public Cliente(String nome, String telefone, String email, Endereco endereço) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereço = endereço;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.nome = email;
    }
    public Endereco getEndereço() {
        return endereço;
    }
    public void setEndereço(Endereco endereço) {
        this.endereço = endereço;
    }

}
