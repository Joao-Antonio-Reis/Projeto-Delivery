package ConexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class DAO {

    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3306/japinha";
        final String USER = "root";
        final String SENHA = "";
        try {
            Connection connection = DriverManager.getConnection(URL, USER,SENHA);
            JOptionPane.showMessageDialog(null,"Conexão realizada com sucesso!");
            connection.close();
        }catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"Problemas na conexão com a fonte de dados \n"+ erro.toString());
        }
    }
}
