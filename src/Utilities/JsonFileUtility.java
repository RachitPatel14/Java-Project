package Utilities;

import Models.ApiResponseModel;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;

public class JsonFileUtility {

    public static ApiResponseModel getApiInfoFromJson(File jsonFile)
    {
        ApiResponseModel apiResponse = null;

        //try with resources - this will autoclose objects that have
        //a close method
        try (
                FileReader fileReader = new FileReader(jsonFile);
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            Gson gson = new Gson();
            apiResponse = gson.fromJson(jsonReader, ApiResponseModel.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return apiResponse;
    }
}
