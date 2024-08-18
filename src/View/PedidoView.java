package View;

import Models.Cliente;
import Models.Pedido;
import Models.Produto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PedidoView extends JFrame {
    private Pedido pedido;
    private ArrayList<Produto> produtosMain;

    public PedidoView(Pedido pedido, ArrayList<Produto> produtosMain) {
        this.pedido = pedido;
        this.produtosMain = produtosMain;
        frame();
    }
    public void frame() {
        JFrame frame = new JFrame();
        setTitle("Pedido");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 800);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(30, 1,10,10));
        add(panel);

        JLabel nomeCLiente = new JLabel("Nome: "+ pedido.getCliente().getNome());
        panel.add(nomeCLiente);
        JLabel telefone = new JLabel("Telefone: "+ pedido.getCliente().getTelefone());
        panel.add(telefone);
        JLabel email = new JLabel("Email: "+ pedido.getCliente().getEmail());
        panel.add(email);

        if (pedido.isEntregar()){
            panel.add(new JLabel(""));
            JLabel labelEntregar = new JLabel("Entregar");
            panel.add(labelEntregar);
            labelEntregar.setFont(new Font("Arial", Font.BOLD, 14));
            JLabel ruaCliente = new JLabel("Rua: "+pedido.getCliente().getEndereço().getRua());
            panel.add(ruaCliente);
            JLabel numeroCliente = new JLabel("Numero: "+ pedido.getCliente().getEndereço().getNumero());
            panel.add(numeroCliente);
            JLabel bairroCliente = new JLabel("Bairro: "+ pedido.getCliente().getEndereço().getBairro());
            panel.add(bairroCliente);
            JLabel complementoCliente = new JLabel("Complemento: "+ pedido.getCliente().getEndereço().getComplemento());
            panel.add(complementoCliente);
            panel.add(new JLabel());
        }
        JLabel produtos = new JLabel("Produtos");
        produtos.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(produtos);
        for (Produto produto: produtosMain){
            JLabel labelProduto = new JLabel(produto.getNome());
            panel.add(labelProduto);
        }

        panel.add(new JLabel());
        JLabel observacao = new JLabel("Observação do pedido");
        observacao.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(observacao);
        JLabel observacaoConteudo = new JLabel(pedido.getObservacao());
        panel.add(observacaoConteudo);

        panel.add(new JLabel(""));
        JLabel valorTotal = new JLabel("Valor total: "+ String.format("%.2f", pedido.getValor_Total_Pedido()));
        panel.add(valorTotal);
        JLabel formaPagamento = new JLabel("Forma de pagamento: "+ pedido.getForma_Pagamento());
        panel.add(formaPagamento);

        setVisible(true);
        produtosMain.clear();
    }

}
