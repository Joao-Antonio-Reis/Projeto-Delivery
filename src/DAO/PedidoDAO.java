package DAO;

import Models.Historico;
import Models.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO extends Conexao {

    private static Conexao dao = new Conexao();

    public void inserirPedido(Pedido pedido, int idCliente) throws SQLException {
        Connection conexao = dao.getConnection();
        try {
            String sqlPedido = "INSERT INTO Pedidos (ClienteID, ValorTotal, FormaPagamento) VALUES (?, ?, ?)";
            PreparedStatement stmtPedido = conexao.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
            stmtPedido.setInt(1, idCliente); // Corrigido para usar getClienteID
            stmtPedido.setDouble(2, pedido.getValor_Total_Pedido());
            stmtPedido.setString(3, pedido.getForma_Pagamento());
            stmtPedido.executeUpdate();

        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
    }

    public List<Historico> listarPedidos() throws SQLException {
        List<Historico> historicoList = new ArrayList<>();
        Connection conexao = dao.getConnection();
        String sql = "SELECT * FROM pedidos";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        try{
            while (rs.next()) {
                Historico historico = new Historico(
                        rs.getInt("PedidoID"),
                        rs.getInt("ClienteID"),
                        rs.getTimestamp("DataPedido").toLocalDateTime(),
                        rs.getBigDecimal("ValorTotal"),
                        rs.getString("FormaPagamento")
                );
                historicoList.add(historico);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return historicoList;
    }
}
