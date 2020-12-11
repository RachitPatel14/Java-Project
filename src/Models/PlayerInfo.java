package Models;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * This method will make an object having player info
 */
public class PlayerInfo {

    @SerializedName("id")
    private String playerID;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("height_feet")
    private String heightFeet;

    @SerializedName("height_inches")
    private String heightInches;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("position")
    private String position;

    @SerializedName("team")
    private JsonObject teamInfo;


    @SerializedName("weight_pounds")
    private String weight;

    /**
     * This method works as a constructor for  playerInfo.
     * @param playerID
     * @param firstName
     * @param heightFeet
     * @param heightInches
     * @param lastName
     * @param position
     * @param teamInfo
     * @param weight
     */
    public PlayerInfo(String playerID, String firstName, String heightFeet, String heightInches, String lastName, String position, JsonObject teamInfo, String weight) {
        setPlayerID(playerID);
        setFirstName(firstName);
        setHeightFeet(heightFeet);
        setHeightInches(heightInches);
        setLastName(lastName);
        setPosition(position);
        setWeight(weight);
        setTeamInfo(teamInfo);
    }


    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        if(playerID != null)
        this.playerID = playerID;
        else
            throw new IllegalArgumentException("playerId cannot be null");
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName)
    {
        if(firstName.length()>2)
        this.firstName = firstName.toLowerCase();
        else
            throw new IllegalArgumentException("First name must be greater than 2 characters");
    }

    public String getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(String heightFeet) {
        if(heightFeet != null)
        this.heightFeet = heightFeet;
        else
            throw new IllegalArgumentException("Height in feet cannot be null");
    }

    public String getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(String heightInches) {
        if(heightInches != null)
        this.heightInches = heightInches;
        else
            throw new IllegalArgumentException("height in inches cannot be null");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length()>2)
        this.lastName = lastName.toLowerCase();
        else
            throw new IllegalArgumentException("last name must be greater than 2 characters");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if(position != null)
        this.position = position;
        else
            throw new IllegalArgumentException("position cannot be null ");
    }

    public JsonObject getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(JsonObject teamInfo) {
        if(teamInfo.isJsonObject())
        this.teamInfo = teamInfo;
        else
            throw new IllegalArgumentException("Only Json object is allowed as an value");
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        if(weight != null)
        this.weight = weight;
        else
            throw new IllegalArgumentException("weight cannot be null");
    }

    public String toString()
    {
        return String.format("first Name: %S and last Name: %s ",firstName, lastName);
    }
}
