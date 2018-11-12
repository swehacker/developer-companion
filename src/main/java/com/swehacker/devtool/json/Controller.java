package com.swehacker.devtool.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Base64;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller {

  @FXML
  TextArea uglyJson;

  @FXML
  TextArea prettyJson;

  public void onJsonPasted(KeyEvent keyEvent) {
    if (!"v".equals(keyEvent.getText())) {
      return;
    }

    JsonParser parser = new JsonParser();
    JsonObject json = parser.parse(uglyJson.getText()).getAsJsonObject();

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    prettyJson.setText(gson.toJson(json));
  }
}
