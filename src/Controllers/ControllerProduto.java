package Controllers;

import ConexaoDB.CategoriaDAO;
import ConexaoDB.ProdutoDAO;
import View.CadastroProduto;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ControllerProduto {
    private CadastroProduto cadastroProdutoView;

    public ControllerProduto (){};

    public ControllerProduto(CadastroProduto cadastroProdutoView) {
        this.cadastroProdutoView = cadastroProdutoView;

        initView();
        initController();
    }

    private void initView(){
        cadastroProdutoView.setVisible(true);
    }
    private void initController(){
        cadastroProdutoView.getCadastrarButton().addActionListener(e -> cadastrar());
    }

    private void cadastrar(){
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

        ProdutoDAO.inserirProduto(nome, categoria, descricao, preco, caminhoImagem);

        cadastroProdutoView.limparCampos();
    }

    private void removerProdutoButton(){

    }

    public void carregaCategoria(){
        CategoriaDAO categoria = new CategoriaDAO();
        ArrayList<String> listaCategorias = categoria.carregarCategoria();

        for (String string : listaCategorias) {
            cadastroProdutoView.carregarCategoriaBox(string);
        }
    }

}
