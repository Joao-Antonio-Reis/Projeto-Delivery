package Models;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginAdm extends JPanel{

    private JFrame frame;
    private JTextField loginField;
    private JPasswordField senhaField;
    private JButton loginButton;

    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136,0, 12);

//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//            try {
//                LoginAdm window = new LoginAdm();
//                window.frame.setVisible(true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }

    public LoginAdm(){
        panelAdm();
    }

    public void panelAdm() {

        setVisible(true); //Visibilidade true
        setLayout(null);

        //Label login
        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setFont(font);
        loginLabel.setBounds(50, 5, 50, 20);
        loginLabel.setHorizontalAlignment(loginLabel.CENTER);
        add(loginLabel);

        loginField = new JTextField();
        loginField.setBounds(105, 5, 200,20);
        loginField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(loginField);

        //Label Senha
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(50, 30, 70, 20);
        senhaLabel.setFont(font);
        add(senhaLabel);

        senhaField = new JPasswordField();
        senhaField.setBounds(105, 30,200,20);
        senhaField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(senhaField);

        //Button de login
        loginButton = new JButton("Login");
        loginButton.setBounds(270, 695, 125, 40);
        loginButton.setFont(font);
        loginButton.setBackground(cor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));

        //Action do button login
        loginButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                

                // Do something with the client object
            }
        });
        add(loginButton);
    }
}


