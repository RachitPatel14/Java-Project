package Controllers;

import Models.ApiResponseModel;
import Models.PlayerInfo;
import Utilities.JsonFileUtility;
import Utilities.NBAApiUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerSearchController implements Initializable {

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<PlayerInfo> listView;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label totalPlayersLabel;

    @FXML
    private Label numberShowingLabel;

    @FXML
    private Button fullPlayerStatsButton;

    private PlayerInfo playerInfos;
    private ApiResponseModel response;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numberShowingLabel.setText("");
        totalPlayersLabel.setText("");

        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, playerInfo, t1) -> {
            firstNameLabel.setText("First Name :"+t1.getFirstName());
            lastNameLabel.setText("Last Name :"+t1.getLastName());
            playerInfos = listView.getSelectionModel().getSelectedItem();
        });

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
        totalPlayersLabel.setText("Total Players: "+response.getTotalResults().get("total_count"));
        listView.getItems().addAll(response.getPlayers());
        numberShowingLabel.setText("Total Number of rows in Table: "+listView.getItems().size());
    }
    @FXML
    public void Scene(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Views/fullPlayerView.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        FullSelectedPlayerInfoController c = loader.getController();
        c.unitData(playerInfos);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void fillTheScene(String searchText)
    {
        searchText = searchText.replace(" ","%20");

       //call the API and save the JSON file to the hard drive
        NBAApiUtility.getPlayerInfoFromSearch(searchText);

        //read the json file and create an APIResponseModel
        File jsonFile = new File("src/Utilities/players.json");
        response = JsonFileUtility.getApiInfoFromJson(jsonFile);

        updateScene();
    }

}

