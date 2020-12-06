package Models;

import com.google.gson.annotations.SerializedName;

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


    @SerializedName("weight_pounds")
    private String weight;

    public PlayerInfo(String playerID, String firstName, String heightFeet, String heightInches, String lastName, String position, String weight) {
        setPlayerID(playerID);
        setFirstName(firstName);
        setHeightFeet(heightFeet);
        setHeightInches(heightInches);
        setLastName(lastName);
        setPosition(position);
        setWeight(weight);
    }

    public void setValidation()
    {
        setPlayerID(playerID);
        setFirstName(firstName);
        setHeightFeet(heightFeet);
        setHeightInches(heightInches);
        setLastName(lastName);
        setPosition(position);
        setWeight(weight);
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(String heightFeet) {
        this.heightFeet = heightFeet;
    }

    public String getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(String heightInches) {
        this.heightInches = heightInches;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String toString()
    {
        return String.format("first Name:%S and last Name:%s",firstName, lastName);
    }
}
