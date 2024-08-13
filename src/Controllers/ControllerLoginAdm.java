package Controllers;

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
        String login = loginView.getLoginField().getText();  // Obtém o texto do campo de login
        String senha = new String(loginView.getSenhaField().getPassword());  // Obtém a senha do campo de senha

        // Verifica se as credenciais são válidas
        if ("admin".equals(login) && "admin".equals(senha)) {
            // Se as credenciais estão corretas, mostra o menu administrativo e feedback positivo
            loginView.mostrarAdmMenu(true);
            loginView.getLogado().setText("Login efetuado com sucesso");
            loginView.getLogado().setForeground(Color.GREEN);

            // Limpa os campos de login e senha após o sucesso
            loginView.getLoginField().setText("");
            loginView.getSenhaField().setText("");

            // Ações adicionais pós-login, como navegar para outra tela, podem ser adicionadas aqui.
        } else {
            // Fornece feedback ao usuário em caso de falha no login
            loginView.getLogado().setText("Login falhou. Tente novamente.");
            loginView.getLogado().setForeground(Color.RED);
        }
    }
}
