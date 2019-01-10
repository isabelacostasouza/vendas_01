package controledevendas;

import controledeestoque.CarregarArquivo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import controledeestoque.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label lableNome;

    @FXML
    private Label lableQuantidade;

    @FXML
    private Label lableValor;

    @FXML
    private Label lableSubtotal;

    @FXML
    private TableView<Produto> table;

    @FXML
    private TableColumn<Produto, String> tableProduto;

    @FXML
    private TableColumn<Produto, String> tableValor;

    @FXML
    private TableColumn<Produto, String> tableQuantidade;

    @FXML
    private TableColumn<Produto, String> tableTotal;

    @FXML
    private Label lableTotalCompra;

    @FXML
    private Label lableNome2;

    @FXML
    private Label lableQuantidadeDisponivel;

    @FXML
    private Label lableValor2;

    @FXML
    private TextField txtPesquisa;

    @FXML
    void adicionarProduto(ActionEvent event) {
        Parent root;
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
             Scene scene = new Scene(root);
             Stage stage = new Stage();
             stage.setResizable(false);
             Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
             stage.getIcons().add(icone);
             stage.setTitle("Meu carrinho");
             stage.setOnCloseRequest( e -> {
                Parent root2;
                try {
                     root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                     Scene scene2 = new Scene(root2);
                     Stage stage2 = new Stage();
                     stage2.setResizable(false);
                     stage2.getIcons().add(icone);
                     stage2.setTitle("Meu carrinho");
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
             stage.setScene(scene);
             stage.show();
        } catch (IOException ex) {
             Logger.getLogger(controledeestoque.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage2 = (Stage) table.getScene().getWindow();
        stage2.close();
        produtosVendidos++;
    }
    @FXML
    void adicionarProduto2(MouseEvent event) {
        Parent root;
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
             Scene scene = new Scene(root);
             Stage stage = new Stage();
             stage.setResizable(false);
             Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
             stage.getIcons().add(icone);
             stage.setTitle("Meu carrinho");
             stage.setOnCloseRequest( e -> {
                Parent root2;
                try {
                     root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                     Scene scene2 = new Scene(root2);
                     Stage stage2 = new Stage();
                     stage2.setResizable(false);
                     stage2.getIcons().add(icone);
                     stage2.setTitle("Meu carrinho");
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
             stage.setScene(scene);
             stage.show();
        } catch (IOException ex) {
             Logger.getLogger(controledeestoque.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage2 = (Stage) table.getScene().getWindow();
        stage2.close();
        produtosVendidos++;
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
           Stage stage2 = (Stage) table.getScene().getWindow();
           stage2.close();
       } catch (IOException ex) {
           Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
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
           Stage stage2 = (Stage) table.getScene().getWindow();
           stage2.close();
       } catch (IOException ex) {
           Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @FXML
    void cancelarVenda(ActionEvent event) {
        CarregarVenda arquivo = new CarregarVenda();
        arquivo.limparArquivo();
        JOptionPane.showMessageDialog(null, "Venda cancelada!");
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
           Stage stage2 = (Stage) table.getScene().getWindow();
           stage2.close();
       } catch (IOException ex) {
           Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
        Stage stage2 = (Stage) table.getScene().getWindow();
        stage2.close();
    }

    @FXML
    void cancelarVenda2(MouseEvent event) {
        CarregarVenda arquivo = new CarregarVenda();
        arquivo.limparArquivo();
        JOptionPane.showMessageDialog(null, "Venda cancelada!");
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
           Stage stage2 = (Stage) table.getScene().getWindow();
           stage2.close();
       } catch (IOException ex) {
           Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
        Stage stage2 = (Stage) table.getScene().getWindow();
        stage2.close();
    }

    @FXML
    void finalizarVenda(ActionEvent event) {
        ObservableList<Produto> items = table.getItems();
        if(items.isEmpty()){}
        else {
            CarregarArquivo arquivoEstoque = new CarregarArquivo();
            CarregarVenda arquivoVenda = new CarregarVenda();
            if(arquivoVenda.getEstoque() != null) {
                arquivoEstoque.editarQuantidadeProduto(arquivoVenda.getEstoque());
                arquivoVenda.limparArquivo();
            }

            arquivoVenda.adicionarCompraCliente(arrayProdutos);
        }
        JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso!");
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
           Stage stage2 = (Stage) table.getScene().getWindow();
           stage2.close();
       } catch (IOException ex) {
           Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
        Stage stage2 = (Stage) table.getScene().getWindow();
        stage2.close();
        
    }
    
    @FXML
    void finalizarVenda2(MouseEvent event) {
        CarregarArquivo arquivoEstoque = new CarregarArquivo();
        CarregarVenda arquivoVenda = new CarregarVenda();
        if(arquivoVenda.getEstoque() != null) {
            arquivoEstoque.editarQuantidadeProduto(arquivoVenda.getEstoque());
            arquivoVenda.limparArquivo();
        }
        
        arquivoVenda.adicionarCompraCliente(arrayProdutos);
        
        JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso!");
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
           Stage stage2 = (Stage) table.getScene().getWindow();
           stage2.close();
       } catch (IOException ex) {
           Logger.getLogger(controledeclientes.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
        Stage stage2 = (Stage) table.getScene().getWindow();
        stage2.close();
    }
    
    private static ArrayList<Produto> arrayProdutos = new ArrayList();
    private ObservableList<Produto> observableListClientes;
    
     public void carregarProdutos() {
        if(arrayProdutos != null) {
            double valorTotal = 0.00;
            for(int i = 0; i < arrayProdutos.size(); i++) {
                arrayProdutos.get(i).setValorLiquido((arrayProdutos.get(i).getQuantidadeDesejada()*arrayProdutos.get(i).getValor()));
                valorTotal = valorTotal + arrayProdutos.get(i).getValorLiquido();
            }

            lableTotalCompra.setText(String.valueOf(valorTotal));
            
            tableProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
            tableValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
            tableQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidadeDesejada"));
            tableTotal.setCellValueFactory(new PropertyValueFactory<>("valorLiquido"));

            table.getItems().clear();
            observableListClientes = FXCollections.observableArrayList(arrayProdutos);
            table.setItems(observableListClientes);
        }    
    }
     
     public void pesquisar() {
        CarregarVenda arquivo = new CarregarVenda();
        if(arquivo.getEstoque() != null) {
            observableListClientes = FXCollections.observableArrayList(arquivo.procurarProduto(txtPesquisa.getText().toString()));
            table.setItems(observableListClientes);
        }
    }   
     
    private static int produtosVendidos = 0;

    public void addProdutoVendido() {
        produtosVendidos++;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CarregarVenda arquivo = new CarregarVenda();
        arrayProdutos = arquivo.getEstoque(); 
        carregarProdutos();
        if(arquivo.getEstoque() != null) {
            lableNome.setText(arrayProdutos.get(0).getNome());
            lableQuantidade.setText(String.valueOf(arrayProdutos.get(0).getQuantidadeDesejada()));
            lableValor.setText(String.valueOf(arrayProdutos.get(0).getValor()));
            lableSubtotal.setText(String.valueOf(arrayProdutos.get(0).getValorLiquido()));
        }
        
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    Produto produto = arquivo.procurarProduto(table.getSelectionModel().getSelectedItem().getNome()).get(0);
                    lableNome.setText(produto.getNome());
                    lableQuantidade.setText(String.valueOf(produto.getQuantidadeDesejada()));
                    lableValor.setText(String.valueOf(produto.getValor()));
                    lableSubtotal.setText(String.valueOf(produto.getValorLiquido()));
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
