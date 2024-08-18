package Controllers;

import Models.Cliente;
import Models.Produto;
import View.Carrinho;
import View.ClientForm;
import View.MenuPrincipalView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class ControllerCarrinho implements InterfaceController {
    private Carrinho carrinhoView;
    private MenuPrincipalView menuView;
    private DefaultTableModel tableModel;
    private ArrayList<Produto> produtosMain;
    private double valorTotal = 0.0;
    private final double custoEntrega = 5.0;
    private boolean entregaAdicionada = false;

    public ControllerCarrinho(Carrinho carrinhoView, ArrayList<Produto> produtosMain, MenuPrincipalView menuView) {
        this.carrinhoView = carrinhoView;
        this.produtosMain = produtosMain;
        this.menuView = menuView;
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
        carrinhoView.getSubmitButton().addActionListener(e -> cadastroCliente());

        carrinhoView.getEntregaCheckBox().addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                adicionarEntrega();
            } else {
                removerEntrega();
            }
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
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

    private void cadastroCliente() {
        ClientForm clientForm = new ClientForm();
        String formaPagamento  =carrinhoView.getFormaPagamentoSelecionada();
        String observacao = carrinhoView.getObservacaoArea().getText();
        ControllerClientForm controllerClientForm = new ControllerClientForm(clientForm, produtosMain, valorTotal,entregaAdicionada, formaPagamento, observacao);
        menuView.changeContent(clientForm);
    }
}
