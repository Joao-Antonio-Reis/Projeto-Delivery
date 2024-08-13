package Controllers;

import Models.Produto;
import View.MenuPrincipalView;
import View.Cardapio;
import View.ClientForm;
import View.Carrinho;
import View.LoginAdm;
import View.CadastroCategoria;
import View.CadastroProduto;

import java.util.ArrayList;

// Controlador para gerenciar a interação com o menu principal
public class ControllerMenuPrincipal implements InterfaceController {
    public ArrayList<Produto> produtosMain = new ArrayList<Produto>();  // Lista principal de produtos no sistema
    private MenuPrincipalView menuView;  // Interface gráfica do menu principal
    private boolean logado;  // Status de autenticação do administrador

    // Construtor que inicializa o menu principal e configura a interface e controladores
    public ControllerMenuPrincipal(MenuPrincipalView view) {
        this.menuView = view;
        this.logado = false;  // Inicialmente, o administrador não está logado
        initView();  // Inicializa a interface
        initController();  // Configura os controladores
    }

    @Override
    public void initView() {
        menuView.setVisible(true);  // Torna a interface do menu principal visível
        menuView.mostrarAdmMenu(logado);  // Mostra ou oculta opções administrativas com base no status de login
    }

    @Override
    public void initController() {
        // Configura ouvintes de ação para botões do menu
        menuView.getCardapioButton().addActionListener(e -> abrirCardapio());
        menuView.getCarrinhoButton().addActionListener(e -> abrirCarrinho());
        menuView.getLoginButton().addActionListener(e -> abrirLogin());

        // Configura ouvintes de ação para itens da menu Bar
        menuView.getCardapioMenu().addActionListener(e -> abrirCardapio());
        menuView.getCarrinhoMenu().addActionListener(e -> abrirCarrinho());
        menuView.getLoginMenu().addActionListener(e -> abrirLogin());
        menuView.getCadastrarCategoriaItem().addActionListener(e -> abrirCadastroCategoria());
        menuView.getCadastrarProdutoItem().addActionListener(e -> abrirCadastroProduto());
        menuView.getVoltaMenu().addActionListener(e -> showMainMenu());
    }

    // Abre a vista do cardápio
    private void abrirCardapio() {
        Cardapio cardapio = new Cardapio();  // Cria a interface do cardápio
        ControllerCardapio controllerCardapio = new ControllerCardapio(cardapio, produtosMain);  // Inicializa o controlador do cardápio
        menuView.changeContent(cardapio);  // Troca o conteúdo da interface para o cardápio
    }

    // Abre a view do carrinho de compras
    private void abrirCarrinho() {
        Carrinho carrinho = new Carrinho();  // Cria a interface do carrinho
        ControllerCarrinho controllerCarrinho = new ControllerCarrinho(carrinho, produtosMain);  // Inicializa o controlador do carrinho
        menuView.changeContent(carrinho);  // Troca o conteúdo da interface para o carrinho
    }

    // Abre a view de login do administrador
    private void abrirLogin() {
        LoginAdm loginAdm = new LoginAdm();// Cria a interface de login do administrador
        ControllerLoginAdm controllerLoginAdm = new ControllerLoginAdm(loginAdm);
        loginAdm.setMenuPrincipal(menuView);  // Passa a referência do menu principal para a interface de login
        menuView.changeContent(loginAdm);  // Troca o conteúdo da interface para a tela de login
    }

    // Abre a view de cadastro de categorias
    private void abrirCadastroCategoria() {
        CadastroCategoria cadastroCategoria = new CadastroCategoria();  // Cria a interface de cadastro de categorias
        ControllerCategoria controllerCategoria = new ControllerCategoria(cadastroCategoria);  // Inicializa o controlador de categorias
        menuView.changeContent(cadastroCategoria);  // Troca o conteúdo da interface para o cadastro de categorias
    }

    // Abre a view de cadastro de produtos
    private void abrirCadastroProduto() {
        CadastroProduto cadastroProduto = new CadastroProduto();  // Cria a interface de cadastro de produtos
        ControllerProduto controllerCadastroProduto = new ControllerProduto(cadastroProduto);  // Inicializa o controlador de produtos
        menuView.changeContent(cadastroProduto);  // Troca o conteúdo da interface para o cadastro de produtos
    }

    // Retorna ao menu principal
    private void showMainMenu() {
        menuView.changeContent(menuView.getMenuprin());  // Troca o conteúdo da interface para o menu principal
    }

    // Retorna a lista de produtos principal
    public ArrayList<Produto> getProdutosMain() {
        return produtosMain;
    }

    // Define a lista de produtos principal
    public void setProdutosMain(ArrayList<Produto> produtosMain) {
        this.produtosMain = produtosMain;
    }
}
