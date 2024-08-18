package Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Historico {
    private int id;
    private int idCliente;
    private LocalDateTime dataCadastro;
    private BigDecimal valor;
    private String formaPagamento;

    public Historico(int id, int idCliente, LocalDateTime dataCadastro, BigDecimal valor, String formaPagamento) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataCadastro = dataCadastro;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
