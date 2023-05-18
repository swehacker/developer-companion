package com.swehacker.devcompanion.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    TextArea uglyJson;

    @FXML
    TextArea prettyJson;

    public void onJsonPasted() {
        try {
            JsonObject json = JsonParser.parseString(uglyJson.getText()).getAsJsonObject();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            prettyJson.setText(gson.toJson(json));
        } catch (JsonSyntaxException e) {
            prettyJson.setText(e.getMessage());
        }
    }
}
