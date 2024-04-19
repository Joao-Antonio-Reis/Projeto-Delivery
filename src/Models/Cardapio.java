package Models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Cardapio extends JFrame{
    private JFrame frame;
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136,0, 12);

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
        setLayout(null);//Deixa o layout null

        JMenuBar menuBar = new JMenuBar();
        // Cria os menus
        JMenu categoriasMenu = new JMenu("Categoria");
        JMenu carrinhoMenu = new JMenu("Carrinho");
        JMenu loginMenu = new JMenu("Login");

        menuBar.setBackground(cor);
        categoriasMenu.setForeground(Color.WHITE);
        carrinhoMenu.setForeground(Color.WHITE);
        loginMenu.setForeground(Color.WHITE);

        menuBar.add(categoriasMenu);
        menuBar.add(carrinhoMenu);
        menuBar.add(loginMenu);

        setJMenuBar(menuBar);

        JButton submitButton = new JButton("Finalizar");
        submitButton.setSize(new Dimension(25,20));
        submitButton.setBounds(270, 695, 125, 40);
        submitButton.setFont(font);
        submitButton.setBackground(cor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        add(submitButton);

    }

}
