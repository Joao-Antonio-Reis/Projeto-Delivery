package Generics;

public class Cliente {
    
    private String nome;
    private String telefone;
    private Endereco endereço;

    public Cliente(String nome, String telefone, Endereco endereço) {
        this.nome = nome;
        this.telefone = telefone;
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
    public Endereco getEndereço() {
        return endereço;
    }
    public void setEndereço(Endereco endereço) {
        this.endereço = endereço;
    }

    public void informacaoCliente(Cliente cliente) {
        System.out.println(cliente.getNome());
        System.out.println(cliente.getTelefone());
        System.out.println(cliente.getEndereço().getBairro());
        System.out.println(cliente.getEndereço().getRua());
        System.out.println(cliente.getEndereço().getNumero());
        System.out.println(cliente.getEndereço().getComplemento());
    }

}
