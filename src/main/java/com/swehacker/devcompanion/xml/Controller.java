package com.swehacker.devcompanion.xml;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.dom4j.DocumentException;

import java.io.IOException;

public class Controller {

    @FXML
    TextArea uglyXml;

    @FXML
    TextArea prettyXml;

    public void onXmlPasted() {
        try {
            prettyXml.setText(XmlUtil.prettyPrint(uglyXml.getText(), 4, true));
        } catch (DocumentException | IOException e) {
            prettyXml.setText(e.getMessage());
        }
    }
}
