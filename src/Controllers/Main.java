package Controllers;

import View.MenuPrincipalView;
import View.PedidoView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ControllerMenuPrincipal menuPrincipal = new ControllerMenuPrincipal(new MenuPrincipalView());
    }
}
