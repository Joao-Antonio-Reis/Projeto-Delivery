package Controllers;

import DAO.PedidoDAO;
import Models.Historico;
import Models.Pedido;
import Models.Produto;
import View.HistoricoPedidos;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.sql.SQLException;
import java.util.List;


public class ControllerHistorico implements InterfaceController{
    private HistoricoPedidos historicoView;
    private DefaultTableModel tableModel;
    private List<Historico> historico;

    public ControllerHistorico(HistoricoPedidos historicoView) {
        this.historicoView = historicoView;
        initView();
        initController();
    }

    @Override
    public void initView() {
        historicoView.setVisible(true);
        tableModel = (DefaultTableModel) historicoView.getTabelaPedidos().getModel();

        TableColumn coluna1 = historicoView.getTabelaPedidos().getColumnModel().getColumn(0);  // Coluna 0 (primeira)
        coluna1.setPreferredWidth(15);

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
            tableModel.addRow(new Object[]{h.getId(), h.getIdCliente(), h.getDataCadastro(),
                    h.getValor(), h.getFormaPagamento()});
        }
    }

}
