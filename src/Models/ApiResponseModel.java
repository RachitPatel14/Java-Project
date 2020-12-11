package Models;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * This method will get data from api and store it in private vaaariables
 */

public class ApiResponseModel {

    @SerializedName("data")
    private PlayerInfo[] players;

    @SerializedName("meta")
    private JsonObject totalResults;

    public PlayerInfo[] getPlayers() {
        return players;
    }

    public void setPlayers(PlayerInfo[] players) {
        this.players = players;
    }

    public JsonObject getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(JsonObject totalResults) {
        this.totalResults = totalResults;
    }
}
