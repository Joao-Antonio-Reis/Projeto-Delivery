package Controllers;

import Models.Produto;
import View.Carrinho;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class ControllerCarrinho implements InterfaceController {
    private Carrinho carrinhoView;
    private DefaultTableModel tableModel;
    private ArrayList<Produto> produtosMain;
    private double valorTotal = 0.0;
    private final double custoEntrega = 5.0;
    private boolean entregaAdicionada = false; // Rastreador de status da entrega

    public ControllerCarrinho(Carrinho carrinhoView, ArrayList<Produto> produtosMain) {
        this.carrinhoView = carrinhoView;
        this.produtosMain = produtosMain;
        initView();
        initController();
    }

    @Override
    public void initView() {
        carrinhoView.setVisible(true);
        tableModel = (DefaultTableModel) carrinhoView.getTabelaProdutos().getModel();
        atualizarTabela();
        atualizarValorTotal();
    }

    @Override
    public void initController() {
        carrinhoView.getSubmitButton().addActionListener(e -> finalizarCompra());

        // Adiciona ou remove o custo de entrega baseado na seleção do checkbox
        carrinhoView.getEntregaCheckBox().addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                adicionarEntrega();
            } else {
                removerEntrega();
            }
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa a tabela antes de atualizar
        for (Produto produto : produtosMain) {
            tableModel.addRow(new Object[]{produto.getNome(), "R$" + String.format("%.2f", produto.getValor())});
        }
    }

    private void atualizarValorTotal() {
        double total = produtosMain.stream().mapToDouble(Produto::getValor).sum();
        if (entregaAdicionada) {
            total += custoEntrega;
        }
        valorTotal = total;
        carrinhoView.getValorFinalLabel().setText("Valor total: R$" + String.format("%.2f", valorTotal));
    }

    private void adicionarProduto(String nome, double preco) {
        produtosMain.add(new Produto(nome, preco));
        tableModel.addRow(new Object[]{nome, "R$" + preco});
        atualizarValorTotal();
    }

    private void adicionarEntrega() {
        if (!entregaAdicionada) {
            entregaAdicionada = true;
            atualizarValorTotal();
        }
    }

    private void removerEntrega() {
        if (entregaAdicionada) {
            entregaAdicionada = false;
            atualizarValorTotal();
        }
    }

    private void finalizarCompra() {
        // Lógica para finalizar a compra
        String formaPagamento = carrinhoView.getFormaPagamentoSelecionada();
        System.out.println("Compra finalizada com pagamento via: " + formaPagamento);
        System.out.println("Observação: " + carrinhoView.getObservacao());

        // Limpa os produtos após a compra ser finalizada
        produtosMain.clear();
        tableModel.setRowCount(0);
        atualizarValorTotal();
    }
}
