package Utilities;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NBAApiUtility {

    public static void getPlayerInfoFromSearch(String searchText) {
        String searchURL = "https://free-nba.p.rapidapi.com/players?page=0&per_page=25&search="+searchText;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(searchURL))
                .header("x-rapidapi-key", "7722aa3e84msh8b01d26eb264e1ep130071jsn190ee8b4f44c")
                .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("src/Utilities/players.json")));
        }catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
