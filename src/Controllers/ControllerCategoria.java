package Controllers;

import DAO.CategoriaDAO;
import Models.Categoria;
import View.CadastroCategoria;

import java.util.ArrayList;

// Controlador para gerenciar a interface e a lógica de cadastro de categorias
public class ControllerCategoria implements InterfaceController {
    private CadastroCategoria cadastroCategoriaView;  // Interface gráfica para cadastro de categorias

    // Construtor padrão
    public ControllerCategoria() {}

    // Construtor que inicializa a interface de cadastro de categorias
    public ControllerCategoria(CadastroCategoria cadastroCategoriaView) {
        this.cadastroCategoriaView = cadastroCategoriaView;
        initView();  // Inicializa a interface gráfica
        initController();  // Inicializa controladores e eventos
    }

    @Override
    public void initView() {
        cadastroCategoriaView.setVisible(true);  // Torna a interface de cadastro visível
        carregaCategoria();  // Carrega as categorias na interface
    }

    @Override
    public void initController() {
        // Adiciona um ouvinte de ação ao botão de cadastro para criar novas categorias
        cadastroCategoriaView.getCadastrarButton().addActionListener(e -> cadastrar());
    }

    // Método para cadastrar uma nova categoria
    private void cadastrar() {
        String nome = cadastroCategoriaView.getNomeCategoria();  // Obtém o nome da categoria
        String descricao = cadastroCategoriaView.getDescricao();  // Obtém a descrição da categoria

        // Valida se nome ou descrição estão vazios
        if (nome == null || nome.trim().isEmpty() || descricao == null || descricao.trim().isEmpty()) {
            System.out.println("Nome ou descrição não podem estar vazios.");
            return;
        }

        CategoriaDAO categoriaDAO = new CategoriaDAO();  // Instância do DAO para interagir com o banco de dados
        try {
            categoriaDAO.inserirCategoria(nome, descricao);  // Insere a nova categoria no banco de dados
            carregaCategoria();  // Atualiza a lista de categorias após a inserção
        } catch (Exception e) {
            e.printStackTrace();  // Captura e exibe exceções
            System.out.println("Erro ao cadastrar categoria.");
        }
        cadastroCategoriaView.limparCampos();  // Limpa os campos de entrada na interface
    }

    // Método para carregar e exibir categorias na interface
    private void carregaCategoria() {
        CategoriaDAO categoriaDAO = new CategoriaDAO();  // Instância do DAO
        ArrayList<Categoria> categorias = categoriaDAO.buscarCategoria();  // Obtém a lista de categorias do banco de dados
        cadastroCategoriaView.limparCategoriaParaRemover();  // Limpa a lista de categorias a serem removidas

        // Adiciona cada categoria à interface com opção de remoção
        for (Categoria categoria : categorias) {
            cadastroCategoriaView.adicionarCategoriaParaRemover(categoria, e -> removerCategoria(categoria));
        }
    }

    // Método para remover uma categoria
    private void removerCategoria(Categoria categoria) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();  // Instância do DAO
        try {
            categoriaDAO.apagarCategoria(categoria.getNome());  // Remove a categoria do banco de dados
            carregaCategoria();  // Atualiza a lista de categorias após a remoção
        } catch (Exception e) {
            e.printStackTrace();  // Captura e exibe exceções
            System.out.println("Erro ao remover categoria.");
        }
    }
}
