package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Enumeration;

public class Carrinho extends JLabel {
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136, 0, 12);
    private JTable tabelaProdutos;
    private JLabel valorFinal;
    private JButton submitButton;
    private JTextArea observacaoArea;
    private ButtonGroup formasPagamentoGroup;
    private JCheckBox entregaCheckBox; // Adiciona referência ao checkbox de entrega

    public Carrinho() {
        frameCarrinho();
    }

    public void frameCarrinho() {

        setVisible(true);
        setLayout(null);

        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Produto", "Preço"}, 0);

        tabelaProdutos = new JTable(tableModel);
        tabelaProdutos.setPreferredScrollableViewportSize(new Dimension(380, 200));

        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        scrollPane.setBounds(0, 0, 400, 450);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        add(scrollPane);

        entregaCheckBox = new JCheckBox("Entregar");
        entregaCheckBox.setBounds(5, 455, 200, 20);
        add(entregaCheckBox);

        JLabel formaPagamentoLabel = new JLabel("Forma de pagamento");
        formaPagamentoLabel.setBounds(5, 475, 200, 20);
        add(formaPagamentoLabel);

        JRadioButton creditCardRadioButton = new JRadioButton("Cartão de Crédito");
        creditCardRadioButton.setBounds(5, 490, 200, 20);
        JRadioButton debitCardRadioButton = new JRadioButton("Cartão de Débito");
        debitCardRadioButton.setBounds(5, 505, 200, 20);
        JRadioButton pixRadioButton = new JRadioButton("PIX");
        pixRadioButton.setBounds(5, 520, 200, 20);
        JRadioButton cashRadioButton = new JRadioButton("Dinheiro");
        cashRadioButton.setBounds(5, 535, 200, 20);

        formasPagamentoGroup = new ButtonGroup();
        formasPagamentoGroup.add(creditCardRadioButton);
        formasPagamentoGroup.add(debitCardRadioButton);
        formasPagamentoGroup.add(pixRadioButton);
        formasPagamentoGroup.add(cashRadioButton);

        add(creditCardRadioButton);
        add(debitCardRadioButton);
        add(pixRadioButton);
        add(cashRadioButton);

        JLabel obsLabel = new JLabel("Observação");
        obsLabel.setBounds(5, 555, 100, 20);
        obsLabel.setFont(font);
        add(obsLabel);

        observacaoArea = new JTextArea();
        observacaoArea.setBounds(5, 575, 390, 100);
        observacaoArea.setFont(font);
        observacaoArea.setAlignmentY(JTextField.TOP);
        observacaoArea.setLineWrap(true);
        observacaoArea.setWrapStyleWord(true);
        observacaoArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(observacaoArea);

        valorFinal = new JLabel("Valor total: R$ 0.00");
        valorFinal.setBounds(20, 695, 200, 30);
        valorFinal.setFont(font);
        add(valorFinal);

        submitButton = new JButton("Finalizar compra");
        submitButton.setSize(new Dimension(125, 40));
        submitButton.setBounds(270, 690, 125, 40);
        submitButton.setFont(font);
        submitButton.setBackground(cor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        add(submitButton);
    }

    public JTable getTabelaProdutos() {
        return tabelaProdutos;
    }

    public JLabel getValorFinalLabel() {
        return valorFinal;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JCheckBox getEntregaCheckBox() {
        return entregaCheckBox;
    }

    public String getFormaPagamentoSelecionada() {
        for (Enumeration<AbstractButton> buttons = formasPagamentoGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    public String getObservacao() {
        return observacaoArea.getText();
    }
}
