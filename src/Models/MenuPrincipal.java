package Models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JButton cardaioMenu = new JButton("Cardapio");
        cardaioMenu.setBorder(BorderFactory.createLineBorder(cor, 4));
        cardaioMenu.setBackground(cor);
        cardaioMenu.setForeground(Color.WHITE);
        menuBar.add(cardaioMenu);

        //Criando a opção carrinho
        JMenu carrinhoMenu = new JMenu("Carrinho");
        carrinhoMenu.setForeground(Color.WHITE);
        menuBar.add(carrinhoMenu);
        JMenuItem verCarrinho = new JMenuItem("Ver Carrinho");// Cria o item do menu
        carrinhoMenu.add(verCarrinho);// Adiciona o item ao menu "Arquivo"
        JMenuItem finalizarCompra = new JMenuItem("Finalizar compra");
        carrinhoMenu.add(finalizarCompra);

        //Criando a opção login
        JMenu loginMenu = new JMenu("Login");
        loginMenu.setForeground(Color.WHITE);
        menuBar.add(loginMenu);
        JMenuItem cadastar = new JMenuItem("Cadastro");// Cria o item do menu
        JMenuItem login = new JMenuItem("Login");// Cria o item do menu
        loginMenu.add(cadastar);// Adiciona o item ao menu "Arquivo"
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

        JLabel menuprin = new JLabel("Menu principal");
        menuprin.setBounds(5, 5, 100,20);
        add(menuprin);

        voltaMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Limpa o contêiner principal e adiciona novamente o conteúdo inicial
                getContentPane().removeAll();
                frame(); // Recria o menu principal
                revalidate();
                repaint();
            }
        });

        //Action produtos
        cardaioMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cardapio cardapio = new Cardapio();

                getContentPane().removeAll();
                getContentPane().add(cardapio);
                revalidate();
                repaint();
            }
        });

        finalizarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RealizarPedido finalizar = new RealizarPedido();

                getContentPane().removeAll();
                getContentPane().add(finalizar);
                revalidate();
                repaint();
            }
        });

        //Action cadastrar
        cadastar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClientForm clientForm = new ClientForm();

                getContentPane().removeAll();
                getContentPane().add(clientForm);
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
        cadastroProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroProduto cadastro_prod = new CadastroProduto();

                getContentPane().removeAll();
//                getContentPane().add(cadastro_prod);
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

