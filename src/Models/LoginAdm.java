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

public class LoginAdm extends JFrame{
    
    private JFrame f
    private JTextField loginField;
    private JTextField senhaField;
    private JButton loginButton;

    private Font font = new Font("Arial", Font.BOLD, 15);
    
    private void frame() {

        setTitle("Japinha Oriental Food - Administrativo");
        setVisible(true); //Visibilidade true
        setSize(415,800); //Define o tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Fecha o programa quando fecha a janela
        setResizable(false);//Não deixa mudar o tamanho
        setLocationRelativeTo(null); //abre o frame no meio da tela
        setLayout(null);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setFont(font);
        loginLabel.setBounds(5, 30, 50, 20);
        add(loginLabel);

        loginField = new JTextField();
        loginField.setBounds(55, 30, 320,20);
        loginField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(loginField);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(5, 60, 80, 20);
        senhaLabel.setFont(font);
        add(senhaLabel);

        senhaField = new JTextField();
        senhaField.setBounds(75, 60,100,20);
        senhaField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(senhaField);

        loginButton = new JButton("Login");
        loginButton.setSize(new Dimension(25,20));
        loginButton.setBounds(270, 715, 125, 40);
        loginButton.setFont(font);
        loginButton.setBackground(Color.RED);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));

        loginButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                

                // Do something with the client object
            }
        });
        add(loginButton);
    }
}


