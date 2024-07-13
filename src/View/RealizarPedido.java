package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class RealizarPedido extends JLabel {
    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color cor = new Color(136, 0, 12);
    private String formaPagamento;

    public RealizarPedido() {
        realizarpedidoLabel();
    }

    public void realizarpedidoLabel() {

        setVisible(true); // Visibilidade true
        setLayout(null); // Deixa o layout null

        JPanel panelPedido = new JPanel();
        panelPedido.setLayout(new BoxLayout(panelPedido, BoxLayout.Y_AXIS)); // Layout para organizar componentes verticalmente
        panelPedido.setPreferredSize(new Dimension(400, 2000));

        JScrollPane scrollPane = new JScrollPane(panelPedido);
        scrollPane.setBounds(0, 0, 400, 450); // Define a posição e tamanho do painel de rolagem
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Sempre mostra a barra de rolagem vertical
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Nunca mostra a barra de rolagem horizontal
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 2)); // Borda preta ao redor do painel de rolagem
        add(scrollPane); // Define o tamanho preferido do painel

        JCheckBox checkBox = new JCheckBox("Retirada no local");
        checkBox.setBounds(5, 455, 200, 20);

        // Adicionando um listener para capturar eventos de seleção
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Buscar");
                } else {
                    System.out.println("Entregar");
                }
            }
        });

        // Adicionando a checkbox ao frame
        add(checkBox);
        JLabel formaPagamento = new JLabel("Forma de pagamento");
        formaPagamento.setBounds(5, 475, 200, 20);
        add(formaPagamento);
        // Criação dos JRadioButton para formas de pagamento
        JRadioButton creditCardRadioButton = new JRadioButton("Cartão de Crédito");
        creditCardRadioButton.setBounds(5, 490, 200, 20);
        JRadioButton debitCardRadioButton = new JRadioButton("Cartão de Débito");
        debitCardRadioButton.setBounds(5, 505, 200, 20);
        JRadioButton pixRadioButton = new JRadioButton("PIX");
        pixRadioButton.setBounds(5, 520, 200, 20);
        JRadioButton cashRadioButton = new JRadioButton("Dinheiro");
        cashRadioButton.setBounds(5, 535, 200, 20);

        // Agrupando os JRadioButton para seleção exclusiva
        ButtonGroup formasPagamento = new ButtonGroup();
        formasPagamento.add(creditCardRadioButton);
        formasPagamento.add(debitCardRadioButton);
        formasPagamento.add(pixRadioButton);
        formasPagamento.add(cashRadioButton);

        // Adicionando os JRadioButton ao panelPedido
        add(creditCardRadioButton);
        add(debitCardRadioButton);
        add(pixRadioButton);
        add(cashRadioButton);

        JLabel obsLabel = new JLabel("Observação");
        obsLabel.setBounds(5 , 555, 100, 20);
        obsLabel.setFont(font);
        add(obsLabel);

        JTextArea observacaoArea = new JTextArea();
        observacaoArea.setBounds(5 ,575, 390, 100);
        observacaoArea.setFont(font);
        observacaoArea.setAlignmentY(JTextField.TOP); //Ajustar no topo
        observacaoArea.setLineWrap(true); // Quebra de linha automática
        observacaoArea.setWrapStyleWord(true); // Quebra de palavra
        observacaoArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(observacaoArea);

        JButton submitButton = new JButton("Finalizar compra");
        submitButton.setSize(new Dimension(125, 40));
        submitButton.setBounds(270, 690, 125, 40);
        submitButton.setFont(font);
        submitButton.setBackground(cor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        add(submitButton);

        // Adicionando ação ao botão "Finalizar compra"
        // submitButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         if (creditCardRadioButton.isSelected()) {
        //             formaPagamento = "Cartão de Crédito";
        //         } else if (debitCardRadioButton.isSelected()) {
        //             formaPagamento = "Cartão de Débito";
        //         } else if (pixRadioButton.isSelected()) {
        //             formaPagamento = "PIX";
        //         } else if (cashRadioButton.isSelected()) {
        //             formaPagamento = "Dinheiro";
        //         }
        //         System.out.println("Forma de pagamento selecionada: " + formaPagamento);
        //     }
        // });
    }
}