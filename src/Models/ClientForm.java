package Models;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Generics.Cliente;
import Generics.Endereco;


public class ClientForm extends JFrame{
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
        frame();
    }

    private void frame() {

        setTitle("Japinha Oriental Food - Cadastro Cliente");
        setVisible(true); //Visibilidade true
        setSize(800,800); //Define o tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Fecha o programa quando fecha a janela
        setResizable(false);//Não deixa mudar o tamanho
        setLocationRelativeTo(null); //abre o frame no meio da tela
        setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        nomeLabel.setBounds(10, 10, 50, 20);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(60, 10, 280,20);
        nomeField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(nomeField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(10, 35, 80, 20);
        telefoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
        add(telefoneLabel);

        telefoneField = new JTextField();
        telefoneField.setBounds(80, 35,100,20);
        telefoneField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(telefoneField);

        JLabel bairroLabel = new JLabel("Bairro:");
        bairroLabel.setBounds(190, 35, 80, 20);
        bairroLabel.setFont(new Font("Arial", Font.BOLD, 15));
        add(bairroLabel);

        bairroField = new JTextField();
        bairroField.setBounds(240, 35, 100, 20);
        bairroField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(bairroField);

        JLabel ruaLabel = new JLabel("Rua:");
        ruaLabel.setBounds(10, 60, 40, 20);
        ruaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        add(ruaLabel);

        ruaField = new JTextField();
        ruaField.setBounds(45, 60, 200, 20);
        ruaField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(ruaField);

        JLabel numeroLabel = new JLabel("N°:");
        numeroLabel.setBounds(250, 60, 25, 20);
        numeroLabel.setFont(new Font("Arial", Font.BOLD, 15));
        add(numeroLabel);

        numeroField = new JTextField();
        numeroField.setBounds(272, 60, 68, 20);
        numeroField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        numeroField.setColumns(10);
        add(numeroField);

        JLabel complementoLabel = new JLabel("Complemento:");
        complementoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        add(complementoLabel);

        complementoField = new JTextField();
        complementoField.setColumns(10);
        add(complementoField);

        JButton submitButton = new JButton("Submit");
        submitButton.setSize(new Dimension(25,20));
        submitButton.setBounds(650, 715, 125, 40);
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setBackground(Color.RED);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String telefone = telefoneField.getText();
                String bairro = bairroField.getText();
                String rua = ruaField.getText();
                String numero = numeroField.getText();
                String complemento = complementoField.getText();

                Endereco address = new Endereco(bairro, rua, numero, complemento);
                Cliente client = new Cliente(nome, telefone, address);

                // Do something with the client object
            }
        });
        frame.getContentPane().add(submitButton);
    }

}