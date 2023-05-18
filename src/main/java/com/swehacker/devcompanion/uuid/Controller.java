package com.swehacker.devcompanion.uuid;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.UUID;

public class Controller {

    @FXML
    TextField uuidToken;


    @SuppressWarnings("squid:S1172")
    public void generateToken(ActionEvent actionEvent) {
        uuidToken.setText(UUID.randomUUID().toString());
    }
}
