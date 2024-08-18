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
    private JMenuItem logout;
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
        voltaMenu.setBackground(cor);
        voltaMenu.setForeground(Color.WHITE);
        menuBar.add(voltaMenu);

        cardapioMenu = new JButton("Cardapio");
        cardapioMenu.setBackground(cor);
        cardapioMenu.setForeground(Color.WHITE);
        menuBar.add(cardapioMenu);

        carrinhoMenu = new JButton("Carrinho");
        carrinhoMenu.setForeground(Color.WHITE);
        carrinhoMenu.setBackground(cor);
        menuBar.add(carrinhoMenu);

        loginMenu = new JButton("Login");
        loginMenu.setBackground(cor);
        loginMenu.setForeground(Color.WHITE);
        menuBar.add(loginMenu);


        admMenu = new JMenu("ADM");
        menuBar.add(admMenu);
        mostrarAdmMenu(logado);

        cadastroCategoria = new JMenuItem("Cadastrar Categoria");
        cadastroCategoria.setBackground(cor);
        admMenu.add(cadastroCategoria);

        cadastroProduto = new JMenuItem("Cadastrar Produto");
        cadastroProduto.setBackground(cor);
        admMenu.add(cadastroProduto);

        historico = new JMenuItem("Historico");
        historico.setBackground(cor);
        admMenu.add(historico);

        logout = new JMenuItem("Logout");
        logout.setBackground(cor);
        admMenu.add(logout);

        setJMenuBar(menuBar);

        menuprin = new JLabel();
        add(menuprin);

        JPanel imagemPanel = new JPanel();
        imagemPanel.setBounds(5, 0, 405, 205);
        ImageIcon imagemIcon = new ImageIcon("Imagens/Logo.png");
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

    public JMenuItem getLogout() {
        return logout;
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
