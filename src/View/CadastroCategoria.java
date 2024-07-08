package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Models.Categoria;

public class CadastroCategoria extends JLabel{

    private JFrame frame;
    private JTextField catField;
    private JTextArea descField;
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136,0, 12);

    public static void main(String[] args) {
        
        //Testa a Label
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
        setVisible(true); //Visibilidade true
        setSize(415,800); //Define o tamanho da tela
        setLayout(null);

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

        JButton button = new JButton("Cadastrar");
        button.setBounds(270, 690, 120, 40);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setForeground(Color.WHITE);
        button.setBackground(cor);
        add(button);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String nome = catField.getText();
                String descricao = descField.getText();

                Categoria categoria = new Categoria();
                categoria.inserirCategoria(nome, descricao);

            }
        });
        add(button);
    }
}
