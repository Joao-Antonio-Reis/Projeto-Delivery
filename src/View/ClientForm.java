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

import ConexaoDB.ClienteDAO;
import ConexaoDB.EnderecoDAO;
import Models.Cliente;
import Models.Endereco;

public class ClientForm extends JLabel {
    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextField emailField;
    private JTextField bairroField;
    private JTextField ruaField;
    private JTextField numeroField;
    private JTextField compleArea;
    private JButton submitButton;

    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136, 0, 12);

    public ClientForm() {
        frameForm();
    }

    public void frameForm() {
        setVisible(true);
        setLayout(null);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(14, 1));
        formPanel.setBounds(50, 50, 300, 400);

        add(formPanel);

        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setFont(font);
        formPanel.add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        formPanel.add(nomeField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(font);
        formPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        formPanel.add(emailField);

        JLabel telefoneLabel = new JLabel("Telefone");
        telefoneLabel.setBounds(5, 30, 80, 20);
        telefoneLabel.setFont(font);
        formPanel.add(telefoneLabel);

        telefoneField = new JTextField();
        telefoneField.setBounds(75, 30, 100, 20);
        telefoneField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        formPanel.add(telefoneField);

        JLabel bairroLabel = new JLabel("Bairro");
        bairroLabel.setBounds(185, 30, 80, 20);
        bairroLabel.setFont(font);
        formPanel.add(bairroLabel);

        bairroField = new JTextField();
        bairroField.setBounds(235, 30, 140, 20);
        bairroField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        formPanel.add(bairroField);

        JLabel ruaLabel = new JLabel("Rua");
        ruaLabel.setFont(font);
        formPanel.add(ruaLabel);

        ruaField = new JTextField();
        ruaField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        formPanel.add(ruaField);

        JLabel numeroLabel = new JLabel("N°");
        numeroLabel.setFont(font);
        formPanel.add(numeroLabel);

        numeroField = new JTextField();
        numeroField.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        numeroField.setColumns(10);
        formPanel.add(numeroField);

        JLabel complementoLabel = new JLabel("Complemento");
        complementoLabel.setFont(font);
        formPanel.add(complementoLabel);

        compleArea = new JTextField();
        compleArea.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        formPanel.add(compleArea);

        submitButton = new JButton("Cadastrar");
        submitButton.setSize(new Dimension(25, 20));
        submitButton.setBounds(270, 690, 125, 40);
        submitButton.setFont(font);
        submitButton.setBackground(cor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));

        add(submitButton);
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public JTextField getTelefoneField() {
        return telefoneField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getBairroField() {
        return bairroField;
    }

    public JTextField getRuaField() {
        return ruaField;
    }

    public JTextField getNumeroField() {
        return numeroField;
    }

    public JTextField getCompleArea() {
        return compleArea;
    }
}
