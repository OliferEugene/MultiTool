package company.controllers;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko 20.10.18
Class ChangesSavedController was created in 23:26 20.10.18
© 2018 Olifer. All rights reserved. All trademarks are the property of their respective.
*/

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ChangesSavedController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button okButton;

    @FXML
    void initialize() {
        okButton.setOnAction(event -> CloseWindow() );
    }

    private void CloseWindow() {
        okButton.getScene().getWindow().hide();
    }
}


