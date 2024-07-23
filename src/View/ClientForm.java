package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Models.Cliente;
import Models.Endereco;


public class ClientForm extends JLabel{
    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextField bairroField;
    private JTextField ruaField;
    private JTextField numeroField;
    private JTextField compleArea;

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

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(14,1));
        formPanel.setBounds(50, 50, 300, 400);
        
        add(formPanel);
        //Label Nome
        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setFont(font);
        // nomeLabel.setBounds(5, 5, 50, 20);
        formPanel.add(nomeLabel);

        nomeField = new JTextField();
        // nomeField.setBounds(55, 5, 320,20);
        nomeField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        formPanel.add(nomeField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(font);
        // emailLabel.setBounds(5, 5, 50, 20);
        formPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        // emailField.setBounds(55, 5, 320,20);
        emailField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        formPanel.add(emailField);

        //Label telefone
        JLabel telefoneLabel = new JLabel("Telefone");
        telefoneLabel.setBounds(5, 30, 80, 20);
        telefoneLabel.setFont(font);
        formPanel.add(telefoneLabel);

        telefoneField = new JTextField();
        telefoneField.setBounds(75, 30,100,20);
        telefoneField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        formPanel.add(telefoneField);

        //Label bairro
        JLabel bairroLabel = new JLabel("Bairro");
        bairroLabel.setBounds(185, 30, 80, 20);
        bairroLabel.setFont(font);
        formPanel.add(bairroLabel);

        bairroField = new JTextField();
        bairroField.setBounds(235, 30, 140, 20);
        bairroField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        formPanel.add(bairroField);

        //Label rua
        JLabel ruaLabel = new JLabel("Rua");
        // ruaLabel.setBounds(5, 55, 38, 20);
        ruaLabel.setFont(font);
        formPanel.add(ruaLabel);

        ruaField = new JTextField();
        // ruaField.setBounds(38, 55, 200, 20);
        ruaField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        formPanel.add(ruaField);

        //Label Numeri
        JLabel numeroLabel = new JLabel("N°");
        // numeroLabel.setBounds(245, 55, 25, 20);
        numeroLabel.setFont(font);
        formPanel.add(numeroLabel);

        numeroField = new JTextField();
        // numeroField.setBounds(268, 55, 68, 20);
        numeroField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        numeroField.setColumns(10);
        formPanel.add(numeroField);

        //Label complemento
        JLabel complementoLabel = new JLabel("Complemento");
        // complementoLabel.setBounds(5 , 75, 100, 20);
        complementoLabel.setFont(font);
        formPanel.add(complementoLabel);

        compleArea = new JTextField();

        // compleArea = new JTextArea();
        // compleArea.setBounds(5 ,95, 390, 100);
        // compleArea.setFont(font);
        // compleArea.setAlignmentY(JTextField.TOP); //Ajustar no topo
        // compleArea.setLineWrap(true); // Quebra de linha automática
        // compleArea.setWrapStyleWord(true); // Quebra de palavra
        compleArea.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        formPanel.add(compleArea);

        //Button de submit
        JButton submitButton = new JButton("Cadastrar");
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
                
                nomeField.setText("");
                telefoneField.setText("");
                numeroField.setText("");
                ruaField.setText("");
                bairroField.setText("");
                compleArea.setText("");
                // Do something with the client object
            }
        });
        add(submitButton);
    }

}