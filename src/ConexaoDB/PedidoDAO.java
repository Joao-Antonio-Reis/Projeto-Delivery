package ConexaoDB;

import Models.Pedido;
import Models.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PedidoDAO extends Conexao {

    private static Conexao dao = new Conexao();

    public void inserirPedido(Pedido pedido) throws SQLException {
        Connection conexao = dao.getConnection();// Obtenha a conexão com o banco de dados
        try {
            // Inserir pedido
            String sqlPedido = "INSERT INTO Pedidos (ClienteID, ValorTotal, FormaPagamento) VALUES (?, ?, ?)";
            PreparedStatement stmtPedido = conexao.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
            stmtPedido.setInt(1, pedido.getCliente().getClienteId()); // Corrigido para usar getClienteID
            stmtPedido.setDouble(2, pedido.getValor_Total_Pedido());
            stmtPedido.setString(3, pedido.getForma_Pagamento());
            stmtPedido.executeUpdate();

            // Obter o ID do pedido inserido
            ResultSet generatedKeys = stmtPedido.getGeneratedKeys();
            int pedidoID = 0;
            if (generatedKeys.next()) {
                pedidoID = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Falha ao inserir pedido, nenhum ID gerado.");
            }
        } finally {
            if (conexao != null) {
                conexao.close(); // Feche a conexão
            }
        }
    }
}
