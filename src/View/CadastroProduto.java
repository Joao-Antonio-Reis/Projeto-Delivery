package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

import Models.Produto;

public class CadastroProduto extends JLabel {

    private JTextField nomeField;
    private JTextArea descProdutoArea;
    private JTextField precoField;
    private JComboBox<String> categoriaBox;
    private JLabel imageLabel;
    private JButton removerProduto;
    private JLabel labelProduto;
    private File selectedFile;
    private JButton cadastrarButton;
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136, 0, 12);
    private JPanel panelRemover;

    public CadastroProduto() {
        setSize(415, 800);
        setLayout(null);
        frameCadastroProduto();
    }

    private void frameCadastroProduto() {
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
        categoriaLabel.setBounds(5, 55, 90, 20);
        add(categoriaLabel);
        categoriaBox = new JComboBox<>();
        categoriaBox.setBounds(80, 55, 150, 20);
        categoriaBox.setUI(new BasicComboBoxUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                categoriaBox.setBorder(BorderFactory.createEmptyBorder());
                categoriaBox.setBorder(new MatteBorder(0, 0, 2, 0, cor));
            }
        });
        categoriaBox.setFont(font);
        add(categoriaBox);

        imageLabel = new JLabel();
        imageLabel.setBounds(170, 80, 100, 20);
        add(imageLabel);

        JButton uploadButton = new JButton("Upload Imagem");
        uploadButton.setFont(new Font("Arial", Font.BOLD, 15));
        uploadButton.setForeground(Color.WHITE);
        uploadButton.setBackground(cor);
        uploadButton.setBounds(10, 80, 150, 20);
        add(uploadButton);

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

        JLabel descCat = new JLabel("Descrição");
        descCat.setBounds(5, 100, 100, 20);
        descCat.setFont(font);
        add(descCat);
        descProdutoArea = new JTextArea();
        descProdutoArea.setBounds(5, 120, 390, 100);
        descProdutoArea.setAlignmentY(JTextField.TOP);
        descProdutoArea.setLineWrap(true);
        descProdutoArea.setWrapStyleWord(true);
        descProdutoArea.setBorder(BorderFactory.createLineBorder(cor, 2));
        add(descProdutoArea);

        JLabel removerLabel = new JLabel("Remover produtos");
        removerLabel.setBounds(5, 240, 300, 20);
        removerLabel.setFont(font);
        add(removerLabel);

        panelRemover = new JPanel();
        panelRemover.setLayout(new BoxLayout(panelRemover, BoxLayout.Y_AXIS));
        panelRemover.setSize(400, 200);

        JScrollPane scrollPane = new JScrollPane(panelRemover);
        scrollPane.setBounds(0, 265, 400, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(270, 690, 120, 40);
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 15));
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setBackground(cor);
        add(cadastrarButton);
    }

    public String getNome() {
        return nomeField.getText();
    }

    public String getDescricao() {
        return descProdutoArea.getText();
    }

    public String getPreco() {
        return precoField.getText();
    }

    public String getCategoria() {
        return (String) categoriaBox.getSelectedItem();
    }

    public String getCaminhoImagem() {
        return (selectedFile != null) ? selectedFile.getName() : "";
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public void carregarCategoriaBox(String categoria) {
        categoriaBox.addItem(categoria);
    }

    public void limparCampos() {
        nomeField.setText("");
        precoField.setText("");
        descProdutoArea.setText("");
    }

    public void limparProdutosParaRemover() {
        panelRemover.removeAll();
        panelRemover.revalidate();
        panelRemover.repaint();
    }

    public void adicionarProdutoParaRemover(Produto produto, ActionListener removerAction) {
        JPanel productPanel = new JPanel();
        productPanel.setLayout(null);
        productPanel.setPreferredSize(new Dimension(380, 30));

        labelProduto = new JLabel(produto.getNome());
        labelProduto.setBounds(5, 5, 200, 20);
        labelProduto.setFont(new Font("Arial", Font.BOLD, 14));
        productPanel.add(labelProduto);

        removerProduto = new JButton("Remover");
        removerProduto.setBackground(cor);
        removerProduto.setForeground(Color.WHITE);
        removerProduto.setBounds(250, 5, 100, 25);
        removerProduto.setFocusPainted(false);
        removerProduto.setRolloverEnabled(false);
        removerProduto.addActionListener(removerAction);

        productPanel.add(removerProduto);
        panelRemover.add(productPanel);
        panelRemover.revalidate();
        panelRemover.repaint();
    }
}
