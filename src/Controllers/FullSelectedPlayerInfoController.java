package Controllers;

import Models.PlayerInfo;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

     private JsonObject teamInfo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void unitData(PlayerInfo selectedPlayerInfo) {

         playerInfo = selectedPlayerInfo;
         teamInfo = selectedPlayerInfo.getTeamInfo();

        firstNameLabel.setText("First Name:"+playerInfo.getFirstName());
        lastNameLabel.setText("Last Name:"+playerInfo.getLastName());
        positionLabel.setText("Position:"+playerInfo.getPosition());
        heightLabel.setText("height:"+playerInfo.getHeightInches()+" inch");
        weightLabel.setText("Weight:"+playerInfo.getWeight()+" lb");
        teamNameLabel.setText("Team Name:"+teamInfo.get("full_name"));
        cityLabel.setText("City:"+teamInfo.get("city"));
        conferenceLabel.setText("Conference:"+teamInfo.get("conference"));
        divisionLabel.setText("Division:"+teamInfo.get("division"));
        abbreviationLabel.setText("Abbreviation:"+teamInfo.get("abbreviation"));

    }
}

