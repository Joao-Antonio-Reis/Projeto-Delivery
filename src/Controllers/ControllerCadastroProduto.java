package Controllers;

import ConexaoDB.ProdutoDAO;
import View.CadastroProduto;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ControllerCadastroProduto {
    private CadastroProduto cadastroProdutoView;

    public ControllerCadastroProduto(CadastroProduto cadastroProdutoView) {
        this.cadastroProdutoView = cadastroProdutoView;

        initView();
        initController();
    }

    private void initView(){
        cadastroProdutoView.setVisible(true);
    }
    private void initController(){

    }

//    private void nomeTextField(){
//
//    }
//    private void precoTextField(){
//
//    }
//    private void categoriaComboBox(){
//
//    }
//    private void uploadImagemButton(){
//
//    }
//    private void descricaoTextArea(){
//
//    }
    private void cadastrarButton(){
        String nome = nomeField.getText();
        String valor = precoField.getText();
        valor = valor.replace(",", ".");
        BigDecimal preco = BigDecimal.ZERO;

        if (selectedFile != null) {
            String caminhoImagem = "Imagens/" + selectedFile.getName();
            File destFile = new File(caminhoImagem);

            File imagensDir = new File("Imagens");
            if (!imagensDir.exists()) {
                imagensDir.mkdir();
            }

            try {
                Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                preco = new BigDecimal(valor);
            } catch (NumberFormatException error) {
                System.out.println("Erro ao converter o preço: ");
                error.printStackTrace();
            }

            String categoriaSelecionada = (String) categoriaBox.getSelectedItem();
            String descricao = descProdutoArea.getText();

            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.inserirProduto(nome, categoriaSelecionada, descricao, preco, caminhoImagem);

            nomeField.setText("");
            precoField.setText("");
            descProdutoArea.setText("");
            imageLabel.setText("");

            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Por favor, selecione uma imagem!");
        }
    }
    }
    private void removerProdutoButton(){

    }

}
