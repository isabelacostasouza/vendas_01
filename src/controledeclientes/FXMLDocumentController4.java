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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FXMLDocumentController4 implements Initializable {

    @FXML
    private TextField nomeCliente;

    @FXML
    private TextField telefoneCliente;

    @FXML
    private TextField bairroCliente;

    @FXML
    private TextField ruaCliente;

    @FXML
    private TextField numeroCliente;

    @FXML
    private Button btnCancelar;

    @FXML
    void cancelarEdicao(ActionEvent event) {
        Parent root;
       try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage2 = new Stage();
            Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
            stage2.getIcons().add(icone);
            stage2.setTitle("Meus clientes");
            stage2.setFullScreen(true);
            stage2.setScene(scene);
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
            stage2.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       Stage stage = (Stage) btnCancelar.getScene().getWindow();
       stage.close();
    }

    @FXML
    void concluir(ActionEvent event) {
        
       FXMLDocumentController c = new FXMLDocumentController();
       Cliente clienteAux = c.getClienteClicado();
        
       CarregarArquivo arquivo = new CarregarArquivo();
       Cliente clienteRemovido = arquivo.procurarClientes(clienteAux.getNome()).get(0);
       Cliente clienteAlterado = new Cliente();
       
       clienteAlterado.setNome(nomeCliente.getText().toString());
       clienteAlterado.setTelefone(telefoneCliente.getText().toString());
       clienteAlterado.setBairro(bairroCliente.getText().toString());
       clienteAlterado.setRua(ruaCliente.getText().toString());
       clienteAlterado.setNumero(numeroCliente.getText().toString());
       clienteAlterado.setEndereco();
       
       arquivo.removerCliente(clienteRemovido);
       arquivo.adicionarClienteArquivo(clienteAlterado);
       
       Parent root;
       try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage2 = new Stage();
            Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
            stage2.getIcons().add(icone);
            stage2.setTitle("Meus clientes");
            stage2.setFullScreen(true);
            stage2.setScene(scene);
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
            stage2.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       Stage stage = (Stage) btnCancelar.getScene().getWindow();
       stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        FXMLDocumentController c = new FXMLDocumentController();
        Cliente cliente = c.getClienteClicado();
        
        this.nomeCliente.setText(cliente.getNome());
        this.telefoneCliente.setText(cliente.getTelefone());
        this.bairroCliente.setText(cliente.getBairro());
        this.ruaCliente.setText(cliente.getRua());
        this.numeroCliente.setText(cliente.getNumero());
        
    }    

}
