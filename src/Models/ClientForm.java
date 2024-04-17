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


public class ClientForm extends JFrame{
    private JFrame frame;
    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextField bairroField;
    private JTextField ruaField;
    private JTextField numeroField;
    private JTextField complementoField;

    private Font font = new Font("Arial", Font.BOLD, 15);

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

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(font);
        nomeLabel.setBounds(5, 30, 50, 20);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(55, 30, 320,20);
        nomeField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(nomeField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(5, 60, 80, 20);
        telefoneLabel.setFont(font);
        add(telefoneLabel);

        telefoneField = new JTextField();
        telefoneField.setBounds(75, 60,100,20);
        telefoneField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(telefoneField);

        JLabel bairroLabel = new JLabel("Bairro:");
        bairroLabel.setBounds(185, 60, 80, 20);
        bairroLabel.setFont(font);
        add(bairroLabel);

        bairroField = new JTextField();
        bairroField.setBounds(235, 60, 140, 20);
        bairroField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(bairroField);

        JLabel ruaLabel = new JLabel("Rua:");
        ruaLabel.setBounds(5, 90, 38, 20);
        ruaLabel.setFont(font);
        add(ruaLabel);

        ruaField = new JTextField();
        ruaField.setBounds(38, 90, 200, 20);
        ruaField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(ruaField);

        JLabel numeroLabel = new JLabel("N°:");
        numeroLabel.setBounds(245, 90, 25, 20);
        numeroLabel.setFont(font);
        add(numeroLabel);

        numeroField = new JTextField();
        numeroField.setBounds(268, 90, 68, 20);
        numeroField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        numeroField.setColumns(10);
        add(numeroField);

        JLabel complementoLabel = new JLabel("Complemento:");
        complementoLabel.setFont(font);
        add(complementoLabel);

        complementoField = new JTextField();
        complementoField.setColumns(10);
        add(complementoField);

        JButton submitButton = new JButton("Submit");
        submitButton.setSize(new Dimension(25,20));
        submitButton.setBounds(270, 715, 125, 40);
        submitButton.setFont(font);
        submitButton.setBackground(Color.RED);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));

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
        add(submitButton);
    }

}