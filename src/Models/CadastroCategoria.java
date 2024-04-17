package Models;

import javax.swing.*;
import java.awt.*;

public class CadastroCategoria extends JFrame{

    private JFrame frame;
    private JTextField catField;
    private JTextField descricaoField;
    private Font font = new Font("Arial", Font.BOLD, 15);
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


        JButton buttonCardapio = new JButton("Cardapio");
        buttonCardapio.setBounds(0, 0, 100, 20);
        buttonCardapio.setFont(font);
        buttonCardapio.setForeground(Color.BLACK);
        buttonCardapio.setBackground(Color.WHITE);
        add(buttonCardapio);

        JButton button2 = new JButton("Button2");
        button2.setBounds(100, 0, 100, 20);
        button2.setFont(font);
        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.WHITE);
        add(button2);

        JButton button3 = new JButton("Carrinho");
        button3.setBounds(200, 0, 100, 20);
        button3.setFont(font);
        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.WHITE);
        add(button3);

        JButton button4 = new JButton("Login");
        button4.setBounds(300, 0, 100, 20);
        button4.setFont(font);
        button4.setForeground(Color.BLACK);
        button4.setBackground(Color.WHITE);
        add(button4);

        JButton button = new JButton("Cadastrar");
        button.setBounds(270, 715, 125, 40);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.RED);
        add(button);

        JLabel nomeCatLabel = new JLabel("Nome Categoria: ");
        nomeCatLabel.setFont(font);
        nomeCatLabel.setBounds(5, 30, 125, 20);
        add(nomeCatLabel);

        catField = new JTextField();
        catField.setBounds(125, 30, 200, 20);
        catField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(catField);


    }
}
