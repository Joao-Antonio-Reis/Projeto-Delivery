package View;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import Models.Categoria;

public class CadastroCategoria extends JLabel {

    private JPanel panelRemover;
    private JTextField nomeCategoria;
    private JTextArea descricaoCategoria;
    private JButton cadastrarButton;
    private JLabel labelCategoria;
    private JButton removerCategoria;
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136, 0, 12);

    public CadastroCategoria() {
        frameCadastroCategoria();
    }

    private void frameCadastroCategoria() {
        setVisible(true);
        setSize(415, 800);
        setLayout(null);

        JLabel nomeCatLabel = new JLabel("Nome Categoria: ");
        nomeCatLabel.setFont(font);
        nomeCatLabel.setBounds(5, 5, 200, 20);
        add(nomeCatLabel);

        nomeCategoria = new JTextField();
        nomeCategoria.setBounds(125, 5, 270, 20);
        nomeCategoria.setBorder(new MatteBorder(0, 0, 2, 0, cor));
        add(nomeCategoria);

        JLabel descCat = new JLabel("Descrição");
        descCat.setBounds(5, 30, 100, 20);
        descCat.setFont(font);
        add(descCat);

        descricaoCategoria = new JTextArea();
        descricaoCategoria.setBounds(5, 50, 390, 200);
        descricaoCategoria.setAlignmentY(JTextField.TOP);
        descricaoCategoria.setLineWrap(true);
        descricaoCategoria.setWrapStyleWord(true);
        descricaoCategoria.setBorder(BorderFactory.createLineBorder(cor, 2));
        add(descricaoCategoria);

        JLabel removerLabel = new JLabel("Remover Categoria");
        removerLabel.setBounds(5, 280, 300, 20);
        removerLabel.setFont(font);
        add(removerLabel);

        panelRemover = new JPanel();
        panelRemover.setLayout(new BoxLayout(panelRemover, BoxLayout.Y_AXIS));
        panelRemover.setSize(400, 200);

        JScrollPane scrollPane = new JScrollPane(panelRemover);
        scrollPane.setBounds(0, 305, 400, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(270, 690, 120, 40);
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 15));
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setBackground(cor);
        add(cadastrarButton);
    }

    public String getNomeCategoria() {
        return (String) nomeCategoria.getText();
    }

    public String getDescricao() {
        return (String) descricaoCategoria.getText();
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public void limparCampos() {
        nomeCategoria.setText("");
        descricaoCategoria.setText("");
    }

    public void limparCategoriaParaRemover() {
        panelRemover.removeAll();
        panelRemover.revalidate();
        panelRemover.repaint();
    }

    public void adicionarCategoriaParaRemover(Categoria categoria, ActionListener removerAction) {
        JPanel productPanel = new JPanel();
        productPanel.setLayout(null);
        productPanel.setPreferredSize(new Dimension(380, 30));

        labelCategoria = new JLabel(categoria.getNome());
        labelCategoria.setBounds(5, 5, 200, 20);
        labelCategoria.setFont(new Font("Arial", Font.BOLD, 14));
        productPanel.add(labelCategoria);

        removerCategoria = new JButton("Remover");
        removerCategoria.setBackground(cor);
        removerCategoria.setForeground(Color.WHITE);
        removerCategoria.setBounds(250, 5, 100, 25);
        removerCategoria.setFocusPainted(false);
        removerCategoria.setRolloverEnabled(false);
        removerCategoria.addActionListener(removerAction);
        productPanel.add(removerCategoria);
        panelRemover.add(productPanel);
        panelRemover.revalidate();
        panelRemover.repaint();
    }
}
