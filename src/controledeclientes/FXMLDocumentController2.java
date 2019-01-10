package controledeclientes;

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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController2 implements Initializable {

    @FXML
    private AnchorPane tableColumnNome;

    @FXML
    private TextField txtRua;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtBairro;

    @FXML
    private TextField txtTelefone;

    @FXML
    void btnCancelar(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
            stage.getIcons().add(icone);
            stage.setTitle("Meus clientes");
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
            stage.setOnCloseRequest( e -> {
                Parent root2;
                        Parent root3;
                        try {
                             root3 = FXMLLoader.load(getClass().getResource("/controlegeral/FXMLDocument.fxml"));
                             Scene scene3 = new Scene(root3);
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
                } catch (IOException ex) {
                     Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
         Stage stage = (Stage) tableColumnNome.getScene().getWindow(); 
         stage.close();
    }

    @FXML
    void btnSalvar(ActionEvent event) {
        Cliente cliente = new Cliente();
        cliente.setNome(txtNome.getText().toString());
        cliente.setTelefone(txtTelefone.getText().toString());
        cliente.setBairro(txtBairro.getText().toString());
        cliente.setRua(txtRua.getText().toString());
        cliente.setNumero(txtNumero.getText().toString());
        
        CarregarArquivo arquivo = new CarregarArquivo();
        arquivo.adicionarClienteArquivo(cliente);
 
        Stage stageAux = (Stage) tableColumnNome.getScene().getWindow();
        stageAux.close();

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
            stage.getIcons().add(icone);
            stage.setFullScreen(true);
            stage.setTitle("Meus clientes");
            stage.setScene(scene);
            stage.setOnCloseRequest( e -> {
                Parent root2;
                try {
                     root2 = FXMLLoader.load(getClass().getResource("/controlegeral/FXMLDocument.fxml"));
                     Scene scene2 = new Scene(root2);
                     Stage stage2 = new Stage();
                     stage2.setResizable(false);
                     Image icone2 = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
                     stage2.getIcons().add(icone2);
                     stage2.setTitle("Oficina de vendas");
                     stage2.setScene(scene2);
                     stage2.show();
                } catch (IOException ex) {
                     Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
           });
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
    }  

}
