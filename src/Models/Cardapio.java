package Models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Cardapio extends JFrame{
    private JFrame frame;
    private Font font = new Font("Arial", Font.BOLD, 15);

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Cardapio window = new Cardapio();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Cardapio() {
        frame();
    }

    private void frame() {

        setTitle("Japinha Oriental Food - Cardapio");
        setVisible(true); //Visibilidade true
        setSize(415,800); //Define o tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Fecha o programa quando fecha a janela
        setResizable(false);//Não deixa mudar o tamanho
        setLocationRelativeTo(null); //abre o frame no meio da tela
        setLayout(null);

        JButton buttonCardapio = new JButton("Cardapio");
        buttonCardapio.setBounds(0, 0, 100, 20);
        buttonCardapio.setFont(font);
        buttonCardapio.setForeground(Color.BLACK);
        buttonCardapio.setBackground(Color.RED);
        add(buttonCardapio);

        JButton button2 = new JButton("Button2");
        button2.setBounds(100, 0, 100, 20);
        button2.setFont(font);
        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.WHITE);
        add(button2);

        JButton button3 = new JButton("Carrinho");
        button3.setBounds(200, 0, 100, 20);
        button3.setFont(font);
        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.WHITE);
        add(button3);

        JButton button4 = new JButton("Login");
        button4.setBounds(300, 0, 100, 20);
        button4.setFont(font);
        button4.setForeground(Color.BLACK);
        button4.setBackground(Color.WHITE);
        add(button4);


        JButton submitButton = new JButton("Finalizar");
        submitButton.setSize(new Dimension(25,20));
        submitButton.setBounds(270, 715, 125, 40);
        submitButton.setFont(font);
        submitButton.setBackground(Color.RED);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        add(submitButton);

    }

}
