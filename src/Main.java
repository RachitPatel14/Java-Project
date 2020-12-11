import Models.ApiResponseModel;
import Utilities.JsonFileUtility;
import Utilities.NBAApiUtility;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
        public static void main(String[] args) { launch(args); }
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("Views/playerSearchView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("NBA Player Search");
            Image icon = new Image(getClass().getResourceAsStream("Images/logo.png"));
            stage.getIcons().add(icon);
            stage.show();
        }
}
