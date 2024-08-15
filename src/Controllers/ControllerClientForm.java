package Controllers;

import ConexaoDB.ClienteDAO;
import ConexaoDB.EnderecoDAO;
import Models.Cliente;
import Models.Endereco;
import Models.Pedido;
import Models.Produto;
import View.ClientForm;
import View.PedidoView;

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
        EnderecoDAO endereco = new EnderecoDAO();
        try {
            int enderecoId = endereco.inserirEndereco(bairro, rua, numero, complemento);
            clienteDAO.inserirCliente(nome, telefone, email, enderecoId);
        }catch (Exception e){
            e.printStackTrace();  // Captura e exibe exceções
            System.out.println("Erro ao cadastrar cliente.");
        }

        Cliente cliente = new Cliente(nome,telefone,email, new Endereco(bairro,rua,numero,complemento));
        Pedido pedido = new Pedido(cliente, produtos,valorTotal, formaPagamento, entrega);
        PedidoView teste = new PedidoView(pedido);
    }
}
