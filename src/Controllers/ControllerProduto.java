package Controllers;

import ConexaoDB.CategoriaDAO;
import ConexaoDB.ProdutoDAO;
import View.CadastroProduto;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import Models.Produto;
import View.MenuPrincipalView;

public class ControllerProduto implements ControllerAbstract{
    private CadastroProduto cadastroProdutoView;
    private File selectedFile;
    private File destFile;

    public ControllerProduto() {}

    public ControllerProduto(CadastroProduto cadastroProdutoView) {
        this.cadastroProdutoView = cadastroProdutoView;
        initView();
        initController();
    }

    private void initView() {
        cadastroProdutoView.setVisible(true);
        carregaCategoria();
        carregaProdutos();
    }

    private void initController() {
        cadastroProdutoView.getCadastrarButton().addActionListener(e -> cadastrar());
    }

    private void cadastrar() {
        String nome = cadastroProdutoView.getNome();
        String valor = cadastroProdutoView.getPreco().replace(",", ".");
        BigDecimal preco;
        try {
            preco = new BigDecimal(valor);
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter o preço.");
            return;
        }

        String categoria = cadastroProdutoView.getCategoria();
        String descricao = cadastroProdutoView.getDescricao();
        String caminhoImagem = "Imagens/" + cadastroProdutoView.getCaminhoImagem();
        if (cadastroProdutoView.getSelectedFile() != null) {
            File destFile = new File(caminhoImagem);

            File imagensDir = new File("Imagens/");
            if (!imagensDir.exists()) {
                imagensDir.mkdir();
            }
            try {
                Files.copy(cadastroProdutoView.getSelectedFile().toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                preco = new BigDecimal(valor);
            } catch (NumberFormatException error) {
                System.out.println("Erro ao converter o preço: ");
                error.printStackTrace();
            }

            System.out.println("Produto cadastrado!!");
        } else {
            System.out.println("Adicione uma Imagem para o caminho.");
        }

        ProdutoDAO.inserirProduto(nome, categoria, descricao, preco, caminhoImagem);
        cadastroProdutoView.limparCampos();
        carregaProdutos();
    }

    private void carregaCategoria() {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ArrayList<String> listaCategorias = categoriaDAO.carregarCategoria();
        for (String categoria : listaCategorias) {
            cadastroProdutoView.carregarCategoriaBox(categoria);
        }
    }

    private void carregaProdutos() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.obterProdutosOrdenados();

        for (Produto produto : produtos) {
            cadastroProdutoView.adicionarProdutoParaRemover(produto, e -> removerProduto(produto));
        }
    }

    private void removerProduto(Produto produto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.removerProduto(produto.getNome());
    }
}
