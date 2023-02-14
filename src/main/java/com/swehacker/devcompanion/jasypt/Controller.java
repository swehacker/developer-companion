package com.swehacker.devcompanion.jasypt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;

public class Controller {

  @FXML
  TextField password;
  @FXML
  TextArea text;
  @FXML
  TextArea result;

  public void encrypt(ActionEvent event) {
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setPassword(password.getText());
    encryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256");
    encryptor.setIvGenerator(new RandomIvGenerator());

    result.setText(encryptor.encrypt(text.getText()));
  }

  public void decrypt(ActionEvent event) {
    try {
      StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
      encryptor.setPassword(password.getText());
      encryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256");
      encryptor.setIvGenerator(new RandomIvGenerator());

      result.setText(encryptor.decrypt(text.getText()));
    } catch (Throwable t) {
      result.setText("Error: Encryption not possible due to wrong password!");
    }
  }
}
