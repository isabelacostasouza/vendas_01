package controlegeral;

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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label clientes;

    @FXML
    private Label estoque;

    @FXML
    private AnchorPane tableColumnNome;
    
    @FXML
    void getClientes(ActionEvent event) {
       Parent root;
       try {
           root = FXMLLoader.load(getClass().getResource("/controledeclientes/FXMLDocument.fxml"));
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
           stage.getIcons().add(icone);
           stage.setTitle("Meus clientes");
           stage.setScene(scene);
           stage.show();
           stage.setOnCloseRequest( e -> {
                Parent root2;
                try {
                     root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                     Scene scene2 = new Scene(root2);
                     Stage stage2 = new Stage();
                     stage2.setResizable(false);
                     Image icone2 = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
                     stage2.getIcons().add(icone2);
                     stage2.setTitle("Oficina de vendas");
                     stage2.setScene(scene2);
                     stage2.show();
                } catch (IOException ex) {
                     Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
           });
       } catch (IOException ex) {
           Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
        Stage stage3 = (Stage) tableColumnNome.getScene().getWindow();
        stage3.close();
    }

    @FXML
    void getEstoque(ActionEvent event) {
       Parent root;
       try {
           root = FXMLLoader.load(getClass().getResource("/controledeestoque/FXMLDocument.fxml"));
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
           stage.getIcons().add(icone);
           stage.setTitle("Estoque");
           stage.setScene(scene);
           stage.show();
           stage.setOnCloseRequest( e -> {
                Parent root2;
                try {
                     root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                     Scene scene2 = new Scene(root2);
                     Stage stage2 = new Stage();
                     stage2.setResizable(false);
                     Image icone2 = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
                     stage2.getIcons().add(icone2);
                     stage2.setTitle("Oficina de vendas");
                     stage2.setScene(scene2);
                     stage2.show();
                } catch (IOException ex) {
                     Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
           });
           Stage stage3 = (Stage) tableColumnNome.getScene().getWindow();
           stage3.close();
       } catch (IOException ex) {
           Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    @FXML
    void sobre(ActionEvent event) {
       Parent root;
       try {
           root = FXMLLoader.load(getClass().getResource("/controledeclientes/FXMLDocument5.fxml"));
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           stage.setResizable(false);
           Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
           stage.getIcons().add(icone);
           stage.setTitle("Sobre o app");
           stage.setScene(scene);
           stage.show();
       } catch (IOException ex) {
           Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @FXML
    void iniciarVenda(ActionEvent event) {
       Parent root;
       try {
           root = FXMLLoader.load(getClass().getResource("/controledevendas/FXMLDocument5.fxml"));
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
           stage.getIcons().add(icone);
           stage.setTitle("Venda");
           stage.setScene(scene);
           stage.show();
           stage.setOnCloseRequest( e -> {
                Parent root2;
                try {
                     root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                     Scene scene2 = new Scene(root2);
                     Stage stage2 = new Stage();
                     stage2.setResizable(false);
                     Image icone2 = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
                     stage2.getIcons().add(icone2);
                     stage2.setTitle("Oficina de vendas");
                     stage2.setScene(scene2);
                     stage2.show();
                } catch (IOException ex) {
                     Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
           });
           stage.show();
           Stage stage3 = (Stage) tableColumnNome.getScene().getWindow();
           stage3.close();
       } catch (IOException ex) {
           Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
}
