package com.swehacker.devcompanion.xml;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class Controller {

  @FXML
  TextArea uglyXml;

  @FXML
  TextArea prettyXml;

  public void onXmlPasted(KeyEvent keyEvent) {
    if (!"v".equals(keyEvent.getText())) {
      return;
    }

    prettyXml.setText(XmlUtil.prettyPrint(uglyXml.getText(),4,true));
  }
}
