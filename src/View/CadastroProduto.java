package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.math.BigDecimal;

import ConexaoDB.CategoriaDAO;
import ConexaoDB.ProdutoDAO;
import Models.Categoria;
import Models.Produto;

public class CadastroProduto extends JLabel {

    private JFrame frame;
    private JTextField nomeField;
    private JTextArea descProdutoArea;
    private JTextField precoField;
    private JComboBox categoriaBox;
    private JLabel imageLabel;
    private File selectedFile;
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
        CategoriaDAO categoria = new CategoriaDAO();
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
        nomeField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        add(nomeField);

        JLabel precoLabel = new JLabel("Preço: ");
        precoLabel.setFont(font);
        precoLabel.setBounds(5, 30, 60, 20);
        add(precoLabel);

        precoField = new JTextField();
        precoField.setBounds(60, 30, 100, 20);
        precoField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        add(precoField);

        JLabel categoriaLabel = new JLabel("Categoria: ");
        categoriaLabel.setFont(font);
        categoriaLabel.setBounds(5,55, 90, 20);
        add(categoriaLabel);

        categoriaBox = new JComboBox<>();
        categoriaBox.setBounds(80,55,150,20);
        categoriaBox.setUI(new BasicComboBoxUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                categoriaBox.setBorder(BorderFactory.createEmptyBorder());
                categoriaBox.setBorder(new MatteBorder(0, 0, 2, 0, cor));
            }
    
        });
        categoriaBox.setFont(font);
        for (String string : listaDeCategoria) {
            categoriaBox.addItem(string);
        }
        add(categoriaBox);

        JButton uploadButton = new JButton("Upload Imagem");
        uploadButton.setBounds(10, 170, 150, 25);
        add(uploadButton);

        JLabel imagemLabel = new JLabel("URL Imagem: ");
        imagemLabel.setBounds(5, 80, 100, 20);
        imagemLabel.setFont(font);
        add(imagemLabel);

        JTextField imagemField = new JTextField();
        imagemField.setBounds(100, 80, 235, 20);
        imagemField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        add(imagemField);

        JLabel descCat = new JLabel("Descrição");
        descCat.setBounds(5, 100, 100, 20);
        descCat.setFont(font);
        add(descCat);
        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    imageLabel.setText(selectedFile.getName());
                }
            }
        });

        descProdutoArea = new JTextArea();
        descProdutoArea.setBounds(5, 120, 390, 100);
        descProdutoArea.setFont(font);
        descProdutoArea.setAlignmentY(JTextField.TOP); //Ajustar no topo
        descProdutoArea.setLineWrap(true); // Quebra de linha automática
        descProdutoArea.setWrapStyleWord(true); // Quebra de palavra
        descProdutoArea.setBorder(BorderFactory.createLineBorder(cor, 2));
        add(descProdutoArea);
        

        JButton button = new JButton("Cadastrar");
        button.setBounds(270, 690, 120, 40);
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
                String caminhoImagem = (selectedFile != null ? selectedFile.getName() : "");
                if (selectedFile != null) {
                    File destFile = new File(caminhoImagem);
                    try {
                        Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                try {
                    preco = new BigDecimal(valor);
                } catch (NumberFormatException error) {
                    System.out.println("Erro ao converter o preço: ");
                    error.printStackTrace();
                }

                File destFile = new File(caminhoImagem);
                try {
                    Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                String categoriaSelecionada = (String) categoriaBox.getSelectedItem();
                String descricao = descProdutoArea.getText();

                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.inserirProduto(nome, categoriaSelecionada, descricao, preco, caminhoImagem);

                nomeField.setText("");
                precoField.setText("");
                descProdutoArea.setText("");
                imagemField.setText("");

                // Produto produto = new Produto(nome, categoria, descricao, valor);

                // Do something with the client object
            }
        });
        add(button);
    }
}
