package Controllers;

import View.MenuPrincipalView;
import View.Cardapio;
import View.ClientForm;
import View.RealizarPedido;
import View.LoginAdm;
import View.CadastroCategoria;
import View.CadastroProduto;


import javax.swing.*;

public class ControllerMenuPrincipal {
    private MenuPrincipalView menuView;
    private boolean logado;

    public ControllerMenuPrincipal(MenuPrincipalView view){
        this.menuView = view;
        this.logado = false;
        initView();
        initController();
    }

    private void initView() {
        menuView.setVisible(true);
        menuView.mostrarAdmMenu(logado);
    }

    private void initController (){
        menuView.getCardapioButton().addActionListener(e -> abrirCardapio());
        menuView.getCarrinhoButton().addActionListener(e -> abrirCarrinho());
        menuView.getCadastroButton().addActionListener(e -> abrirCadastro());
        menuView.getLoginButton().addActionListener(e -> abrirLogin());
        menuView.getCadastrarCategoriaItem().addActionListener(e -> abrirCadastroCategoria());
        menuView.getCadastrarProdutoItem().addActionListener(e -> abrirCadastroProduto());
//        menuView.getVoltaMenu().addActionListener(e -> );
        menuView.getCardapioMenu().addActionListener(e -> abrirCardapio());
        menuView.getCarrinhoMenu().addActionListener(e -> abrirCarrinho());
        menuView.getLoginMenu().addActionListener(e -> abrirLogin());

    }

    private void abrirCardapio(){
        Cardapio cardapio = new Cardapio();
        menuView.changeContent(cardapio);
    }

    private void abrirCarrinho() {
        RealizarPedido realizarPedido = new RealizarPedido();
        menuView.changeContent(realizarPedido);
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
        menuView.changeContent(cadastroCategoria);
    }

    private void abrirCadastroProduto() {
        CadastroProduto cadastroProduto = new CadastroProduto();
        menuView.changeContent(cadastroProduto);

    }


}
