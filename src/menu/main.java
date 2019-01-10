package menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/controlegeral/FXMLDocument.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
       
        Image icone = new Image(getClass().getResourceAsStream("/imagens/icon-clientes.png"));
        stage.getIcons().add(icone);
        stage.setTitle("Oficinas de vendas");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
