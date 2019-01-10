package controledeclientes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
   @FXML
    private TextField txtPesquisa;

    @FXML
    private Button btnAddCliente;

    @FXML
    private ListView listaClientes;

    @FXML
    private TableView<Cliente> tableClientes;
    
    @FXML
    private TableColumn<Cliente, String> tableColumnCliente;

    @FXML
    private TableColumn<Cliente, String> tableColumnTelefone;

    @FXML
    private TableColumn<Cliente, String> tableColumnEndereco;

    @FXML
    public void botaoAddCliente(ActionEvent event) {
       Parent root;
       try {
           root = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           stage.setResizable(false);
           Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
           stage.getIcons().add(icone);
           stage.setTitle("Adicionar cliente");
           stage.setScene(scene);
           stage.setOnCloseRequest( e -> {
                Parent root2;
                try {
                     root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                     Scene scene2 = new Scene(root2);
                     Stage stage2 = new Stage();
                     stage.setFullScreen(true);
                     stage2.getIcons().add(icone);
                     stage2.setTitle("Meus clientes");
                     stage2.setOnCloseRequest( f -> {
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
       Stage stage = (Stage) tableClientes.getScene().getWindow();
       stage.close();
    }
    
    @FXML
    public void botaoExcluirCliente(ActionEvent event) {
       CarregarArquivo arquivo = new CarregarArquivo();
       Cliente cliente = arquivo.procurarClientes(tableClientes.getSelectionModel().getSelectedItem().getNome()).get(0);
       arquivo.removerCliente(cliente);
       
       tableClientes.getItems().removeAll(tableClientes.getSelectionModel().getSelectedItem());
    }  

    @FXML
    void botaoEditarCliente(ActionEvent event) {
        CarregarArquivo arquivo = new CarregarArquivo();
        Cliente cliente = arquivo.procurarClientes(tableClientes.getSelectionModel().getSelectedItem().getNome()).get(0);
        setClienteClicado(cliente);
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument4.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setResizable(false);
            Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
            stage.getIcons().add(icone);
            stage.setTitle("Editar informações");
            stage.setScene(scene);
            stage.setOnCloseRequest( e -> {
                Parent root2;
                try {
                     root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                     Scene scene2 = new Scene(root2);
                     Stage stage2 = new Stage();
                     stage.setFullScreen(true);
                     stage2.getIcons().add(icone);
                     stage2.setTitle("Meus clientes");
                     stage2.setOnCloseRequest( f -> {
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
        Stage stage = (Stage) tableClientes.getScene().getWindow();
        stage.close();
    }
        
    @FXML
    void botaoVoltar(ActionEvent event) {
       Parent root;
       try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/controlegeral/FXMLDocument.fxml"));
           root = loader.load();
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           stage.setResizable(false);
           Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
           stage.getIcons().add(icone);
           stage.setTitle("Oficinas de vendas");
           stage.setScene(scene);
           stage.show();
       } catch (IOException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
       Stage stage2 = (Stage) tableClientes.getScene().getWindow();
       stage2.close();
    }

    @FXML
    void botaoVoltar2(MouseEvent event) {
        Parent root;
       try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/controlegeral/FXMLDocument.fxml"));
           root = loader.load();
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           stage.setResizable(false);
           Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
           stage.getIcons().add(icone);
           stage.setTitle("Oficinas de vendas");
           stage.setScene(scene);
           stage.show();
       } catch (IOException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
       Stage stage = (Stage) tableClientes.getScene().getWindow();
       stage.close();
    }


    private List<Cliente> arrayClientes = new ArrayList();
    private ObservableList<Cliente> observableListClientes;
    private static Cliente clienteClicado;

    public void carregarClientes() {
        
        tableColumnCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tableColumnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        
        CarregarArquivo arquivo = new CarregarArquivo();
        arrayClientes = arquivo.getClientes();
        
        tableClientes.getItems().clear();
        
        observableListClientes = FXCollections.observableArrayList(arrayClientes);
        tableClientes.setItems(observableListClientes);
        
    }

    public void pesquisar() {
        CarregarArquivo arquivo = new CarregarArquivo();
        observableListClientes = FXCollections.observableArrayList(arquivo.procurarClientes(txtPesquisa.getText().toString()));
        tableClientes.setItems(observableListClientes);
    }      
    
    public Cliente getClienteClicado(){
        return this.clienteClicado;
    } 
    
    public void setClienteClicado(Cliente cliente){
        this.clienteClicado = cliente;
    } 
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarClientes();
        tableClientes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);   
        tableClientes.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    if(event.getClickCount() == 2){
                        CarregarArquivo arquivo = new CarregarArquivo();
                        Cliente cliente = arquivo.procurarClientes(tableClientes.getSelectionModel().getSelectedItem().getNome()).get(0);
                        setClienteClicado(cliente);
                        Path currentRelativePath = Paths.get("");
                        String s = currentRelativePath.toAbsolutePath().toString();
                        String caminhoArquivo = s+"\\comprasEfetuadas\\"+cliente.getNome()+".txt";
                        File file = new File(caminhoArquivo);

                        if(file.exists()){
                            Parent root;
                            try {
                                root = FXMLLoader.load(getClass().getResource("FXMLDocument3.fxml"));
                                Scene scene = new Scene(root);
                                Stage stage = new Stage();
                                stage.setScene(scene);
                                Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
                                stage.getIcons().add(icone);
                                stage.setTitle("Painel do cliente");
                                stage.setResizable(false);
                                stage.show();
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        else {
                            Parent root;
                            try {
                                root = FXMLLoader.load(getClass().getResource("FXMLDocument3_1.fxml"));
                                Scene scene = new Scene(root);
                                Stage stage = new Stage();
                                stage.setScene(scene);
                                Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
                                stage.getIcons().add(icone);
                                stage.setTitle("Painel do cliente");
                                stage.setResizable(false);
                                stage.show();
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                    }
                }
            }
        });
        
        txtPesquisa.setOnKeyReleased(
        e -> {
            pesquisar();	
        });
        
        txtPesquisa.setOnKeyTyped(e -> {
            pesquisar();	
        });
        
        txtPesquisa.setOnKeyPressed(e -> {
            pesquisar();	
        });

    }
}
