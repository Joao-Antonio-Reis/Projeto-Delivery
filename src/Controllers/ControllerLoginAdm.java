package Controllers;

import DAO.LoginDAO;
import View.LoginAdm;

import java.awt.*;

public class ControllerLoginAdm implements InterfaceController {
    private LoginAdm loginView;

    // Construtor que inicializa a interface de login
    public ControllerLoginAdm(LoginAdm loginView) {
        this.loginView = loginView;
        initView();
        initController();
    }

    @Override
    public void initView() {
        loginView.setVisible(true);
    }

    @Override
    public void initController() {
        loginView.getLoginButton().addActionListener(e -> login());
    }

    private void login() {
        String login = loginView.getLoginField().getText();
        String senha = new String(loginView.getSenhaField().getPassword());
        LoginDAO loginDAO = new LoginDAO();

        if (loginDAO.login(login, senha)) {
            loginView.mostrarAdmMenu(true);
            loginView.getLogado().setText("Login efetuado com sucesso");
            loginView.getLogado().setForeground(Color.GREEN);

            loginView.getLoginField().setText("");
            loginView.getSenhaField().setText("");

        } else {
            loginView.getLogado().setText("Login falhou. Tente novamente.");
            loginView.getLogado().setForeground(Color.RED);
            loginView.getLoginField().setText("");
            loginView.getSenhaField().setText("");
        }
    }
    private void deslogar(){

    }
}
