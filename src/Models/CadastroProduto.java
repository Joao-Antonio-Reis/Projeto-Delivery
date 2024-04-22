package Models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CadastroProduto extends JLabel {

    private JFrame frame;
    private JTextField nomeField;
    private JTextArea descProdutoArea;
    private JTextField precoField;
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136, 0, 12);

//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//            try {
//                CadastroProduto window = new CadastroProduto();
//                window.frame.setVisible(true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }

    public CadastroProduto() {
        produtoLabel();
    }

    public void produtoLabel() {
        setVisible(true); //Visibilidade true
        setSize(415, 800); //Define o tamanho da tela
        setLayout(null);


        JLabel nomeProdLabel = new JLabel("Nome: ");
        nomeProdLabel.setFont(font);
        nomeProdLabel.setBounds(5, 5, 50, 20);
        add(nomeProdLabel);

        nomeField = new JTextField();
        nomeField.setBounds(60, 5, 270, 20);
        nomeField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(nomeField);

        JLabel precoLabel = new JLabel("Preço: ");
        precoLabel.setFont(font);
        precoLabel.setBounds(5, 30, 50, 20);
        add(precoLabel);

        precoField = new JTextField();
        precoField.setBounds(60, 30, 100, 20);
        precoField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(precoField);


        JLabel descCat = new JLabel("Descrição");
        descCat.setBounds(5, 55, 100, 20);
        descCat.setFont(font);
        add(descCat);

        descProdutoArea = new JTextArea();
        descProdutoArea.setBounds(5, 75, 390, 100);
        descProdutoArea.setFont(font);
        descProdutoArea.setAlignmentY(JTextField.TOP); //Ajustar no topo
        descProdutoArea.setLineWrap(true); // Quebra de linha automática
        descProdutoArea.setWrapStyleWord(true); // Quebra de palavra
        descProdutoArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(descProdutoArea);

        JButton button = new JButton("Cadastrar");
        button.setBounds(270, 695, 120, 40);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setForeground(Color.WHITE);
        button.setBackground(cor);
        add(button);
        button.addActionListener(new ActionListener() {

            // Terminar de fazer o método depois de linkar as categorias para poder selecionar a cada produto adicionado.
            public void actionPerformed(ActionEvent e) {

                String nome = nomeField.getText();
                String descricao = descProdutoArea.getText();
//                String categorianome = categoriaField.getText();
                String valor;
//                try {
//                    valor = Double.parseDouble(precoField.getText());
//                } catch (NumberFormatException ex) {
//                    System.out.println("Digite o valor correto!");
//                    valor = 0.0;
//                }


                // Produto produto = new Produto(nome, categoria, descricao, valor);

                // Do something with the client object
            }
        });
        add(button);
    }
}
