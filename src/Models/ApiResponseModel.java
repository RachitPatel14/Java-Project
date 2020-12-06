package Models;

import com.google.gson.annotations.SerializedName;

public class ApiResponseModel {

    @SerializedName("data")
    private PlayerInfo[] players;

    @SerializedName("total_count")
    private String totalResults;

    public PlayerInfo[] getPlayers() {
        return players;
    }

    public void setPlayers(PlayerInfo[] players) {
        this.players = players;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }
}
