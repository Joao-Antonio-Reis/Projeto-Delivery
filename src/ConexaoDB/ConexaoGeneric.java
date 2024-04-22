package ConexaoDB;

public class ConexaoGeneric {
    private static final String URL ="jdbc:mysql://localhost/japinha";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static String getURL() {
        return URL;
    }

    public static String getUSUARIO() {
        return USUARIO;
    }

    public static String getSENHA() {
        return SENHA;
    }
}
