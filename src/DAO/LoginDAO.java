package DAO;

import DAO.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends Conexao {

    public boolean login(String login, String senha) {
        String sql = "SELECT * FROM administrador WHERE login = ? AND senha = ?";

        // Usando try-with-resources para garantir o fechamento automático de recursos
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Configurando os parâmetros da query
            statement.setString(1, login);
            statement.setString(2, senha);

            // Executando a query
            try (ResultSet rs = statement.executeQuery()) {
                // Verificando se há um resultado
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            // Lançando a exceção como RuntimeException para tratamento posterior
            throw new RuntimeException("Erro ao verificar login: ", e);
        }

        return false; // Retorna false se o login não for encontrado
    }
}