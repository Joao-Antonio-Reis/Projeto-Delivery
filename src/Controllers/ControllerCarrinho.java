package Controllers;

import Models.Produto;
import View.Carrinho;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

// Controlador para gerenciar a interface e a lógica do carrinho de compras
public class ControllerCarrinho implements InterfaceController {
    private Carrinho carrinhoView;  // Interface gráfica do carrinho
    private DefaultTableModel tableModel;  // Modelo de tabela para exibir produtos no carrinho
    private ArrayList<Produto> produtosMain;  // Lista principal de produtos no carrinho
    private double valorTotal = 0.0;  // Valor total dos produtos no carrinho
    private final double custoEntrega = 5.0;  // Custo fixo de entrega
    private boolean entregaAdicionada = false;  // Rastreador de status da entrega

    // Construtor que inicializa a vista do carrinho e a lista de produtos
    public ControllerCarrinho(Carrinho carrinhoView, ArrayList<Produto> produtosMain) {
        this.carrinhoView = carrinhoView;
        this.produtosMain = produtosMain;
        initView();  // Inicializa a interface gráfica
        initController();  // Inicializa controladores e eventos
    }

    @Override
    public void initView() {
        carrinhoView.setVisible(true);  // Torna a interface do carrinho visível
        tableModel = (DefaultTableModel) carrinhoView.getTabelaProdutos().getModel();  // Obtém o modelo de tabela
        atualizarTabela();  // Atualiza a tabela com produtos atuais
        atualizarValorTotal();  // Atualiza o valor total do carrinho
    }

    @Override
    public void initController() {
        // Adiciona um ouvinte de ação ao botão de finalização de compra
        carrinhoView.getSubmitButton().addActionListener(e -> finalizarCompra());

        // Adiciona ou remove o custo de entrega baseado na seleção do checkbox de entrega
        carrinhoView.getEntregaCheckBox().addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                adicionarEntrega();  // Adiciona o custo de entrega
            } else {
                removerEntrega();  // Remove o custo de entrega
            }
        });
    }

    // Atualiza a tabela de produtos na interface gráfica
    private void atualizarTabela() {
        tableModel.setRowCount(0);  // Limpa a tabela antes de atualizar
        for (Produto produto : produtosMain) {
            // Adiciona cada produto como uma nova linha na tabela
            tableModel.addRow(new Object[]{produto.getNome(), "R$" + String.format("%.2f", produto.getValor())});
        }
    }

    // Calcula e atualiza o valor total dos produtos no carrinho
    private void atualizarValorTotal() {
        // Soma o valor de todos os produtos no carrinho
        double total = produtosMain.stream().mapToDouble(Produto::getValor).sum();
        if (entregaAdicionada) {
            total += custoEntrega;  // Adiciona o custo de entrega se aplicável
        }
        valorTotal = total;  // Atualiza o valor total
        // Atualiza a label na interface gráfica para mostrar o valor total
        carrinhoView.getValorFinalLabel().setText("Valor total: R$" + String.format("%.2f", valorTotal));
    }

    // Método para adicionar um produto ao carrinho
    private void adicionarProduto(String nome, double preco) {
        produtosMain.add(new Produto(nome, preco));  // Adiciona um novo produto à lista
        tableModel.addRow(new Object[]{nome, "R$" + preco});  // Adiciona o produto à tabela na interface
        atualizarValorTotal();  // Atualiza o valor total do carrinho
    }

    // Adiciona o custo de entrega ao valor total
    private void adicionarEntrega() {
        if (!entregaAdicionada) {
            entregaAdicionada = true;  // Marca entrega como adicionada
            atualizarValorTotal();  // Atualiza o valor total
        }
    }

    // Remove o custo de entrega do valor total
    private void removerEntrega() {
        if (entregaAdicionada) {
            entregaAdicionada = false;  // Marca entrega como não adicionada
            atualizarValorTotal();  // Atualiza o valor total
        }
    }

    // Finaliza a compra, realizando ações necessárias após o usuário confirmar a compra
    private void finalizarCompra() {
        // Obtém a forma de pagamento selecionada pelo usuário
        String formaPagamento = carrinhoView.getFormaPagamentoSelecionada();
        System.out.println("Compra finalizada com pagamento via: " + formaPagamento);
        // Imprime a observação adicionada pelo usuário
        System.out.println("Observação: " + carrinhoView.getObservacao());

        // Limpa os produtos do carrinho após a compra ser finalizada
        produtosMain.clear();
        tableModel.setRowCount(0);  // Limpa a tabela de produtos na interface
        atualizarValorTotal();  // Atualiza o valor total para refletir o carrinho vazio
    }
}
