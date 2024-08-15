package Controllers;

import ConexaoDB.ClienteDAO;
import ConexaoDB.EnderecoDAO;
import ConexaoDB.PedidoDAO;
import Models.Cliente;
import Models.Endereco;
import Models.Pedido;
import Models.Produto;
import View.ClientForm;
import View.PedidoView;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerClientForm implements InterfaceController{
    private ClientForm clientForm;
    private ArrayList<Produto> produtos;
    private double valorTotal;
    private boolean entrega;
    private String formaPagamento;

    public ControllerClientForm(ClientForm clientForm, ArrayList<Produto> produtos, double valorTotal, boolean entrega, String formaPagamento) {
        this.clientForm = clientForm;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.entrega = entrega;
        this.formaPagamento = formaPagamento;
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
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        try {
            int enderecoId = enderecoDAO.inserirEndereco(bairro, rua, numero, complemento);
            int clienteId = clienteDAO.inserirCliente(nome, telefone, email, enderecoId);

            Cliente cliente = new Cliente(clienteId, nome, telefone, email, new Endereco(bairro, rua, numero, complemento));
            Pedido pedido = new Pedido(cliente, produtos, valorTotal, formaPagamento, entrega);

            PedidoDAO pedidoDAO = new PedidoDAO();
            pedidoDAO.inserirPedido(pedido);

            PedidoView pedidoView = new PedidoView(pedido);

        } catch (SQLException e) {
            e.printStackTrace();  // Exibe o erro no console para depuração
            System.out.println("Erro ao cadastrar cliente ou inserir pedido.");
        }
    }

}
