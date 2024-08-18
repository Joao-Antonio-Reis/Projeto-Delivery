package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HistoricoPedidos extends JLabel{
    private JTable tablePedidos;


    public HistoricoPedidos() {
        frameHistorico();
    }

    public void frameHistorico() {

        setVisible(true);
        setLayout(null);

        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Id", "Id Cliente","Data Pedido", "Valor","Pagamento"}, 0);

        tablePedidos = new JTable(tableModel);
        tablePedidos.setPreferredScrollableViewportSize(new Dimension(380, 200));

        JScrollPane scrollPane = new JScrollPane(tablePedidos);
        scrollPane.setBounds(0, 0, 400, 700);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
    }

    public JTable getTabelaPedidos() {
        return tablePedidos;
    }
}
