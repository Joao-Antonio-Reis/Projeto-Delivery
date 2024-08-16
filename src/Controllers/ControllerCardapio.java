package Controllers;

import DAO.ProdutoDAO;
import Models.Produto;
import View.Cardapio;

import java.util.ArrayList;
import java.util.List;

// Controlador para gerenciar a exibição do cardápio e a interação com ele
public class ControllerCardapio implements InterfaceController {
    // Referência à interface de exibição do cardápio
    private Cardapio cardapioView;
    // Lista de produtos obtidos do banco de dados
    private List<Produto> produtos;
    // Lista principal de produtos no carrinho
    private ArrayList<Produto> produtosMain;

    // Construtor que inicializa a vista do cardápio e a lista de produtos do carrinho
    public ControllerCardapio(Cardapio cardapio, ArrayList<Produto> produtosMain) {
        this.cardapioView = cardapio;
        this.produtosMain = produtosMain;
        initView();  // Inicializa a vista ao criar o controlador
    }

    @Override
    public void initView() {
        // Torna a interface do cardápio visível
        cardapioView.setVisible(true);
        // Carrega os produtos no cardápio
        carregarCardapio();
    }

    @Override
    public void initController() {
    }

    // Método para carregar os produtos do cardápio a partir do banco de dados
    private void carregarCardapio() {
        ProdutoDAO produtoDAO = new ProdutoDAO();  // Cria uma instância do DAO para acessar os produtos
        produtos = produtoDAO.obterProdutosOrdenados();  // Obtém a lista de produtos ordenados do banco de dados

        // Adiciona cada produto à interface do cardápio com um evento para adicionar ao carrinho
        for (Produto produto : produtos) {
            cardapioView.adicionarProduto(produto, e -> adicionarCarrinho(produto));
        }
    }

    // Método para adicionar um produto ao carrinho
    private void adicionarCarrinho(Produto produto) {
        // Verifica se o produto já não está no carrinho
        if (!produtosMain.contains(produto)) {
            produtosMain.add(produto);  // Adiciona o produto ao carrinho
            System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
        } else {
            System.out.println("Produto já está no carrinho: " + produto.getNome());
        }
    }
}
