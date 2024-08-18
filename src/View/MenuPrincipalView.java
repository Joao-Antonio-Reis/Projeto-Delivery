package View;

import java.awt.*;

import javax.swing.*;

public class MenuPrincipalView extends JFrame {
    private JFrame frame;
    private JButton cardapioButton;
    private JButton carrinhoButton;
    private JButton loginButton;
    private JMenuItem cadastroCategoria;
    private JMenuItem cadastroProduto;
    private JMenuItem historico;
    private JButton loginMenu;
    private JButton carrinhoMenu;
    private JButton cardapioMenu;
    private JButton voltaMenu;
    private JLabel menuprin;

    private JPanel mainMenuPanel;

    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136, 0, 12);
    private Color menuBackgroundColor = Color.DARK_GRAY;
    private JMenuBar menuBar;
    private JMenu admMenu;
    private boolean logado = false;

    public MenuPrincipalView() {
        frameMenu();
    }

    private void frameMenu() {
        setTitle("Japinha Oriental Food");
        setSize(415, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setBackground(menuBackgroundColor);
        this.repaint();

        menuBar = new JMenuBar();
        menuBar.setBackground(cor);

        voltaMenu = new JButton("Menu");
        voltaMenu.setBorder(BorderFactory.createLineBorder(cor, 2));
        voltaMenu.setBackground(cor);
        voltaMenu.setForeground(Color.WHITE);
        menuBar.add(voltaMenu);

        cardapioMenu = new JButton("Cardapio");
        cardapioMenu.setBorder(BorderFactory.createLineBorder(cor, 2));
        cardapioMenu.setBackground(cor);
        cardapioMenu.setForeground(Color.WHITE);
        menuBar.add(cardapioMenu);

        carrinhoMenu = new JButton("Carrinho");
        carrinhoMenu.setBorder(BorderFactory.createLineBorder(cor, 2));
        carrinhoMenu.setForeground(Color.WHITE);
        carrinhoMenu.setBackground(cor);
        menuBar.add(carrinhoMenu);

        loginMenu = new JButton("Login");
        loginMenu.setBorder(BorderFactory.createLineBorder(cor, 2));
        loginMenu.setBackground(cor);
        loginMenu.setForeground(Color.WHITE);
        menuBar.add(loginMenu);


        admMenu = new JMenu("ADM");
        admMenu.setForeground(Color.WHITE);
        menuBar.add(admMenu);
        mostrarAdmMenu(logado);

        cadastroCategoria = new JMenuItem("Cadastrar Categoria");
        cadastroCategoria.setBorder(BorderFactory.createLineBorder(cor, 2));
        cadastroCategoria.setBackground(cor);
        cadastroCategoria.setForeground(Color.WHITE);
        admMenu.add(cadastroCategoria);

        cadastroProduto = new JMenuItem("Cadastrar Produto");
        cadastroProduto.setBorder(BorderFactory.createLineBorder(cor, 2));
        cadastroProduto.setBackground(cor);
        cadastroProduto.setForeground(Color.WHITE);
        admMenu.add(cadastroProduto);

        historico = new JMenuItem("Historico");
        historico.setBorder(BorderFactory.createLineBorder(cor, 2));
        historico.setBackground(cor);
        historico.setForeground(Color.WHITE);
        admMenu.add(historico);

        setJMenuBar(menuBar);

        menuprin = new JLabel();
        add(menuprin);

        JPanel imagemPanel = new JPanel();
        imagemPanel.setBounds(5, 0, 405, 205);
        ImageIcon imagemIcon = new ImageIcon("Imagens/Logo.jpeg");
        JLabel imagemLabel = new JLabel(imagemIcon);
        imagemPanel.add(imagemLabel);
        menuprin.add(imagemPanel);

        cardapioButton = new JButton("Cardapio");
        cardapioButton.setSize(new Dimension(25, 20));
        cardapioButton.setBounds(50, 260, 300, 100);
        cardapioButton.setFont(font);
        cardapioButton.setBackground(cor);
        cardapioButton.setForeground(Color.WHITE);
        menuprin.add(cardapioButton);

        carrinhoButton = new JButton("Carrinho");
        carrinhoButton.setSize(new Dimension(25, 20));
        carrinhoButton.setBounds(50, 365, 300, 100);
        carrinhoButton.setFont(font);
        carrinhoButton.setBackground(cor);
        carrinhoButton.setForeground(Color.WHITE);
        menuprin.add(carrinhoButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 470, 300, 100);
        loginButton.setFont(font);
        loginButton.setBackground(cor);
        loginButton.setForeground(Color.WHITE);
        menuprin.add(loginButton);

    }

    public JLabel getMenuprin() {
        return menuprin;
    }

    public JButton getCardapioButton() {
        return cardapioButton;
    }

    public JButton getCarrinhoButton() {
        return carrinhoButton;
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

    public JMenuItem getHistorico() {
        return historico;
    }

    public void changeContent(JLabel newContent) {
        getContentPane().removeAll();
        getContentPane().add(newContent);
        revalidate();
        repaint();
    }

    public void mostrarAdmMenu(boolean logado) {
        this.logado = logado;
        admMenu.setVisible(logado);
    }

    public boolean isLogado() {
        return logado;
    }
}
