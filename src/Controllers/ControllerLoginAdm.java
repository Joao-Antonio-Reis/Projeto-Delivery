package Controllers;

import ConexaoDB.LoginDAO;
import View.LoginAdm;

import javax.swing.*;
import java.awt.*;

// Controlador para gerenciar a interface e a lógica de autenticação do administrador
public class ControllerLoginAdm implements InterfaceController {
    private LoginAdm loginView;  // Interface gráfica para login do administrador

    // Construtor que inicializa a interface de login
    public ControllerLoginAdm(LoginAdm loginView) {
        this.loginView = loginView;
        initView();  // Inicializa a interface gráfica
        initController();  // Inicializa controladores e eventos
    }

    @Override
    public void initView() {
        loginView.setVisible(true);  // Torna a interface de login visível
    }

    @Override
    public void initController() {
        // Adiciona um ouvinte de ação ao botão de login para processar a autenticação
        loginView.getLoginButton().addActionListener(e -> login());
    }

    // Método para realizar a autenticação do usuário
    private void login() {
        String login = loginView.getLoginField().getText();
        String senha = new String(loginView.getSenhaField().getPassword());

        if (login.isEmpty() || senha.isEmpty()) {
            loginView.getLogado().setText("Login e senha não podem estar vazios.");
            loginView.getLogado().setForeground(Color.RED);
            return;
        }

        LoginDAO loginDAO = new LoginDAO();

        try {
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
        } catch (RuntimeException e) {
            loginView.getLogado().setText("Erro ao tentar efetuar o login. Tente novamente mais tarde.");
            loginView.getLogado().setForeground(Color.RED);
            e.printStackTrace();
        }
    }
}
