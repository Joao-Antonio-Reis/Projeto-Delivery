package Models;


public class Endereco {
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    
    public Endereco(String bairro, String rua, String numero, String complemento) {
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }
    
    public Endereco() {
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }
}
