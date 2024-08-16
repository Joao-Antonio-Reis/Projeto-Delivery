package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Models.Produto;

public class Cardapio extends JLabel {
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136, 0, 12);
    private String path = "Imagens/";

    private JPanel panelCardapio = new JPanel();
    private JButton adicionarButton;

    public Cardapio() {
        frameCardapio();
    }

    private void frameCardapio() {
        setVisible(true);
        setSize(415, 800);
        setLayout(null);

        panelCardapio.setLayout(new BoxLayout(panelCardapio, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panelCardapio);
        scrollPane.setBounds(0, 0, 400, 685);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
    }

    public void adicionarProduto(Produto produto, ActionListener adicionarListner) {
        JPanel productPanel = new JPanel();
        productPanel.setLayout(null);
        productPanel.setPreferredSize(new Dimension(380, 80));

        JPanel imagemPanel = new JPanel();
        imagemPanel.setBounds(5, 5, 100, 70);
        imagemPanel.setLayout(new BorderLayout());
        ImageIcon imageIcon = new ImageIcon("Imagens/"+produto.getImagem());
        JLabel imageLabel = new JLabel(imageIcon);
        imagemPanel.add(imageLabel, BorderLayout.CENTER);
        productPanel.add(imagemPanel);

        JPanel infoProduto = new JPanel();
        infoProduto.setBounds(110, 5, 200, 70);
        infoProduto.setLayout(new GridLayout(4, 1));

        JLabel labelProduto = new JLabel(produto.getNome());
        labelProduto.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel labelCat = new JLabel("Categoria: " + produto.getCategoria());
        labelCat.setFont(new Font("Arial", Font.BOLD, 11));
        JLabel labelDescricao = new JLabel("Descrição: " + produto.getDescricao());
        labelDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel labelPreco = new JLabel("Preço: R$" + String.format("%.2f", produto.getValor()));
        labelPreco.setFont(new Font("Arial", Font.PLAIN, 12));

        infoProduto.add(labelProduto);
        infoProduto.add(labelCat);
        infoProduto.add(labelDescricao);
        infoProduto.add(labelPreco);
        productPanel.add(infoProduto);

        adicionarButton = new JButton("+");
        adicionarButton.setBackground(cor);
        adicionarButton.setForeground(Color.WHITE);
        adicionarButton.setBounds(320, 30, 50, 25);
        adicionarButton.setFocusPainted(false);
        adicionarButton.setRolloverEnabled(false);
        adicionarButton.addActionListener(adicionarListner);

        productPanel.add(adicionarButton);
        panelCardapio.add(productPanel);
    }
}
