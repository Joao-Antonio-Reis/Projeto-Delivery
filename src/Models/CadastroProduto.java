package Models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastroProduto {

        private JFrame frame;
        private JTextField nomeField;
        private JTextField categoriaField;
        private JTextField descricaoField;
        private JTextField valorField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CadastroProduto window = new CadastroProduto();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public CadastroProduto() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Japinha Oriental Food - Cadastro Cliente");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new FlowLayout());

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        frame.getContentPane().add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setColumns(10);
        nomeField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.getContentPane().add(nomeField);

        JLabel categoriaLabel = new JLabel("Categoria:");
        categoriaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        frame.getContentPane().add(categoriaLabel);

        categoriaField = new JTextField();
        categoriaField.setColumns(10);
        frame.getContentPane().add(categoriaField);

        JLabel valorLabel = new JLabel("Valor:");
        valorLabel.setFont(new Font("Arial", Font.BOLD, 15));
        frame.getContentPane().add(valorLabel);

        valorField = new JTextField();
        valorField.setColumns(10);
        frame.getContentPane().add(valorField);

        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        frame.getContentPane().add(descricaoLabel);

        descricaoField = new JTextField();
        descricaoField.setColumns(10);
        frame.getContentPane().add(descricaoField);

        JButton submitButton = new JButton("Submit");
        submitButton.setSize(new Dimension(25,15));
        //submitButton.setMargin(new Insets(10,10,10,10));
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setBackground(Color.RED);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        submitButton.addActionListener(new ActionListener() {
        
            // Terminar de fazer o método depois de linkar as categorias para poder selecionar a cada produto adicionado.
            public void actionPerformed(ActionEvent e) {
                
                String nome = nomeField.getText();
                String descricao = descricaoField.getText();
                String categorianome = categoriaField.getText();
                Double valor;
                try {
                    valor = Double.parseDouble(valorField.getText());
                } catch (NumberFormatException ex){
                    System.out.println("Digite o valor correto!");
                    valor = 0.0;
                }


               // Produto produto = new Produto(nome, categoria, descricao, valor);

                // Do something with the client object
            }
        });
        frame.getContentPane().add(submitButton);
    }
}
