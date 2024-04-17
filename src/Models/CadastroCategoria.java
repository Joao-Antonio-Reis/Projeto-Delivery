package Models;

import javax.swing.*;
import java.awt.*;

public class CadastroCategoria extends JFrame{

    private JFrame frame;
    private JTextField catField;
    private JTextField descricaoField;

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
        setSize(800,800); //Define o tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Fecha o programa quando fecha a janela
        setResizable(false);//Não deixa mudar o tamanho
        setLocationRelativeTo(null); //abre o frame no meio da tela
        setLayout(null);

        JButton button = new JButton("Cadastrar");
        button.setBounds(650, 715, 125, 40);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.RED);
        add(button);

        JLabel nomeCatLabel = new JLabel("Nome Categoria: ");
        nomeCatLabel.setFont(new Font("Arial", Font.BOLD, 15));
        nomeCatLabel.setBounds(10, 10, 150, 20);
        add(nomeCatLabel);

        catField = new JTextField();
        catField.setBounds(130, 10, 150, 20);
        catField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(catField);


    }
}
