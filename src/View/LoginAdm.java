package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class LoginAdm extends JPanel {

    private JTextField loginField;
    private JPasswordField senhaField;
    private JButton loginButton;
    private Color cor = new Color(136, 0, 12);
    private Font font = new Font("Arial", Font.BOLD, 15);
    private MenuPrincipal menuPrincipal; // Referência para o MenuPrincipal

    public LoginAdm() {
        panelAdm();
    }

    private void panelAdm() {

        setVisible(true); // Visibilidade true
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

        JLabel logado = new JLabel();
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

        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = senhaField.getText();
                
                // Verifica se o login e senha são corretos
                // Lógica de autenticação
                if ("admin".equals(login) && "admin".equals(senha)) {
                    // Login bem-sucedido: mostra a JMenuBar do JFrame principal
                    if (menuPrincipal != null) {
                        menuPrincipal.mostrarAdmMenu(true);
                        logado.setText("Login efetuado com sucesso");
                    }

                    loginField.setText("");
                    senhaField.setText("");
                    
                    // Ações adicionais após o login, como mudar de tela, etc.
                } else {
                    // Login falhou: ações de feedback ao usuário, se necessário
                    System.out.println("Login falhou");
                }
            }
            
        });
    }
    public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }
}