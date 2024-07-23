package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPrincipalView extends JFrame {
    private JFrame frame;
    private JButton cardapioButton;
    private JButton carrinhoButton;
    private JButton cadastroButton;
    private JButton loginButton;
    private JMenuItem cadastroCategoria;
    private JMenuItem cadastroProduto;
    private JButton loginMenu;
    private JButton carrinhoMenu;
    private JButton cardapioMenu;
    private JButton voltaMenu;


    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136, 0, 12);
    private Color menuBackgroundColor = Color.DARK_GRAY;
    private JMenuBar menuBar;
    private JMenu admMenu;
    private boolean logado = false; // Flag para controle de loginMenu

//    public static void main(String[] args) {
//        // Categoria categoria = new Categoria();
//        // ArrayList<String> nomeCategorias = categoria.carregarCategoria();
//
//        // for (String aux : nomeCategorias) {
//        //     categoria.consultarProdutosPorCategoria(aux);
//        // }
//        EventQueue.invokeLater(() -> {
//            try {
//                MenuPrincipalView window = new MenuPrincipalView();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }

    public MenuPrincipalView() {
        frame();
    }

    private void frame() {

        setTitle("Japinha Oriental Food");
//        setVisible(true); //Visibilidade true
        setSize(415, 800); //Define o tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Fecha o programa quando fecha a janela
        setResizable(false);//Não deixa mudar o tamanho
        setLocationRelativeTo(null); //abre o frame no meio da tela
        setBackground(menuBackgroundColor);
        this.repaint();

        // Cria os menus
        menuBar = new JMenuBar();
        menuBar.setBackground(cor);

        //Criando a opção categoria
        voltaMenu = new JButton("Menu");
        voltaMenu.setBorder(BorderFactory.createLineBorder(cor, 4));
        voltaMenu.setBackground(cor);
        voltaMenu.setForeground(Color.WHITE);
        menuBar.add(voltaMenu);


        //Criando a opção categoria
        cardapioMenu = new JButton("Cardapio");
        cardapioMenu.setBorder(BorderFactory.createLineBorder(cor, 4));
        cardapioMenu.setBackground(cor);
        cardapioMenu.setForeground(Color.WHITE);
        menuBar.add(cardapioMenu);

        //Criando a opção carrinhoMenu
        carrinhoMenu = new JButton("Carrinho");
        carrinhoMenu.setBorder(BorderFactory.createLineBorder(cor, 4));
        carrinhoMenu.setForeground(Color.WHITE);
        carrinhoMenu.setBackground(cor);
        menuBar.add(carrinhoMenu);


        loginMenu = new JButton("Login");// Cria o item do menu
        loginMenu.setBorder(BorderFactory.createLineBorder(cor, 4));
        loginMenu.setBackground(cor);
        loginMenu.setForeground(Color.WHITE);
        menuBar.add(loginMenu);// Adiciona o item ao menu "Arquivo"

        admMenu = new JMenu("ADM");
        admMenu.setForeground(Color.WHITE);
        menuBar.add(admMenu);
        mostrarAdmMenu(logado); // Inicialmente esconde o menu ADM

        cadastroCategoria = new JMenuItem("Cadastrar Categoria");
        cadastroCategoria.setBorder(BorderFactory.createLineBorder(cor, 4));
        cadastroCategoria.setBackground(cor);
        cadastroCategoria.setForeground(Color.WHITE);
        admMenu.add(cadastroCategoria);

        cadastroProduto = new JMenuItem("Cadastrar Produto");
        cadastroProduto.setBorder(BorderFactory.createLineBorder(cor, 4));
        cadastroProduto.setBackground(cor);
        cadastroProduto.setForeground(Color.WHITE);
        admMenu.add(cadastroProduto);

        setJMenuBar(menuBar);//Setando o menu no frame

        JLabel menuprin = new JLabel();
        add(menuprin);

        cardapioButton = new JButton("Cardapio");
        cardapioButton.setSize(new Dimension(25, 20));
        cardapioButton.setBounds(50, 150, 300, 100);
        cardapioButton.setFont(font);
        cardapioButton.setBackground(cor);
        cardapioButton.setForeground(Color.WHITE);
        cardapioButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        menuprin.add(cardapioButton);

        carrinhoButton = new JButton("Carrinho");
        carrinhoButton.setSize(new Dimension(25, 20));
        carrinhoButton.setBounds(50, 255, 300, 100);
        carrinhoButton.setFont(font);
        carrinhoButton.setBackground(cor);
        carrinhoButton.setForeground(Color.WHITE);
        carrinhoButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        menuprin.add(carrinhoButton);

        loginButton = new JButton("Login");
        loginButton.setSize(new Dimension(25, 20));
        loginButton.setBounds(50, 360, 300, 100);
        loginButton.setFont(font);
        loginButton.setBackground(cor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        menuprin.add(loginButton);

        cadastroButton = new JButton("Cadastro");
        cadastroButton.setSize(new Dimension(25, 20));
        cadastroButton.setBounds(50, 465, 300, 100);
        cadastroButton.setFont(font);
        cadastroButton.setBackground(cor);
        cadastroButton.setForeground(Color.WHITE);
        cadastroButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        menuprin.add(cadastroButton);

//        voltaMenu.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Limpa o contêiner principal e adiciona novamente o conteúdo inicial
//                getContentPane().removeAll();
//                frame(); // Recria o menu principal
//                revalidate();
//                repaint();
//            }
//        });
//
//        cardapioButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                Cardapio cardapioButton = new Cardapio(frame);
//
//                getContentPane().removeAll();
//                getContentPane().add(cardapioButton);
//                revalidate();
//                repaint();
//            }
//        });
//
//        //Action produtos
//        cardapioMenu.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                Cardapio cardapioButton = new Cardapio(frame);
//
//                getContentPane().removeAll();
//                getContentPane().add(cardapioButton);
//                revalidate();
//                repaint();
//            }
//        });
//
//        carrinhoButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                RealizarPedido finalizar = new RealizarPedido();
//
//                getContentPane().removeAll();
//                getContentPane().add(finalizar);
//                revalidate();
//                repaint();
//            }
//        });
//
//        carrinhoMenu.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                RealizarPedido finalizar = new RealizarPedido();
//
//                getContentPane().removeAll();
//                getContentPane().add(finalizar);
//                revalidate();
//                repaint();
//            }
//        });
//
//        cadastroButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                ClientForm clientForm = new ClientForm();
//
//                getContentPane().removeAll();
//                getContentPane().add(clientForm);
//                revalidate();
//                repaint();
//            }
//        });
//        //Action cadastrar
//        cadastrar.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                ClientForm clientForm = new ClientForm();
//
//                getContentPane().removeAll();
//                getContentPane().add(clientForm);
//                revalidate();
//                repaint();
//            }
//        });
//
//        loginButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                LoginAdm loginAdm = new LoginAdm();
//
//                getContentPane().removeAll();
//                getContentPane().add(loginAdm);
//                revalidate();
//                repaint();
//            }
//        });
//
//        //Action loginMenu
//        loginMenu.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                LoginAdm loginAdm = new LoginAdm();
//                loginAdm.setMenuPrincipal(MenuPrincipalView.this); // Passa a referência do MenuPrincipal para LoginAdm
//
//                getContentPane().removeAll();
//                getContentPane().add(loginAdm);
//                revalidate();
//                repaint();
//            }
//        });
//
//        // Ação para cadastrar categoria
//        cadastroCategoria.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if (logado) {
//                    // Abre a tela de cadastro de categoria
//                    CadastroCategoria cadastroCategoriaForm = new CadastroCategoria();
//
//                    getContentPane().removeAll();
//                    getContentPane().add(cadastroCategoriaForm);
//                    revalidate();
//                    repaint();
//                } else {
//                    // Mostra mensagem ou ação de não autorizado
//                    System.out.println("Você precisa estar logado como ADM para acessar esta funcionalidade.");
//                }
//            }
//        });
//
//        // Ação para cadastrar produto
//        cadastroProduto.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if (logado) {
//                    // Abre a tela de cadastro de produto
//                    CadastroProduto cadastroProdutoForm = new CadastroProduto();
//
//                    getContentPane().removeAll();
//                    getContentPane().add(cadastroProdutoForm);
//                    revalidate();
//                    repaint();
//                } else {
//                    // Mostra mensagem ou ação de não autorizado
//                    System.out.println("Você precisa estar logado como ADM para acessar esta funcionalidade.");
//                }
//            }
//        });
//    }

    }
    public JButton getCardapioButton() {
        return cardapioButton;
    }

    public JButton getCarrinhoButton() {
        return carrinhoButton;
    }

    public JButton getCadastroButton() {
        return cadastroButton;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JMenuItem getCadastrarCategoriaItem() {
        return cadastroCategoria;
    }

    public JMenuItem getCadastrarProdutoItem() {
        return cadastroProduto;
    }

    public JButton getLoginMenu() {
        return loginMenu;
    }

    public JButton getCarrinhoMenu() {
        return carrinhoMenu;
    }

    public JButton getCardapioMenu() {
        return cardapioMenu;
    }

    public JButton getVoltaMenu() {
        return voltaMenu;
    }

    public void changeContent(JLabel newContent){
        getContentPane().removeAll();
        getContentPane().add(newContent);
        revalidate();
        repaint();
    }

    public void mostrarAdmMenu(boolean logado) {
        this.logado = logado;
        admMenu.setVisible(logado);
    }
}