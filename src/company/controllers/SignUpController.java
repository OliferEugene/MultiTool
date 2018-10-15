package company.controllers;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko 28.09.18
Class SignUp was created in 22:45 28.09.18
© 2018 Olifer. All rights reserved. All trademarks are the property of their respective.
*/


import java.io.IOException;
import java.net.URL;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ResourceBundle;
import java.sql.*;

import company.controllers.samples.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController extends ErrorMaker {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstnameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private CheckBox maleCheckBox;

    @FXML
    private CheckBox femaleCheckBox;

    @FXML
    private TextField countryField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField languageField;

    @FXML
    private Button CancelButton;

    @FXML
    void initialize() {
        femaleCheckBox.setOnAction(event -> {
            if(maleCheckBox.isSelected()){
                if(femaleCheckBox.isSelected()){
                    maleCheckBox.fire();
                }
            }
        });
        maleCheckBox.setOnAction(event -> {
            if (femaleCheckBox.isSelected()){
                if(maleCheckBox.isSelected()){
                    femaleCheckBox.fire();
                }
            }
        });

        CancelButton.setOnAction(event -> {
            CancelButton.getScene().getWindow().hide(); // берем поточну сцену, поточне вікно і закриваємо його
            FXMLLoader loader = new FXMLLoader(); // додаємо об'єкт класу FXMLLoader для загрузки іншого вікна

            loader.setLocation(getClass().getResource("samples/loginWindow.fxml"));
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
        });

        signUpButton.setOnAction(event -> {

            signUpNewUser();

        });

    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = firstnameField.getText();
        String lastName = lastnameField.getText();
        String userName = usernameField.getText();
        String password = passwordField.getText();
        String country = countryField.getText();
        String language = languageField.getText();
        String email = emailField.getText();
        String gender = "";

        if(maleCheckBox.isSelected()) {
            gender = "Male";
        } else if(femaleCheckBox.isSelected()) {
            gender = "Female";
        } else {
            gender = "Undefined";
        }

        User user = new User(firstName, lastName, userName, password, country, language, email, gender);

        if (passwordField.getText().equals(confirmPasswordField.getText())) {

            dbHandler.signUpUser(user);

            signUpButton.getScene().getWindow().hide(); // берем поточну сцену, поточне вікно і закриваємо його
            FXMLLoader loader = new FXMLLoader(); // додаємо об'єкт класу FXMLLoader для загрузки іншого вікна

            loader.setLocation(getClass().getResource("samples/loginWindow.fxml"));
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
        }  else {
            ErrorMaker error = new ErrorMaker();
            System.out.println("Passwords do not match.");
            error.SignUpError();

        }

    }
}

