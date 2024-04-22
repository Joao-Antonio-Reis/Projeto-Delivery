package Models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginAdm extends JLabel{

    private JTextField loginField;
    private JTextField senhaField;
    private JButton loginButton;
    private Color cor = new Color(136,0, 12);
    private Font font = new Font("Arial", Font.BOLD, 15);

    public LoginAdm(){
        panelAdm();
    }

    private void panelAdm() {

        setVisible(true); //Visibilidade true
        setLayout(null);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setFont(font);
        loginLabel.setBounds(5, 5, 50, 20);
        add(loginLabel);

        loginField = new JTextField();
        loginField.setBounds(60, 5, 200,20);
        loginField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(loginField);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(5, 25, 60, 20);
        senhaLabel.setFont(font);
        add(senhaLabel);

        senhaField = new JTextField();
        senhaField.setBounds(60, 30,200,20);
        senhaField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(senhaField);

        loginButton = new JButton("Login");
        loginButton.setSize(new Dimension(25,20));
        loginButton.setBounds(270, 695, 125, 40);
        loginButton.setFont(font);
        loginButton.setBackground(cor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {


                // Do something with the client object
            }
        });
        add(loginButton);
    }
}



