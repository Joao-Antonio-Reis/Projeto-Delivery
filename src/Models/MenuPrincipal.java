package Models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPrincipal extends JFrame {
    private JFrame frame;

    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136,0, 12);

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuPrincipal window = new MenuPrincipal();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MenuPrincipal() {
        frame();
    }

    public void frame() {

        setTitle("Japinha Oriental Food");
        setVisible(true); //Visibilidade true
        setSize(415, 800); //Define o tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Fecha o programa quando fecha a janela
        setResizable(false);//Não deixa mudar o tamanho
        setLocationRelativeTo(null); //abre o frame no meio da tela


        // Cria os menus
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(cor);

        //Criando a opção categoria
        JButton voltaMenu = new JButton("Menu");
        voltaMenu.setBorder(BorderFactory.createLineBorder(cor,4));
        voltaMenu.setBackground(cor);
        voltaMenu.setForeground(Color.WHITE);
        menuBar.add(voltaMenu);


        //Criando a opção categoria
        JButton cardapioMenu = new JButton("Cardapio");
        cardapioMenu.setBorder(BorderFactory.createLineBorder(cor, 4));
        cardapioMenu.setBackground(cor);
        cardapioMenu.setForeground(Color.WHITE);
        menuBar.add(cardapioMenu);

        //Criando a opção carrinho
        JButton carrinho = new JButton("Carrinho");
        carrinho.setBorder(BorderFactory.createLineBorder(cor, 4));
        carrinho.setForeground(Color.WHITE);
        carrinho.setBackground(cor);
        menuBar.add(carrinho);

        //Criando a opção login
        JMenu loginMenu = new JMenu("Login");
        loginMenu.setForeground(Color.WHITE);
        menuBar.add(loginMenu);
        JMenuItem cadastrar = new JMenuItem("Cadastro");// Cria o item do menu
        JMenuItem login = new JMenuItem("Login");// Cria o item do menu
        loginMenu.add(cadastrar);// Adiciona o item ao menu "Arquivo"
        loginMenu.add(login);// Adiciona o item ao menu "Arquivo"

        JButton cadastroCategoria = new JButton("categoria");
        cadastroCategoria.setBorder(BorderFactory.createLineBorder(cor,4));
        cadastroCategoria.setBackground(cor);
        cadastroCategoria.setForeground(Color.WHITE);
        menuBar.add(cadastroCategoria);

        JButton cadastroProduto= new JButton("produto");
        cadastroProduto.setBorder(BorderFactory.createLineBorder(cor,4));
        cadastroProduto.setBackground(cor);
        cadastroProduto.setForeground(Color.WHITE);
        menuBar.add(cadastroProduto);

        setJMenuBar(menuBar);//Setando o menu no frame

        JLabel menuprin = new JLabel();
        add(menuprin);

        JButton cardapioButton = new JButton("Cardapio");
        cardapioButton.setSize(new Dimension(25,20));
        cardapioButton.setBounds(50,150, 300, 100);
        cardapioButton.setFont(font);
        cardapioButton.setBackground(cor);
        cardapioButton.setForeground(Color.WHITE);
        cardapioButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        menuprin.add(cardapioButton);

        JButton carrinhoButton = new JButton("Carrinho");
        carrinhoButton.setSize(new Dimension(25,20));
        carrinhoButton.setBounds(50, 255, 300, 100);
        carrinhoButton.setFont(font);
        carrinhoButton.setBackground(cor);
        carrinhoButton.setForeground(Color.WHITE);
        carrinhoButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        menuprin.add(carrinhoButton);

        JButton loginButton = new JButton("Login");
        loginButton.setSize(new Dimension(25,20));
        loginButton.setBounds(50, 360, 300, 100);
        loginButton.setFont(font);
        loginButton.setBackground(cor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        menuprin.add(loginButton);

        JButton cadastroButton = new JButton("Cadastro");
        cadastroButton.setSize(new Dimension(25,20));
        cadastroButton.setBounds(50, 465, 300, 100);
        cadastroButton.setFont(font);
        cadastroButton.setBackground(cor);
        cadastroButton.setForeground(Color.WHITE);
        cadastroButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        menuprin.add(cadastroButton);

        voltaMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Limpa o contêiner principal e adiciona novamente o conteúdo inicial
                getContentPane().removeAll();
                frame(); // Recria o menu principal
                revalidate();
                repaint();
            }
        });

        cardapioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cardapio cardapioButton = new Cardapio();

                getContentPane().removeAll();
                getContentPane().add(cardapioButton);
                revalidate();
                repaint();
            }
        });

        //Action produtosp
        cardapioMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cardapio cardapioButton = new Cardapio();

                getContentPane().removeAll();
                getContentPane().add(cardapioButton);
                revalidate();
                repaint();
            }
        });

        carrinhoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RealizarPedido finalizar = new RealizarPedido();

                getContentPane().removeAll();
                getContentPane().add(finalizar);
                revalidate();
                repaint();
            }
        });

        carrinho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RealizarPedido finalizar = new RealizarPedido();

                getContentPane().removeAll();
                getContentPane().add(finalizar);
                revalidate();
                repaint();
            }
        });
        
        cadastroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClientForm clientForm = new ClientForm();

                getContentPane().removeAll();
                getContentPane().add(clientForm);
                revalidate();
                repaint();
            }
        });
        //Action cadastrar
        cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClientForm clientForm = new ClientForm();

                getContentPane().removeAll();
                getContentPane().add(clientForm);
                revalidate();
                repaint();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginAdm loginAdm = new LoginAdm();

                getContentPane().removeAll();
                getContentPane().add(loginAdm);
                revalidate();
                repaint();
            }
        });
        
        //Action login
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginAdm loginAdm = new LoginAdm();

                getContentPane().removeAll();
                getContentPane().add(loginAdm);
                revalidate();
                repaint();
            }
        });
        //Action cadastrar produto
        cadastroProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroProduto cadastro_prod = new CadastroProduto();

                getContentPane().removeAll();
                getContentPane().add(cadastro_prod);
                revalidate();
                repaint();
            }
        });

        cadastroCategoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroCategoria cadastro_cat = new CadastroCategoria();

                getContentPane().removeAll();
                getContentPane().add(cadastro_cat);
                revalidate();
                repaint();
            }
        });
    }
}

