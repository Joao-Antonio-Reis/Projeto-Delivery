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

public class Cardapio extends JLabel {
    private JFrame frame;
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136, 0, 12);

    public Cardapio() {
        frame();
    }

    private void frame() {
        setVisible(true);
        setSize(415, 800);
        setLayout(null);

        JButton submitButton = new JButton("Carrinho");
        submitButton.setSize(new Dimension(125, 40)); // Corrigido para setar tamanho correto
        submitButton.setBounds(270, 690, 125, 40);
        submitButton.setFont(font);
        submitButton.setBackground(cor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RealizarPedido finalizar = new RealizarPedido();

                // Obtém o contentPane do JFrame
                frame.getContentPane().removeAll();
                frame.getContentPane().add(finalizar);
                revalidate();
                repaint();
            }
        });

    }
}