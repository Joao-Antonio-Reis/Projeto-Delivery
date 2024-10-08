package Models;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class Pedido {
    private Cliente cliente;
    private Produto produto;
    private ArrayList<Produto> lista_produtos;
    private Double valor_Total_Pedido;
    private String forma_Pagamento;
    private boolean entregar;
    private String observacao;

    public Pedido(Cliente cliente, ArrayList<Produto> lista_produtos, Double valor_Total_Pedido,
                  String forma_Pagamento, boolean entrega, String observacao) {
        this.cliente = cliente;
        this.lista_produtos = lista_produtos;
        this.valor_Total_Pedido = valor_Total_Pedido;
        this.forma_Pagamento = forma_Pagamento;
        this.entregar = entrega;
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public ArrayList<Produto> getLista_produtos() {
        return lista_produtos;
    }
    public void setLista_produtos(ArrayList<Produto> lista_produtos) {
        this.lista_produtos = lista_produtos;
    }
    public Double getValor_Total_Pedido() {
        return valor_Total_Pedido;
    }
    public void setValor_Total_Pedido(Double valor_Total_Pedido) {
        this.valor_Total_Pedido = valor_Total_Pedido;
    }
    public String getForma_Pagamento() {
        return forma_Pagamento;
    }
    public void setForma_Pagamento(String forma_Pagamento) {
        this.forma_Pagamento = forma_Pagamento;
    }
    public boolean isEntregar() {
        return entregar;
    }

    public String getObservacao() {
        return observacao;
    }
}
