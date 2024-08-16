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
    private ClientForm clientForm; // Referência à interface gráfica do formulário de cliente
    private ArrayList<Produto> produtos; // Lista de produtos associados ao pedido
    private double valorTotal; // Valor total do pedido
    private boolean entrega; // Indica se o pedido inclui entrega
    private String formaPagamento; // Forma de pagamento escolhida pelo cliente
    private String observacao; // Observação adicional para o pedido
    private int idCliente;

    // Construtor que inicializa o controlador com os dados do cliente e do pedido
    public ControllerClientForm(ClientForm clientForm, ArrayList<Produto> produtos, double valorTotal, boolean entrega, String formaPagamento, String observacao) {
        this.clientForm = clientForm;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.entrega = entrega;
        this.formaPagamento = formaPagamento;
        this.observacao = observacao;
        initView(); // Inicializa a interface gráfica
        initController(); // Inicializa controladores e eventos
    }

    @Override
    public void initView() {
        clientForm.setVisible(true); // Torna o formulário de cliente visível
    }

    @Override
    public void initController() {
        // Adiciona um ouvinte de ação ao botão de envio para processar o cadastro do cliente
        clientForm.getSubmitButton().addActionListener(e -> cadastrarCliente());
    }

    // Método que processa o cadastro do cliente
    public void cadastrarCliente() {
        // Obtém os dados do cliente a partir dos campos de entrada da interface gráfica
        String nome = clientForm.getNomeField().getText();
        String telefone = clientForm.getTelefoneField().getText();
        String email = clientForm.getEmailField().getText();
        String bairro = clientForm.getBairroField().getText();
        String rua = clientForm.getRuaField().getText();
        String numero = clientForm.getNumeroField().getText();
        String complemento = clientForm.getCompleArea().getText();

        ClienteDAO clienteDAO = new ClienteDAO(); // Instância do DAO para interagir com o banco de dados de clientes
        EnderecoDAO endereco = new EnderecoDAO(); // Instância do DAO para interagir com o banco de dados de endereços

        try {
            // Insere o endereço no banco de dados e obtém o ID do endereço
            int enderecoId = endereco.inserirEndereco(bairro, rua, numero, complemento);
            // Insere o cliente no banco de dados associando-o ao ID do endereço
            idCliente = clienteDAO.inserirCliente(nome, telefone, email, enderecoId);
        } catch (Exception e) {
            e.printStackTrace(); // Captura e exibe exceções
            System.out.println("Erro ao cadastrar cliente.");
        }

        // Cria um objeto Cliente com os dados preenchidos
        Cliente cliente = new Cliente(nome, telefone, email, new Endereco(bairro, rua, numero, complemento));
        // Cria um objeto Pedido com o cliente, lista de produtos e outras informações do pedido
        Pedido pedido = new Pedido(cliente, produtos, valorTotal, formaPagamento, entrega, observacao);
        PedidoDAO pedidoDAO = new PedidoDAO();
        try {
            pedidoDAO.inserirPedido(pedido, idCliente);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Exibe a interface do PedidoView para visualizar o pedido criado
        PedidoView pedidoView = new PedidoView(pedido);
    }
}
