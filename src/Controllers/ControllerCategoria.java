package Controllers;

import ConexaoDB.CategoriaDAO;
import Models.Categoria;
import View.CadastroCategoria;

import java.util.ArrayList;

public class ControllerCategoria implements InterfaceController {
    private CadastroCategoria cadastroCategoriaView;

    public ControllerCategoria() {}

    public ControllerCategoria(CadastroCategoria cadastroCategoriaView) {
        this.cadastroCategoriaView = cadastroCategoriaView;
        initView();
        initController();
    }

    public void initView() {
        cadastroCategoriaView.setVisible(true);
        carregaCategoria();
    }

    public void initController() {
        cadastroCategoriaView.getCadastrarButton().addActionListener(e -> cadastrar());
    }

    private void cadastrar() {
        String nome = cadastroCategoriaView.getNomeCategoria();
        String descricao = cadastroCategoriaView.getDescricao();

        if (nome == null || nome.trim().isEmpty() || descricao == null || descricao.trim().isEmpty()) {
            System.out.println("Nome ou descrição não podem estar vazios.");
            return;
        }

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        try {
            categoriaDAO.inserirCategoria(nome, descricao);
            carregaCategoria(); // Atualiza a lista de categorias após a inserção
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar categoria.");
        }
        cadastroCategoriaView.limparCampos();
    }

    private void carregaCategoria() {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ArrayList<Categoria> categorias = categoriaDAO.buscarCategoria();
        cadastroCategoriaView.limparCategoriaParaRemover();

        for (Categoria categoria : categorias) {
            cadastroCategoriaView.adicionarCategoriaParaRemover(categoria, e -> removerCategoria(categoria));
        }
    }

    private void removerCategoria(Categoria categoria) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        try {
            categoriaDAO.apagarCategoria(categoria.getNome());
            carregaCategoria(); // Atualiza a lista de categorias após a remoção
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao remover categoria.");
        }
    }
}
