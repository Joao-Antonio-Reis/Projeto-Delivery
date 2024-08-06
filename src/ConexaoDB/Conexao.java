package ConexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL ="jdbc:mysql://localhost/japinha";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
