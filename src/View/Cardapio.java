package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ConexaoDB.ProdutoDAO;
import Models.Produto;

public class Cardapio extends JLabel {

    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136, 0, 12);
    private String path = "Imagens/";

    // Construtor que recebe o frame principal
    public Cardapio() {
        frame();
    }

    // Método para configurar o frame
    private void frame() {
        setVisible(true);
        setSize(415, 800);
        setLayout(null);

        // Criação do painel para o cardápio
        JPanel panelCardapio = new JPanel();
        panelCardapio.setLayout(new BoxLayout(panelCardapio, BoxLayout.Y_AXIS)); // Layout para organizar componentes verticalmente
        panelCardapio.setPreferredSize(new Dimension(400, 2000)); // Define o tamanho preferido do painel

        // Obtenção da lista de produtos ordenados
        ProdutoDAO produtoList = new ProdutoDAO();
        List<Produto> produtos = produtoList.obterProdutosOrdenados();

        // Adição de produtos ao painel do cardápio
        for (Produto produto : produtos) {
            JPanel productPanel = new JPanel();
            productPanel.setLayout(null);
            productPanel.setPreferredSize(new Dimension(380, 70)); // Tamanho do retângulo para cada produto
            // productPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1)); // Borda preta ao redor do painel

            JPanel imagemPanel = new JPanel();
            imagemPanel.setBounds(5, 5, 100, 70);
            imagemPanel.setLayout(new BorderLayout());
            // imagemPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1)); // Borda preta ao redor do painel
            ImageIcon imageIcon = new ImageIcon(produto.getImagem()); // Carrega a imagem
            JLabel imageLabel = new JLabel(imageIcon);
            imagemPanel.add(imageLabel, BorderLayout.CENTER);
            productPanel.add(imagemPanel);

            JPanel infoProduto = new JPanel();
            infoProduto.setBounds(110, 5, 200, 70);
            infoProduto.setLayout(new GridLayout(4, 1)); // Layout para os componentes do produto
            // infoProduto.setBorder(BorderFactory.createLineBorder(Color.black, 1)); // Borda preta ao redor do painel

            // Criação dos componentes para cada produto
            JLabel labelProduto = new JLabel(produto.getNome());
            labelProduto.setFont(new Font("Arial", Font.BOLD, 14));
            JLabel labelCat = new JLabel("Categoria: " + produto.getCategoria());
            labelCat.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel labelDescricao = new JLabel("Descrição: " + produto.getDescricao());
            labelDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
            JLabel labelPreco = new JLabel("Preço: R$" + produto.getValor());
            labelPreco.setFont(new Font("Arial", Font.PLAIN, 12));

            // Adiciona os componentes ao painel do produto
            infoProduto.add(labelProduto);
            infoProduto.add(labelCat);
            infoProduto.add(labelDescricao);
            infoProduto.add(labelPreco);
            productPanel.add(infoProduto);

            JButton adicionarButton = new JButton("+");
            adicionarButton.setBackground(cor);
            adicionarButton.setForeground(Color.WHITE);
            adicionarButton.setBounds(320, 60, 50, 25);
            adicionarButton.setFocusPainted(false);
            adicionarButton.setRolloverEnabled(false);

            productPanel.add(adicionarButton);

            // Adiciona o painel do produto ao painel do cardápio
            panelCardapio.add(productPanel);
        }

        // Criação do painel de rolagem para o cardápio
        JScrollPane scrollPane = new JScrollPane(panelCardapio);
        scrollPane.setBounds(0, 0, 400, 685); // Define a posição e tamanho do painel de rolagem
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Sempre mostra a barra de rolagem vertical
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Nunca mostra a barra de rolagem horizontal
        // scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 2)); // Borda preta ao redor do painel de rolagem
        add(scrollPane);

        // Criação do botão "Carrinho"
        JButton submitButton = new JButton("Carrinho");
        submitButton.setSize(new Dimension(125, 40)); // Define o tamanho do botão
        submitButton.setBounds(270, 690, 125, 40); // Define a posição do botão
        submitButton.setFont(font);
        submitButton.setBackground(cor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1)); // Borda branca ao redor do botão
        
        add(submitButton);

        // Adiciona ação ao botão "Carrinho"
//        submitButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                RealizarPedido finalizar = new RealizarPedido();
//
//                // Remove todos os componentes do contentPane do JFrame e adiciona o novo painel
//                getContentPane().removeAll();
//                getContentPane().add(finalizar);
//                revalidate();
//                repaint();
//            }
//        });
    }
}