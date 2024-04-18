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
        JMenu categoriasMenu = new JMenu("Cardapio");
        categoriasMenu.setForeground(Color.WHITE);
        menuBar.add(categoriasMenu);
        JMenuItem produtos = new JMenuItem("Produtos");// Cria o item do menu
        categoriasMenu.add(produtos);// Adiciona o item ao menu "Arquivo"

        //Criando a opção carrinho
        JMenu carrinhoMenu = new JMenu("Carrinho");
        carrinhoMenu.setForeground(Color.WHITE);
        menuBar.add(carrinhoMenu);
        JMenuItem verCarrinho = new JMenuItem("Ver Carrinho");// Cria o item do menu
        carrinhoMenu.add(verCarrinho);// Adiciona o item ao menu "Arquivo"

        //Criando a opção login
        JMenu loginMenu = new JMenu("Login");
        loginMenu.setForeground(Color.WHITE);
        menuBar.add(loginMenu);
        JMenuItem cadastar = new JMenuItem("Cadastro");// Cria o item do menu
        JMenuItem login = new JMenuItem("Login");// Cria o item do menu
        loginMenu.add(cadastar);// Adiciona o item ao menu "Arquivo"
        loginMenu.add(login);// Adiciona o item ao menu "Arquivo"


        setJMenuBar(menuBar);//Setando o menu no frame

        //Action produtos
        produtos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Action cadastrar
        cadastar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClientForm clientForm = new ClientForm();

                // Adiciona o ClientForm ao MenuPrincipal
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

                // Adiciona o ClientForm ao MenuPrincipal
                getContentPane().removeAll();
                getContentPane().add(loginAdm);
                revalidate();
                repaint();
            }
        });
    }
}
