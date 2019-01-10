package controledeclientes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLDocumentController5 implements Initializable {

    @FXML
    Button btnConcluido;
    
    @FXML
    void concluir(ActionEvent event) {
        Stage stage = (Stage) btnConcluido.getScene().getWindow(); 
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

}
