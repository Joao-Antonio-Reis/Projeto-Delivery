package Controlers;

import View.MenuPrincipalView;
import View.Cardapio;

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
//        menuView.getCardapioButton().
    }
    private void abrirCardapio(){
        Cardapio cardapio = new Cardapio();
        menuView.changeContent(cardapio);
    }

}
