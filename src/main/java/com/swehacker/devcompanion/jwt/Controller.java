package com.swehacker.devcompanion.jwt;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Base64;

public class Controller {

    @FXML
    TextArea jwtToken;

    @FXML
    TextField algToken;

    @FXML
    TextArea decodedToken;

    public void onTokenPasted() {
        String[] splitToken = jwtToken.getText().split("\\.");

        try {
            if (splitToken.length == 1) {
                decodedToken.setText(new String(Base64.getDecoder().decode(splitToken[0].getBytes())));
            } else if (splitToken.length == 3) {
                algToken.setText(new String(Base64.getDecoder().decode(splitToken[0].getBytes())));
                decodedToken.setText(new String(Base64.getDecoder().decode(splitToken[1].getBytes())));
            } else {
                decodedToken.setText("Invalid token!");
            }
        } catch (Exception e) {
            decodedToken.setText(e.getMessage());
        }
    }
}
