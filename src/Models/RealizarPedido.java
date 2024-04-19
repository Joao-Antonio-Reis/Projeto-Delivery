<<<<<<< HEAD
package Models;

import javax.swing.*;
import java.awt.*;

public class RealizarPedido extends JLabel {
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136,0, 12);


//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//            try {
//                Cardapio window = new Cardapio();
//                window.setVisible(true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }

    public RealizarPedido() {
        realizarpedidoLabel();
    }

    public void realizarpedidoLabel() {

        setVisible(true); //Visibilidade true
        setLayout(null);//Deixa o layout null

        JLabel finalizar = new JLabel("Fechar pedido");
        finalizar.setBounds(5, 5, 100,20);
        add(finalizar);

        JButton submitButton = new JButton("Finalizar compra");
        submitButton.setSize(new Dimension(25,20));
        submitButton.setBounds(270, 695, 125, 40);
        submitButton.setFont(font);
        submitButton.setBackground(cor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        add(submitButton);

    }
}
=======
package Models;

import javax.swing.*;
import java.awt.*;

public class RealizarPedido extends JLabel {
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136,0, 12);


//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//            try {
//                Cardapio window = new Cardapio();
//                window.setVisible(true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }

    public RealizarPedido() {
        realizarpedidoLabel();
    }

    public void realizarpedidoLabel() {

        setVisible(true); //Visibilidade true
        setLayout(null);//Deixa o layout null

        JLabel finalizar = new JLabel("Fechar pedido");
        finalizar.setBounds(5, 5, 100,20);
        add(finalizar);

        JButton submitButton = new JButton("Finalizar compra");
        submitButton.setSize(new Dimension(25,20));
        submitButton.setBounds(270, 695, 125, 40);
        submitButton.setFont(font);
        submitButton.setBackground(cor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        add(submitButton);

    }
}
>>>>>>> origin/main
