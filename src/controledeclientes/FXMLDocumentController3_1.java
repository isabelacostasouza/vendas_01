package controledeclientes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController3_1 implements Initializable {
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    void concluir(ActionEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

}
