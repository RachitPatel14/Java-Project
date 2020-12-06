package Controllers;

import Models.ApiResponseModel;
import Models.PlayerInfo;
import Utilities.JsonFileUtility;
import Utilities.NBAApiUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerSearchController implements Initializable {

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<PlayerInfo> listView;

    @FXML
    private ImageView imageView;

    @FXML
    private Label totalMoviesLabel;

    @FXML
    private Label numberShowingLabel;

    private ApiResponseModel response;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numberShowingLabel.setText("");
        totalMoviesLabel.setText("");
    }

    @FXML
    private void searchButton()
    {
        String searchText = searchTextField.getText();
        searchText = searchText.replace(" ", "%20");

        //call the API and save the JSON file to the hard drive
        NBAApiUtility.getPlayerInfoFromSearch(searchText);

        //read the json file and create an APIResponseModel
        File jsonFile = new File("src/Utilities/players.json");
        response = JsonFileUtility.getApiInfoFromJson(jsonFile);

        updateScene();
    }

    private void updateScene()
    {
        listView.getItems().clear();
        totalMoviesLabel.setText("Total Players: "+response.getTotalResults());
        listView.getItems().addAll(response.getPlayers());
        numberShowingLabel.setText("Number showing: "+listView.getItems().size());
    }
}

