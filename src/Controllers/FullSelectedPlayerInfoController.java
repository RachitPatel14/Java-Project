package Controllers;

import Models.PlayerInfo;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FullSelectedPlayerInfoController implements Initializable {

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label positionLabel;

    @FXML
    private Label heightLabel;

    @FXML
    private Label weightLabel;

    @FXML
    private Label teamNameLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label conferenceLabel;

    @FXML
    private Label divisionLabel;

    @FXML
    private Label abbreviationLabel;

    private PlayerInfo playerInfo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    /**
     * This method will fill all the label with a player return from another scene.
     * @param selectedPlayerInfo
     */
    public void unitData(PlayerInfo selectedPlayerInfo) {
        playerInfo = selectedPlayerInfo;
        JsonObject teamInfo = selectedPlayerInfo.getTeamInfo();

        firstNameLabel.setText("First Name:"+ selectedPlayerInfo.getFirstName());
        lastNameLabel.setText("Last Name:"+ selectedPlayerInfo.getLastName());

        if(selectedPlayerInfo.getPosition() != null)
        positionLabel.setText("Position:"+ selectedPlayerInfo.getPosition());

        if(selectedPlayerInfo.getHeightInches() != null)
        heightLabel.setText("height:"+ selectedPlayerInfo.getHeightInches()+" inch");

        if(selectedPlayerInfo.getWeight() != null)
        weightLabel.setText("Weight:"+ selectedPlayerInfo.getWeight()+" lb");

        teamNameLabel.setText("Team Name:"+ teamInfo.get("full_name"));
        cityLabel.setText("City:"+ teamInfo.get("city"));
        conferenceLabel.setText("Conference:"+ teamInfo.get("conference"));
        divisionLabel.setText("Division:"+ teamInfo.get("division"));
        abbreviationLabel.setText("Abbreviation:"+ teamInfo.get("abbreviation"));

    }

    /**
     * This method will change the scene and also return a string as a serach text to fill the list-view with similar players.
     * @param event
     * @throws IOException
     */
    public void changeSceneToPlayerSearch(javafx.event.ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Views/playerSearchView.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        PlayerSearchController c = loader.getController();
        c.fillTheScene(playerInfo.getFirstName());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

