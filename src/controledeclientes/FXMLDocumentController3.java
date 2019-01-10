package controledeclientes;

import controledeestoque.Produto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class FXMLDocumentController3 implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private Pane pane;

    @FXML
    private TableView<Produto> tableProdutos;

    @FXML
    private TableColumn<Produto, String> tableColumnProduto;

    @FXML
    private TableColumn<Produto, String> tableColumnQnt;

    @FXML
    private TableColumn<Produto, String> tableColumnData;

    @FXML
    void concluir(ActionEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        FXMLDocumentController c = new FXMLDocumentController();
        Cliente cliente = c.getClienteClicado();

        ArrayList<Produto> produtos = new ArrayList();
        FileReader f;
        try {
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            String caminhoArquivo = s+"\\comprasEfetuadas\\"+cliente.getNome()+".txt";
            f = new FileReader(caminhoArquivo);
            BufferedReader readerf = new BufferedReader(f);
            String linha;
            try {
                linha = readerf.readLine();
                ArrayList<String> linhas = new ArrayList();
                while (linha != null) {
                    linhas.add(linha);
                    linha = readerf.readLine();
                }    
                int contador = 0;
                String data = linhas.get(0);
                boolean novoProduto = true, primeiro = true, sequencia = false;
                int sequenciaInt = 0;
                for(int i = 0; i < linhas.size(); i++) {
                    Produto e = new Produto();
                    if(contador >= 5)
                        contador = 0;
                    if(linhas.get(i).equals("") && i+1 < linhas.size()) {
                        data = linhas.get(i+1);
                        contador = -2;
                        novoProduto = true;
                        sequenciaInt = 0;
                        sequencia = false;
                    }
                    else if(novoProduto) {
                        if(primeiro) {
                            e.setNome(linhas.get(i+1));
                            e.setQuantidadeDesejada(Integer.parseInt(linhas.get(i+2)));
                            e.setDataCompra(data);
                            produtos.add(e);
                            novoProduto = false;
                            primeiro = false;
                        }
                        else
                            novoProduto = false;
                    }
                    else if(contador == 0) {
                        if(sequencia) {
                            e.setNome(linhas.get(i-1+sequenciaInt));
                            e.setQuantidadeDesejada(Integer.parseInt(linhas.get(i+sequenciaInt)));
                            e.setDataCompra(data);
                            produtos.add(e);
                            novoProduto = false;
                            sequencia = true;
                            sequenciaInt--;
                        }
                        else {
                            e.setNome(linhas.get(i));
                            e.setQuantidadeDesejada(Integer.parseInt(linhas.get(i+1)));
                            e.setDataCompra(data);
                            produtos.add(e);
                            novoProduto = false;
                            sequencia = true;
                            sequenciaInt = 0;
                        }
                    }
                    contador++;
                }
                readerf.close();
            } catch (IOException ex) {
                Logger.getLogger(controledeestoque.CarregarArquivo.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(controledeestoque.CarregarArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        tableColumnProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnQnt.setCellValueFactory(new PropertyValueFactory<>("quantidadeDesejada"));
        tableColumnData.setCellValueFactory(new PropertyValueFactory<>("dataCompra"));
    
        tableProdutos.getItems().clear();
        ObservableList<Produto> observableListClientes;
        observableListClientes = FXCollections.observableArrayList(produtos);
        tableProdutos.setItems(observableListClientes);
        
    }    

}
