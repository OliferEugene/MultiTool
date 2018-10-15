package company.controllers;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko
Class MyProfileController was created in 13:54 15.10.18
© 2018 Olifer. All rights reserved. All trademarks are the property of their respective.
*/

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MyProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EditProfileButton;

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
    private Button CancelButton;


    @FXML
    void initialize() {
        CancelButton.setOnAction(event -> BackToApp());

    }
    private void BackToApp() {
        CancelButton.getScene().getWindow().hide(); // берем поточну сцену, поточне вікно і закриваємо його
        FXMLLoader loader = new FXMLLoader(); // додаємо об'єкт класу FXMLLoader для загрузки іншого вікна

        loader.setLocation(getClass().getResource("samples/App.fxml"));
        // вказуємо шлях до файлу вікна, яке збираємось відкрити

        try {
            loader.load(); // запускаємо вікно
        } catch (IOException e) {
            e.printStackTrace();
        } finally {


            Parent root = loader.getRoot(); // отримуємо шлях до вікна (хуй знає нашо це робиться)
            Stage stage = new Stage();
            stage.setScene(new Scene(root)); // вказуємо шлях до файлу який потрібно підключити
            stage.show(); // показуємо вікно і чекаємо
        }
    }
}
