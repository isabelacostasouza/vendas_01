package controledevendas;

import controledeclientes.Cliente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLDocumentController5 implements Initializable {
 
    @FXML
    private TextField txtPesquisa;

    @FXML
    private TableView<Cliente> tableClientes;

    @FXML
    private TableColumn<Cliente, String> tableColumnCliente;

    @FXML
    private TableColumn<Cliente, String> tableColumnTelefone;

    @FXML
    private TableColumn<Cliente, String> tableColumnEndereco;

    @FXML
    void botaoVoltar(ActionEvent event) {
        voltar();
    }

    @FXML
    void botaoVoltar2(MouseEvent event) {
        voltar();
    }
    
    public void voltar() {
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
           Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage2 = (Stage) tableClientes.getScene().getWindow();
        stage2.close();
    }
    
    private List<Cliente> arrayClientes = new ArrayList();
    private ObservableList<Cliente> observableListClientes;
    private static Cliente clienteClicado;
    
    public void pesquisar() {
        controledeclientes.CarregarArquivo arquivo = new controledeclientes.CarregarArquivo();
        observableListClientes = FXCollections.observableArrayList(arquivo.procurarClientes(txtPesquisa.getText().toString()));
        tableClientes.setItems(observableListClientes);
    } 
    
    public void carregarClientes() {
        tableColumnCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tableColumnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        
        controledeclientes.CarregarArquivo arquivo = new controledeclientes.CarregarArquivo();
        arrayClientes = arquivo.getClientes();
        
        tableClientes.getItems().clear();
        
        observableListClientes = FXCollections.observableArrayList(arrayClientes);
        tableClientes.setItems(observableListClientes);
    }
    
    public Cliente getClienteClicado(){
        return this.clienteClicado;
    } 
    
    public void setClienteClicado(Cliente cliente){
        this.clienteClicado = cliente;
    } 
    
    public void escreverArquivo(String caminhoArquivo, String linha) {
        FileWriter fw;
        try {
            fw = new FileWriter(caminhoArquivo, true);
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.write(linha);
            conexao.newLine();
            conexao.close();
        } catch (IOException ex) {}
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
                        controledeclientes.CarregarArquivo arquivo = new controledeclientes.CarregarArquivo();
                        Cliente cliente = arquivo.procurarClientes(tableClientes.getSelectionModel().getSelectedItem().getNome()).get(0);
                        setClienteClicado(cliente);
                        
                        Path currentRelativePath = Paths.get("");
                        String s = currentRelativePath.toAbsolutePath().toString();
                        String caminhoArquivo = s+"\\comprasEfetuadas\\clienteSelecionado.txt";
                        System.out.println(caminhoArquivo);
                        File file = new File(caminhoArquivo);
                        file.delete();
                        File f = new File(caminhoArquivo);
                        try {
                            f.createNewFile();
                        } catch (IOException ex) {}
                        
                        escreverArquivo(caminhoArquivo, getClienteClicado().getNome());
                        escreverArquivo(caminhoArquivo, getClienteClicado().getTelefone());

                        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
                            stage.getIcons().add(icone);
                            stage.setTitle("Vendas");
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
                                     Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                           });
                           stage.show();
                           Stage stage3 = (Stage) txtPesquisa.getScene().getWindow();
                           stage3.close();
                        } catch (IOException ex) {
                            Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
    }

}
