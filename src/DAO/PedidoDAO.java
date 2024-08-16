package DAO;

import Models.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PedidoDAO extends Conexao {

    private static Conexao dao = new Conexao();

    public void inserirPedido(Pedido pedido, int idCliente) throws SQLException {
        Connection conexao = dao.getConnection(); // Obtenha a conexão com o banco de dados
        try {
            // Inserir pedido
            String sqlPedido = "INSERT INTO Pedidos (ClienteID, ValorTotal, FormaPagamento) VALUES (?, ?, ?)";
            PreparedStatement stmtPedido = conexao.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
            stmtPedido.setInt(1, idCliente); // Corrigido para usar getClienteID
            stmtPedido.setDouble(2, pedido.getValor_Total_Pedido());
            stmtPedido.setString(3, pedido.getForma_Pagamento());
            stmtPedido.executeUpdate();

        } finally {
            if (conexao != null) {
                conexao.close(); // Feche a conexão
            }
        }
    }
}
