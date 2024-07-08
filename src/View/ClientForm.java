package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Models.Cliente;
import Models.Endereco;


public class ClientForm extends JPanel{
    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextField bairroField;
    private JTextField ruaField;
    private JTextField numeroField;
    private JTextArea compleArea;

    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136,0, 12);

//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//            try {
//                ClientForm window = new ClientForm();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }

    public ClientForm() {
        panelClienteForm();
    }

    public void panelClienteForm() {

        setVisible(true);
        setLayout(null);

        //Label Nome
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(font);
        nomeLabel.setBounds(5, 5, 50, 20);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(55, 5, 320,20);
        nomeField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(nomeField);

        //Label telefone
        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(5, 30, 80, 20);
        telefoneLabel.setFont(font);
        add(telefoneLabel);

        telefoneField = new JTextField();
        telefoneField.setBounds(75, 30,100,20);
        telefoneField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(telefoneField);

        //Label bairro
        JLabel bairroLabel = new JLabel("Bairro:");
        bairroLabel.setBounds(185, 30, 80, 20);
        bairroLabel.setFont(font);
        add(bairroLabel);

        bairroField = new JTextField();
        bairroField.setBounds(235, 30, 140, 20);
        bairroField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(bairroField);

        //Label rua
        JLabel ruaLabel = new JLabel("Rua:");
        ruaLabel.setBounds(5, 55, 38, 20);
        ruaLabel.setFont(font);
        add(ruaLabel);

        ruaField = new JTextField();
        ruaField.setBounds(38, 55, 200, 20);
        ruaField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(ruaField);

        //Label Numeri
        JLabel numeroLabel = new JLabel("N°:");
        numeroLabel.setBounds(245, 55, 25, 20);
        numeroLabel.setFont(font);
        add(numeroLabel);

        numeroField = new JTextField();
        numeroField.setBounds(268, 55, 68, 20);
        numeroField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        numeroField.setColumns(10);
        add(numeroField);

        //Label complemento
        JLabel complementoLabel = new JLabel("Complemento");
        complementoLabel.setBounds(5 , 75, 100, 20);
        complementoLabel.setFont(font);
        add(complementoLabel);

        compleArea = new JTextArea();
        compleArea.setBounds(5 ,95, 390, 100);
        compleArea.setFont(font);
        compleArea.setAlignmentY(JTextField.TOP); //Ajustar no topo
        compleArea.setLineWrap(true); // Quebra de linha automática
        compleArea.setWrapStyleWord(true); // Quebra de palavra
        compleArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(compleArea);

        //Button de submit
        JButton submitButton = new JButton("Submit");
        submitButton.setSize(new Dimension(25,20));
        submitButton.setBounds(270, 690, 125, 40);
        submitButton.setFont(font);
        submitButton.setBackground(cor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));

        submitButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                String nome = nomeField.getText();
                String telefone = telefoneField.getText();
                String bairro = bairroField.getText();
                String rua = ruaField.getText();
                String numero = numeroField.getText();
                String complemento = compleArea.getText();

                Endereco endereco = new Endereco(bairro, rua, numero, complemento);
                Cliente cliente = new Cliente(nome, telefone, endereco);

                int enderecoId = endereco.inserirEndereco(bairro, rua, numero, complemento);
                cliente.inserirCliente(nome, telefone, enderecoId);
                

                // Do something with the client object
            }
        });
        add(submitButton);
    }

}