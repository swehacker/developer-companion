package com.swehacker.devtool.uuid;

import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

  @FXML
  TextField uuidToken;


  public void generateToken(ActionEvent actionEvent) {
    uuidToken.setText(UUID.randomUUID().toString());
  }
}
