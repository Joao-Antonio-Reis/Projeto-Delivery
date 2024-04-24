package Models;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Generics.Categoria;
import Generics.Produto;

public class CadastroProduto extends JLabel {

    private JFrame frame;
    private JTextField nomeField;
    private JTextArea descProdutoArea;
    private JTextField precoField;
    private JComboBox categoriaBox;
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
        Categoria categoria = new Categoria();
        ArrayList<String> listaDeCategoria = categoria.carregarCategoria();

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

        JLabel categoriaLabel = new JLabel("Categoria: ");
        categoriaLabel.setFont(font);
        categoriaLabel.setBounds(5,55, 90, 20);
        add(categoriaLabel);

        categoriaBox = new JComboBox<>();
        categoriaBox.setBounds(80,55,100,20);
        categoriaBox.setFont(font);
        for (String string : listaDeCategoria) {
            categoriaBox.addItem(string);
        }
        add(categoriaBox);


        JLabel descCat = new JLabel("Descrição");
        descCat.setBounds(5, 75, 100, 20);
        descCat.setFont(font);
        add(descCat);

        descProdutoArea = new JTextArea();
        descProdutoArea.setBounds(5, 95, 390, 100);
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
                String valor = precoField.getText();
                valor = valor.replace(",", ".");
                BigDecimal preco = BigDecimal.ZERO; // Usamos BigDecimal em vez de Double
                try {
                    preco = new BigDecimal(valor);
                } catch (NumberFormatException error) {
                    System.out.println("Erro ao converter o preço: ");
                    error.printStackTrace();
                }
                String categoriaSelecionada = (String) categoriaBox.getSelectedItem();
                String descricao = descProdutoArea.getText();

                Produto produto = new Produto(nome, categoriaSelecionada, descricao, preco);
                produto.inserirProduto(nome, categoriaSelecionada, descricao, preco);

                // Produto produto = new Produto(nome, categoria, descricao, valor);

                // Do something with the client object
            }
        });
        add(button);
    }
}
