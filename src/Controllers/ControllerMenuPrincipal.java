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

public class ControllerMenuPrincipal implements InterfaceController {
    public ArrayList<Produto> produtosMain = new ArrayList<Produto>();
    private MenuPrincipalView menuView;
    private boolean logado;



    public ControllerMenuPrincipal(MenuPrincipalView view){
        this.menuView = view;
        this.logado = false;
        initView();
        initController();
    }

    public void initView() {
        menuView.setVisible(true);
        menuView.mostrarAdmMenu(logado);
    }

    public void initController (){
        menuView.getCardapioButton().addActionListener(e -> abrirCardapio());
        menuView.getCarrinhoButton().addActionListener(e -> abrirCarrinho());
        menuView.getCadastroButton().addActionListener(e -> abrirCadastro());
        menuView.getLoginButton().addActionListener(e -> abrirLogin());

        menuView.getCardapioMenu().addActionListener(e -> abrirCardapio());
        menuView.getCarrinhoMenu().addActionListener(e -> abrirCarrinho());
        menuView.getLoginMenu().addActionListener(e -> abrirLogin());
        menuView.getCadastrarCategoriaItem().addActionListener(e -> abrirCadastroCategoria());
        menuView.getCadastrarProdutoItem().addActionListener(e -> abrirCadastroProduto());
        menuView.getVoltaMenu().addActionListener(e ->showMainMenu());
    }

    private void abrirCardapio(){
        Cardapio cardapio = new Cardapio();
        ControllerCardapio controllerCardapio = new ControllerCardapio(cardapio, produtosMain);
        menuView.changeContent(cardapio);
    }

    private void abrirCarrinho() {
        Carrinho carrinho = new Carrinho();
        ControllerCarrinho controllerCarrinho = new ControllerCarrinho(carrinho, produtosMain);
        menuView.changeContent(carrinho);
    }

    private void abrirCadastro() {
        ClientForm clientForm = new ClientForm();
        menuView.changeContent(clientForm);
    }

    private void abrirLogin() {
        LoginAdm loginAdm = new LoginAdm();
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
