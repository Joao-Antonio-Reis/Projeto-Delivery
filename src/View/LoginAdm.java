package View;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class LoginAdm extends JLabel {
    private JTextField loginField;
    private JPasswordField senhaField;
    private JButton loginButton;
    private Color cor = new Color(136, 0, 12);
    private Font font = new Font("Arial", Font.BOLD, 15);
    private MenuPrincipalView menuPrincipal; // Reference to MenuPrincipal
    private JLabel logado;

    public LoginAdm() {
        frameLogin();
    }

    private void frameLogin() {
        setVisible(true);
        setLayout(null);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setFont(font);
        loginLabel.setBounds(100, 250, 50, 20);
        add(loginLabel);

        loginField = new JTextField();
        loginField.setBounds(100, 270, 200, 20);
        loginField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        add(loginField);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(100, 290, 60, 20);
        senhaLabel.setFont(font);
        add(senhaLabel);

        senhaField = new JPasswordField();
        senhaField.setBounds(100, 310, 200, 20);
        senhaField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        add(senhaField);

        logado = new JLabel();
        logado.setBounds(110, 340, 200, 20);
        add(logado);

        loginButton = new JButton("Login");
        loginButton.setSize(new Dimension(25, 20));
        loginButton.setBounds(130, 370, 130, 40);
        loginButton.setFont(font);
        loginButton.setBackground(cor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        add(loginButton);
    }

    public void setMenuPrincipal(MenuPrincipalView menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public JPasswordField getSenhaField() {
        return senhaField;
    }

    public void mostrarAdmMenu(boolean b) {
        if (menuPrincipal != null) {
            menuPrincipal.mostrarAdmMenu(b);
        }
    }

    public JLabel getLogado() {
        return logado;
    }
}
