package Controllers;

import Models.Produto;
import View.*;

import java.util.ArrayList;

public class ControllerMenuPrincipal implements InterfaceController {
    public ArrayList<Produto> produtosMain = new ArrayList<Produto>();
    private MenuPrincipalView menuView;
    private boolean logado;

    public ControllerMenuPrincipal(MenuPrincipalView view) {
        this.menuView = view;
        this.logado = false;
        initView();
        initController();
    }

    @Override
    public void initView() {
        menuView.setVisible(true);
        menuView.mostrarAdmMenu(logado);
    }

    @Override
    public void initController() {
        menuView.getCardapioButton().addActionListener(e -> abrirCardapio());
        menuView.getCarrinhoButton().addActionListener(e -> abrirCarrinho());
        menuView.getLoginButton().addActionListener(e -> abrirLogin());

        menuView.getCardapioMenu().addActionListener(e -> abrirCardapio());
        menuView.getCarrinhoMenu().addActionListener(e -> abrirCarrinho());
        menuView.getLoginMenu().addActionListener(e -> abrirLogin());
        menuView.getCadastrarCategoriaItem().addActionListener(e -> abrirCadastroCategoria());
        menuView.getCadastrarProdutoItem().addActionListener(e -> abrirCadastroProduto());
        menuView.getVoltaMenu().addActionListener(e -> showMainMenu());
        menuView.getHistorico().addActionListener(e -> abrirHistorico());
        menuView.getLogout().addActionListener(e -> logout());
    }

    private void logout() {
        menuView.mostrarAdmMenu(false);;
        abrirLogin();
    }

    private void abrirCardapio() {
        Cardapio cardapio = new Cardapio();
        ControllerCardapio controllerCardapio = new ControllerCardapio(cardapio, produtosMain);
        menuView.changeContent(cardapio);
    }

    // Abre a view do carrinho de compras
    private void abrirCarrinho() {
        Carrinho carrinho = new Carrinho();
        ControllerCarrinho controllerCarrinho = new ControllerCarrinho(carrinho, produtosMain, menuView);
        menuView.changeContent(carrinho);
    }

    private void abrirLogin() {
        LoginAdm loginAdm = new LoginAdm();
        ControllerLoginAdm controllerLoginAdm = new ControllerLoginAdm(loginAdm);
        loginAdm.setMenuPrincipal(menuView);
        menuView.changeContent(loginAdm);
    }

    private void abrirCadastroCategoria() {
        CadastroCategoria cadastroCategoria = new CadastroCategoria();
        ControllerCategoria controllerCategoria = new ControllerCategoria(cadastroCategoria);
        menuView.changeContent(cadastroCategoria);
    }

    private void abrirCadastroProduto() {
        CadastroProduto cadastroProduto = new CadastroProduto();
        ControllerProduto controllerCadastroProduto = new ControllerProduto(cadastroProduto);
        menuView.changeContent(cadastroProduto);
    }

    private void abrirHistorico(){
        HistoricoPedidos historicoPedidos = new HistoricoPedidos();
        ControllerHistorico controllerHistorico = new ControllerHistorico(historicoPedidos);
        menuView.changeContent(historicoPedidos);
    }

    private void showMainMenu() {
        menuView.changeContent(menuView.getMenuprin());
    }

    public ArrayList<Produto> getProdutosMain() {
        return produtosMain;
    }

    public void setProdutosMain(ArrayList<Produto> produtosMain) {
        this.produtosMain = produtosMain;
    }
}
