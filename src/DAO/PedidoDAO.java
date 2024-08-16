package DAO;

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
        Connection conexao = dao.getConnection(); // Obtenha a conexão com o banco de dados
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

            // Inserir itens do pedido
            String sqlItem = "INSERT INTO ItensPedido (PedidoID, ProdutoID, Quantidade, PrecoUnitario) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtItem = conexao.prepareStatement(sqlItem); // Preparar fora do loop para eficiência
            for (Produto produto : pedido.getLista_produtos()) {
                stmtItem.setInt(1, pedidoID);
                stmtItem.setInt(2, produto.getId()); // Assume que Produto tem um método getId()
                stmtItem.setInt(3, 1); // Quantidade fixa como exemplo, ajustar conforme necessário
                stmtItem.setDouble(4, produto.getValor()); // Corrigido para usar getValor
                stmtItem.executeUpdate();
            }
        } finally {
            if (conexao != null) {
                conexao.close(); // Feche a conexão
            }
        }
    }
}
