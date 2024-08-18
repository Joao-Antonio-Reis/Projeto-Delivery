package Controllers;

import DAO.ClienteDAO;
import DAO.EnderecoDAO;
import DAO.PedidoDAO;
import Models.Cliente;
import Models.Endereco;
import Models.Pedido;
import Models.Produto;
import View.ClientForm;
import View.PedidoView;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerClientForm implements InterfaceController {
    private ClientForm clientForm;
    private ArrayList<Produto> produtosMain;
    private double valorTotal;
    private boolean entrega;
    private String formaPagamento;
    private String observacao;
    private int idCliente;

    public ControllerClientForm(ClientForm clientForm, ArrayList<Produto> produtosMain, double valorTotal, boolean entrega, String formaPagamento, String observacao) {
        this.clientForm = clientForm;
        this.produtosMain = produtosMain;
        this.valorTotal = valorTotal;
        this.entrega = entrega;
        this.formaPagamento = formaPagamento;
        this.observacao = observacao;
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

    // Método que processa o cadastro do cliente
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
            idCliente = clienteDAO.inserirCliente(nome, telefone, email, enderecoId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar cliente.");
        }

        Cliente cliente = new Cliente(nome, telefone, email, new Endereco(bairro, rua, numero, complemento));
        Pedido pedido = new Pedido(cliente, produtosMain, valorTotal, formaPagamento, entrega, observacao);
        PedidoDAO pedidoDAO = new PedidoDAO();
        try {
            pedidoDAO.inserirPedido(pedido, idCliente);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        PedidoView pedidoView = new PedidoView(pedido, produtosMain);
    }
}
