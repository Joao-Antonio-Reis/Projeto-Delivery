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

import Generics.Cliente;
import Generics.Endereco;


public class ClientForm {
    private JFrame frame;
    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextField bairroField;
    private JTextField ruaField;
    private JTextField numeroField;
    private JTextField complementoField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ClientForm window = new ClientForm();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ClientForm() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Cadastro Cliente");
        frame.setBounds(500, 300, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        frame.getContentPane().add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setColumns(10);
        nomeField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.getContentPane().add(nomeField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
        frame.getContentPane().add(telefoneLabel);

        telefoneField = new JTextField();
        telefoneField.setColumns(10);
        frame.getContentPane().add(telefoneField);

        JLabel bairroLabel = new JLabel("Bairro:");
        bairroLabel.setFont(new Font("Arial", Font.BOLD, 15));
        frame.getContentPane().add(bairroLabel);

        bairroField = new JTextField();
        bairroField.setColumns(10);
        frame.getContentPane().add(bairroField);

        JLabel ruaLabel = new JLabel("Rua:");
        ruaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        frame.getContentPane().add(ruaLabel);

        ruaField = new JTextField();
        ruaField.setColumns(10);
        frame.getContentPane().add(ruaField);

        JLabel numeroLabel = new JLabel("Numero:");
        numeroLabel.setFont(new Font("Arial", Font.BOLD, 15));
        frame.getContentPane().add(numeroLabel);

        numeroField = new JTextField();
        numeroField.setColumns(10);
        frame.getContentPane().add(numeroField);

        JLabel complementoLabel = new JLabel("Complemento:");
        complementoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        frame.getContentPane().add(complementoLabel);

        complementoField = new JTextField();
        complementoField.setColumns(10);
        frame.getContentPane().add(complementoField);

        JButton submitButton = new JButton("Submit");
        submitButton.setSize(new Dimension(25,15));
        //submitButton.setMargin(new Insets(10,10,10,10));
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setBackground(Color.RED);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        submitButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                String nome = nomeField.getText();
                String telefone = telefoneField.getText();
                String bairro = bairroField.getText();
                String rua = ruaField.getText();
                String numero = numeroField.getText();
                String complemento = complementoField.getText();

                Endereco endereco = new Endereco(bairro, rua, numero, complemento);
                Cliente cliente = new Cliente(nome, telefone, endereco);

                cliente.informacaoCliente(cliente);

                // Do something with the client object
            }
        });
        frame.getContentPane().add(submitButton);
    }

}