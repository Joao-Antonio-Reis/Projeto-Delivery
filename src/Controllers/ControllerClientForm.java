package Controllers;

import ConexaoDB.ClienteDAO;
import ConexaoDB.EnderecoDAO;
import Models.Cliente;
import Models.Endereco;
import View.ClientForm;

public class ControllerClientForm implements InterfaceController{
    private ClientForm clientForm;
    public ControllerClientForm(ClientForm clientForm) {
        this.clientForm = clientForm;
        initView();
        initController();
    }
    @Override
    public void initView() {
        clientForm.setVisible(true);
    }

    @Override
    public void initController() {
        clientForm.getSubmitButton().addActionListener(e -> cadastrarCliente());
    }

    public void cadastrarCliente() {
        String nome = clientForm.getNomeField().getText();
        String telefone = clientForm.getTelefoneField().getText();
        String email = clientForm.getEmailField().getText();
        String bairro = clientForm.getBairroField().getText();
        String rua = clientForm.getRuaField().getText();
        String numero = clientForm.getNumeroField().getText();
        String complemento = clientForm.getCompleArea().getText();

        ClienteDAO clienteDAO = new ClienteDAO();
        EnderecoDAO endereco = new EnderecoDAO();
        try {
            int enderecoId = endereco.inserirEndereco(bairro, rua, numero, complemento);
            clienteDAO.inserirCliente(nome, telefone, email, enderecoId);
        }catch (Exception e){
            e.printStackTrace();  // Captura e exibe exceções
            System.out.println("Erro ao cadastrar cliente.");
        }

    }
}
