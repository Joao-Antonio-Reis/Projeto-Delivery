package Controllers;

import DAO.PedidoDAO;
import Models.Historico;
import Models.Pedido;
import Models.Produto;
import View.HistoricoPedidos;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class ControllerHistorico implements InterfaceController{
    private HistoricoPedidos historicoView;
    private DefaultTableModel tableModel;
    private List<Historico> historico;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ControllerHistorico(HistoricoPedidos historicoView) {
        this.historicoView = historicoView;
        initView();
        initController();
    }

    @Override
    public void initView() {
        historicoView.setVisible(true);
        tableModel = (DefaultTableModel) historicoView.getTabelaPedidos().getModel();

        TableColumn coluna1 = historicoView.getTabelaPedidos().getColumnModel().getColumn(0);
        coluna1.setPreferredWidth(5);
        TableColumn coluna2 = historicoView.getTabelaPedidos().getColumnModel().getColumn(1);
        coluna2.setPreferredWidth(30);
        TableColumn coluna3 = historicoView.getTabelaPedidos().getColumnModel().getColumn(2);
        coluna3.setPreferredWidth(50);
        TableColumn coluna4 = historicoView.getTabelaPedidos().getColumnModel().getColumn(3);
        coluna4.setPreferredWidth(20);

        atualizarTabela();
    }

    @Override
    public void initController() {

    }
    // Atualiza a tabela de pedidos na interface gráfica
    private void atualizarTabela() {
        PedidoDAO pedidoDAO = new PedidoDAO();
        try {
            historico = pedidoDAO.listarPedidos();
        }catch (SQLException e){
            e.printStackTrace();
        }
        for (Historico h : historico) {
            // Adiciona cada produto como uma nova linha na tabela
            tableModel.addRow(new Object[]{h.getId(), h.getIdCliente(), h.getDataCadastro().format(formatter),
                    h.getValor(), h.getFormaPagamento()});
        }
    }

}
