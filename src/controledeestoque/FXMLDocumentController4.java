package controledeestoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FXMLDocumentController4 implements Initializable {

    @FXML
    private TextField txtNome;
    
    @FXML
    private TextField txtValor;

    @FXML
    private Button botaoSalvar;

    @FXML
    private Button botaoCancelar;

    @FXML
    void cancelarEdicao(ActionEvent event) {
       Parent root;
       try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
            stage.getIcons().add(icone);
            stage.setFullScreen(true);
            stage.setTitle("Estoque");
            stage.setScene(scene);
            stage.setOnCloseRequest( e -> {
                Parent root2;
                try {
                     root2 = FXMLLoader.load(getClass().getResource("/controlegeral/FXMLDocument.fxml"));
                     Scene scene2 = new Scene(root2);
                     Stage stage2 = new Stage();
                     stage2.setResizable(false);
                     stage2.getIcons().add(icone);
                     stage2.setTitle("Oficinas de vendas");
                     stage2.setScene(scene2);
                     stage2.show();
                } catch (IOException ex) {
                     Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
           });
           stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       Stage stage = (Stage) botaoCancelar.getScene().getWindow();
       stage.close();
    }

    @FXML
    void concluir(ActionEvent event) {
        
       FXMLDocumentController c = new FXMLDocumentController();
       Produto produtoAux = c.getProdutoClicado();
        
       CarregarArquivo arquivo = new CarregarArquivo();
       Produto produtoRemovido = arquivo.procurarProduto(produtoAux.getNome()).get(0);
       Produto produtoAlterado = new Produto();
       
       produtoAlterado.setNome(txtNome.getText().toString());
       produtoAlterado.setValor(Double.parseDouble(txtValor.getText().toString()));
       
       arquivo.removerProduto(produtoRemovido);
       arquivo.adicionarProdutoArquivo(produtoAlterado);
       
       Parent root;
       try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage2 = new Stage();
            Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
            stage2.getIcons().add(icone);
            stage2.setFullScreen(true);
            stage2.setTitle("Estoque");
            stage2.setOnCloseRequest( e -> {
                Parent root2;
                try {
                     root2 = FXMLLoader.load(getClass().getResource("/controlegeral/FXMLDocument.fxml"));
                     Scene scene2 = new Scene(root2);
                     stage2.setResizable(false);
                     Image icone2 = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
                     stage2.getIcons().add(icone2);
                     stage2.setTitle("Oficinas de vendas");
                     stage2.setScene(scene2);
                     stage2.show();
                } catch (IOException ex) {
                     Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            stage2.setScene(scene);
            stage2.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       Stage stage = (Stage) botaoCancelar.getScene().getWindow();
       stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        FXMLDocumentController c = new FXMLDocumentController();
        Produto produto = c.getProdutoClicado();
        
        this.txtNome.setText(produto.getNome());
        this.txtValor.setText(String.valueOf(produto.getValor()));
        
    }    

}
