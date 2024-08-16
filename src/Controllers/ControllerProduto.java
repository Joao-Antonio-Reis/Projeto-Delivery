package Controllers;

import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import Models.Categoria;
import View.CadastroProduto;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import Models.Produto;

// Controlador para gerenciar a interface e a lógica de cadastro de produtos
public class ControllerProduto implements InterfaceController {
    private CadastroProduto cadastroProdutoView; // Interface gráfica para cadastro de produtos
    private File selectedFile; // Arquivo de imagem selecionado para o produto
    private File destFile; // Arquivo de destino para a cópia da imagem

    // Construtor padrão
    public ControllerProduto() {}

    // Construtor que inicializa a interface de cadastro de produtos
    public ControllerProduto(CadastroProduto cadastroProdutoView) {
        this.cadastroProdutoView = cadastroProdutoView;
        initView(); // Inicializa a interface gráfica
        initController(); // Inicializa controladores e eventos
    }

    @Override
    public void initView() {
        cadastroProdutoView.setVisible(true); // Torna a interface de cadastro visível
        carregaCategoria(); // Carrega as categorias disponíveis na interface
        carregaProdutos(); // Carrega os produtos existentes na interface
    }

    @Override
    public void initController() {
        // Adiciona um ouvinte de ação ao botão de cadastro para criar novos produtos
        cadastroProdutoView.getCadastrarButton().addActionListener(e -> cadastrar());
    }

    // Método para cadastrar um novo produto
    private void cadastrar() {
        String nome = cadastroProdutoView.getNome(); // Obtém o nome do produto
        String valor = cadastroProdutoView.getPreco().replace(",", "."); // Obtém o preço e substitui vírgula por ponto
        BigDecimal preco;
        try {
            preco = new BigDecimal(valor); // Converte o preço para BigDecimal
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter o preço."); // Mensagem de erro caso a conversão falhe
            return;
        }

        String categoria = cadastroProdutoView.getCategoria(); // Obtém a categoria do produto
        String descricao = cadastroProdutoView.getDescricao(); // Obtém a descrição do produto
        String caminhoImagem = "Imagens/" + cadastroProdutoView.getCaminhoImagem(); // Define o caminho da imagem do produto

        // Verifica se um arquivo de imagem foi selecionado
        if (cadastroProdutoView.getSelectedFile() != null) {
            File destFile = new File(caminhoImagem);

            // Cria o diretório "Imagens" se não existir
            File imagensDir = new File("Imagens/");
            if (!imagensDir.exists()) {
                imagensDir.mkdir();
            }
            try {
                // Copia o arquivo de imagem selecionado para o diretório de destino
                Files.copy(cadastroProdutoView.getSelectedFile().toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ioException) {
                ioException.printStackTrace(); // Exibe o stack trace em caso de falha
            }

            System.out.println("Produto cadastrado!!"); // Mensagem de sucesso ao cadastrar o produto
        } else {
            System.out.println("Adicione uma Imagem para o caminho."); // Mensagem de erro se não houver imagem
        }

        // Chama o DAO para inserir o produto no banco de dados
        ProdutoDAO.inserirProduto(nome, categoria, descricao, preco, caminhoImagem);
        cadastroProdutoView.limparCampos(); // Limpa os campos de entrada na interface
        carregaProdutos(); // Atualiza a lista de produtos após a inserção
    }

    // Método para carregar e exibir categorias na interface
    private void carregaCategoria() {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ArrayList<Categoria> listaCategorias = categoriaDAO.buscarCategoria(); // Obtém a lista de categorias do banco de dados
        for (Categoria categoria : listaCategorias) {
            cadastroProdutoView.carregarCategoriaBox(categoria.getNome()); // Carrega cada categoria na interface
        }
    }

    // Método para carregar e exibir produtos na interface
    private void carregaProdutos() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.obterProdutosOrdenados(); // Obtém a lista de produtos do banco de dados
        cadastroProdutoView.limparProdutosParaRemover(); // Limpa a lista de produtos a serem removidos

        for (Produto produto : produtos) {
            // Adiciona cada produto à interface com opção de remoção
            cadastroProdutoView.adicionarProdutoParaRemover(produto, e -> removerProduto(produto));
        }
    }

    // Método para remover um produto
    private void removerProduto(Produto produto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.removerProduto(produto.getNome()); // Remove o produto do banco de dados
        carregaProdutos(); // Atualiza a lista de produtos após a remoção
    }
}