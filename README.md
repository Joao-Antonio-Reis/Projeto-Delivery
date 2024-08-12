# Projeto Delivery

O **Projeto Delivery** é uma aplicação Java desenvolvida para gerenciar um sistema de delivery. Este projeto inclui funcionalidades para gerenciar produtos, categorias, clientes e pedidos por meio de uma interface gráfica.

## Funcionalidades

- **Menu Principal**: Navegue entre as diferentes funcionalidades do sistema.
- **Cardápio**: Visualize produtos disponíveis e adicione-os ao carrinho.
- **Carrinho**: Revise itens adicionados e finalize a compra.
- **Cadastro**: Registre novos clientes ou edite os existentes.
- **Login Administrativo**: Acesse funcionalidades administrativas para gerenciar produtos e categorias.

## Estrutura do Projeto

O projeto é organizado seguindo o padrão de arquitetura MVC (Model-View-Controller):

- **Models**: Classes que representam os dados do sistema, como `Produto`, `Cliente`, `Pedido`, e `Adm`.
- **Views**: Interfaces gráficas para interação com o usuário, como `MenuPrincipalView`, `Cardapio`, `Carrinho`, etc.
- **Controllers**: Lógica de controle que conecta as views aos models, como `ControllerMenuPrincipal`, `ControllerCardapio`, etc.
- **DAO (Data Access Object)**: Classes que interagem com o banco de dados para persistência de dados.

## Pré-requisitos

- **Java**: Certifique-se de que a JDK está instalada no seu sistema.
- **Banco de Dados**: Configure o banco de dados conforme as especificações no script SQL fornecido (`Documents/SCRIPT_BD.SQL`).

## Como Executar

1. **Clone o Repositório**

   ```bash
   git clone https://github.com/Joao-Antonio-Reis/Projeto-Delivery.git
   cd Projeto-Delivery
Compile os Arquivos Java

Navegue até a pasta src e compile os arquivos Java:

bash
Copiar código
javac -d bin src/**/*.java
Execute a Aplicação

Inicie a aplicação executando o arquivo Main.java dentro do pacote Controllers:

bash
Copiar código
java -cp bin Controllers.Main
Uso
Navegação no Menu: Use os botões no menu principal para acessar diferentes partes do sistema, como o cardápio ou o carrinho.
Gerenciamento de Produtos: Adicione ou remova produtos através do menu de administração (requer login como administrador).
Finalização de Compras: No carrinho, revise e finalize seus pedidos escolhendo uma forma de pagamento.
Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou fazer pull requests.

Licença
Este projeto está licenciado sob a licença MIT - consulte o arquivo LICENSE para mais detalhes.

Contato
Para mais informações, entre em contato com o desenvolvedor:

João Antônio Reis
Email: joao@example.com
markdown
Copiar código

### Instruções Adicionais

- **Licença**: Inclua um arquivo de licença no repositório, se necessário.
- **Contato**: Substitua o e-mail de contato por um endereço válido.

Este `README.md` oferece uma descrição abrangente e instruções de uso para os usuários e de
