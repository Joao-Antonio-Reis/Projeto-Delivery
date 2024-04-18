package Models;

import javax.swing.*;
import java.awt.*;

public class CadastroCategoria extends JFrame{

    private JFrame frame;
    private JTextField catField;
    private JTextArea descField;
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136,0, 12);

    public static void main(String[] args) { //Testa a Label
        EventQueue.invokeLater(() -> {
            try {
                CadastroCategoria window = new CadastroCategoria();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CadastroCategoria() {
        frame(); // Chama o metodo do frame para mais privacidade
    }
    private void frame() {
        setTitle("Japinha Oriental Food - Cadastro Categoria");
        setVisible(true); //Visibilidade true
        setSize(415,800); //Define o tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Fecha o programa quando fecha a janela
        setResizable(false);//Não deixa mudar o tamanho
        setLocationRelativeTo(null); //abre o frame no meio da tela
        setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        // Cria os menus
        JMenu categoriasMenu = new JMenu("Categoria");
        JMenu carrinhoMenu = new JMenu("Carrinho");
        JMenu loginMenu = new JMenu("Login");

        menuBar.setBackground(cor);
        categoriasMenu.setForeground(Color.WHITE);
        carrinhoMenu.setForeground(Color.WHITE);
        loginMenu.setForeground(Color.WHITE);

        menuBar.add(categoriasMenu);
        menuBar.add(carrinhoMenu);
        menuBar.add(loginMenu);

        setJMenuBar(menuBar);


        JButton button = new JButton("Cadastrar");
        button.setBounds(270, 695, 125, 40);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setForeground(Color.WHITE);
        button.setBackground(cor);
        add(button);

        JLabel nomeCatLabel = new JLabel("Nome Categoria: ");
        nomeCatLabel.setFont(font);
        nomeCatLabel.setBounds(5, 5, 200, 20);
        add(nomeCatLabel);

        catField = new JTextField();
        catField.setBounds(125, 5, 270, 20);
        catField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(catField);

        JLabel descCat = new JLabel("Descrição");
        descCat.setBounds(5 , 30, 100, 20);
        descCat.setFont(font);
        add(descCat);

        descField = new JTextArea();
        descField.setBounds(5 ,50, 390, 200);
        descField.setFont(font);
        descField.setAlignmentY(JTextField.TOP); //Ajustar no topo
        descField.setLineWrap(true); // Quebra de linha automática
        descField.setWrapStyleWord(true); // Quebra de palavra
        descField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(descField);



    }
}
