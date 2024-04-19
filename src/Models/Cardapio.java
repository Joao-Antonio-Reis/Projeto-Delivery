package Models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Cardapio extends JLabel{
//    private JFrame frame;
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

        setVisible(true); //Visibilidade true
        setSize(415,800); //Define o tamanho da tela
        setLayout(null);//Deixa o layout null

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
