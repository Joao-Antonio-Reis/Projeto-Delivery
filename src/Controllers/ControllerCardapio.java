package Controllers;

import DAO.ProdutoDAO;
import Models.Produto;
import View.Cardapio;

import java.util.ArrayList;
import java.util.List;

public class ControllerCardapio implements InterfaceController {
    private Cardapio cardapioView;
    private List<Produto> produtos;
    private ArrayList<Produto> produtosMain;

    public ControllerCardapio(Cardapio cardapio, ArrayList<Produto> produtosMain) {
        this.cardapioView = cardapio;
        this.produtosMain = produtosMain;
        initView();
    }

    @Override
    public void initView() {
        cardapioView.setVisible(true);
        carregarCardapio();
    }

    @Override
    public void initController() {
    }

    private void carregarCardapio() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.obterProdutosOrdenados();

        for (Produto produto : produtos) {
            cardapioView.adicionarProduto(produto, e -> adicionarCarrinho(produto));
        }
    }

    private void adicionarCarrinho(Produto produto) {
        produtosMain.add(produto);
        System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
    }
}
