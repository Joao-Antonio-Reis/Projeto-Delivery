package Controllers;

import ConexaoDB.ProdutoDAO;
import Models.Produto;
import View.Cardapio;
import java.util.ArrayList;
import java.util.List;

public class ControllerCardapio implements InterfaceController {
    private Cardapio cardapio;
    private List<Produto> produtos;
    private ArrayList<Produto> produtosMain;

    public ControllerCardapio(Cardapio cardapio, ArrayList<Produto> produtosMain) {
        this.cardapio = cardapio;
        this.produtosMain = produtosMain;
        initView();
    }

    @Override
    public void initView() {
        cardapio.setVisible(true);
        carregarCardapio();
    }

    @Override
    public void initController() {
        // Você pode implementar outros eventos de inicialização aqui, se necessário
    }

    private void carregarCardapio() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.obterProdutosOrdenados();

        for (Produto produto : produtos) {
            cardapio.adicionarProduto(produto, e -> adicionarCarrinho(produto));
        }
    }

    private void adicionarCarrinho(Produto produto) {
        if (!produtosMain.contains(produto)) { // Verifique se o produto já não está no carrinho
            produtosMain.add(produto);
            System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
        } else {
            System.out.println("Produto já está no carrinho: " + produto.getNome());
        }
    }
}