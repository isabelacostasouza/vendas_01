package controledeestoque;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
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

public class FXMLDocumentController2 implements Initializable {

    @FXML
    private TextField txtNome;
    
    @FXML
    private TextField txtValor;

    @FXML
    private Button botaoSalvar;

    @FXML
    private Button botaoCancelar;

    @FXML
    void btnCancelar(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
            stage.getIcons().add(icone);
            stage.setFullScreen(true);
            stage.setTitle("Estoque");
            stage.setOnCloseRequest( e -> {
                Parent root2;
                try {
                    root2 = FXMLLoader.load(getClass().getResource("/controlegeral/FXMLDocument.fxml"));
                    Scene scene3 = new Scene(root2);
                    Stage stage3 = new Stage();
                    stage3.setResizable(false);
                    stage3.getIcons().add(icone);
                    stage3.setTitle("Oficinas de vendas");
                    stage3.setScene(scene3);
                    stage3.show();
               } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }
            });
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
         Stage stage = (Stage) botaoCancelar.getScene().getWindow(); 
         stage.close();
    }

    @FXML
    void btnSalvar(ActionEvent event) {
        Produto produto = new Produto();
        produto.setNome(txtNome.getText().toString());
        
        NumberFormat nf = NumberFormat.getNumberInstance();
        try {
            double number = nf.parse(txtValor.getText().toString()).doubleValue();
            produto.setValor(number);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CarregarArquivo arquivo = new CarregarArquivo();
        arquivo.adicionarProdutoArquivo(produto);
 
        Stage stage = (Stage) botaoSalvar.getScene().getWindow();
        stage.close();

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage2 = new Stage();
            stage.setFullScreen(true);
            Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
            stage2.getIcons().add(icone);
            stage2.setTitle("Estoque");
            stage.setOnCloseRequest( e -> {
                Parent root2;
                try {
                    root2 = FXMLLoader.load(getClass().getResource("/controlegeral/FXMLDocument.fxml"));
                    Scene scene3 = new Scene(root2);
                    Stage stage3 = new Stage();
                    stage3.setResizable(false);
                    stage3.getIcons().add(icone);
                    stage3.setTitle("Oficinas de vendas");
                    stage3.setScene(scene3);
                    stage3.show();
               } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }
            });
            stage2.setScene(scene);
            stage2.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
    }  

}
