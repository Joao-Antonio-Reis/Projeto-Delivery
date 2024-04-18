package Models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MudaSenhaAdm extends JFrame{
    
    private JFrame frame;
    private JTextField senha1Field;
    private JTextField senha2Field;
    private JButton submitButton;

    private Font font = new Font("Arial", Font.BOLD, 15);

    private void frame(){

        setTitle("Mudar senha administrativa");
        setVisible(true); //Visibilidade true
        setSize(415,800); //Define o tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Fecha o programa quando fecha a janela
        setResizable(false);//Não deixa mudar o tamanho
        setLocationRelativeTo(null); //abre o frame no meio da tela
        setLayout(null);

        JLabel senha1Label = new JLabel("Digite a Senha:");
        senha1Label.setFont(font);
        senha1Label.setBounds(5, 30, 50, 20);
        add(senha1Label);

        senha1Field = new JTextField();
        senha1Field.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        senha1Field.setBounds(55, 30, 320,20);
        add(senha1Field);

        JLabel senha2Label = new JLabel("Confirme a senha:");
        senha2Label.setFont(font);
        senha2Label.setBounds(5, 30, 50, 20);
        add(senha2Label);

        senha2Field = new JTextField();
        senha2Field.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        senha2Field.setBounds(55, 30, 320,20);
        add(senha2Field);

        submitButton = new JButton("Confirmar");
        submitButton.setSize(new Dimension(25,20));
        submitButton.setBounds(270, 715, 125, 40);
        submitButton.setFont(font);
        submitButton.setBackground(Color.RED);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));

        /*
        Criar ActionPerformed para realizar a alteração da senha Administrativa
        loginButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                

                // Do something with the client object
            }
        });

        */
        add(submitButton);
        }
}
