package company.controllers;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko 15.10.18
Class MyProfileController was created in 13:54 15.10.18
© 2018 Olifer. All rights reserved. All trademarks are the property of their respective.
*/

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MyProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NameField;

    @FXML
    private TextField LastNameField;

    @FXML
    private TextField GenderField;

    @FXML
    private TextField CountryField;

    @FXML
    private TextField LanguageField;

    @FXML
    private TextField UsernameField;

    @FXML
    private TextField eMailField;

    @FXML
    private TextField UserIDField;

    @FXML
    void initialize() {

    }
}
