package company.controllers;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko 20.10.18
Class EditProfileController was created in 19:53 20.10.18
© 2018 Olifer. All rights reserved. All trademarks are the property of their respective.
*/

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


import company.controllers.samples.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SubmitButton;

    @FXML
    private TextField NameField;

    @FXML
    private TextField LastNameField;

    @FXML
    private TextField CountryField;

    @FXML
    private TextField UsernameField;

    @FXML
    private TextField eMailField;

    @FXML
    private PasswordField OldPassField;

    @FXML
    private PasswordField NewPassField;

    @FXML
    private PasswordField ConfirmPassField;

    @FXML
    private Button CancelButton;
    public static String MyCurrentUsername;

    public static String MyCurrentPass;

    @FXML
    void initialize() {

        FillTheFields();

        DatabaseHandler dbHandler1 = new DatabaseHandler();
        dbHandler1.getCurrentPass(MyCurrentUsername);

        CancelButton.setOnAction(event -> BackToProfile());

        SubmitButton.setOnAction(event -> {
            String NewName = NameField.getText();
            String NewLastName = LastNameField.getText();
            String NewUsername = UsernameField.getText();
            String NewCountry = CountryField.getText();
            String NewEmail = eMailField.getText();

            String OldPassword = OldPassField.getText();
            String NewPassword = NewPassField.getText();
            String ConfirmPass = ConfirmPassField.getText();

            System.out.println(MyCurrentPass);



            if (MyCurrentPass.equals(OldPassword) & NewPassword.equals(ConfirmPass) & !NewPassword.equals("") & !ConfirmPass.equals("")){
                DatabaseHandler dbHandler = new DatabaseHandler();
                dbHandler.EditUser(MyCurrentUsername, NewName, NewLastName, NewUsername, NewCountry,  NewEmail, NewPassword);
                System.out.println("Var1");
            } else if (MyCurrentPass.equals(OldPassword) & NewPassword.equals("")) {
                DatabaseHandler dbHandler = new DatabaseHandler();
                dbHandler.EditUser(MyCurrentUsername, NewName, NewLastName, NewUsername, NewCountry,  NewEmail, OldPassword);
                System.out.println("Var2");
            } else if (!MyCurrentPass.equals(OldPassword)) {
                ErrorMaker WrongPassword = new ErrorMaker();
                WrongPassword.EditError();
                System.out.println("Var3");
                System.out.println(OldPassword);
            } else if (MyCurrentPass.equals(OldPassword) & !NewPassword.equals(ConfirmPass)) {
                ErrorMaker PasswordsDoNotMatch = new ErrorMaker();
                PasswordsDoNotMatch.SignUpError();
                System.out.println("Var4");
            }

        });
    }

    private void BackToProfile() {
        CancelButton.getScene().getWindow().hide(); // берем поточну сцену, поточне вікно і закриваємо його
        FXMLLoader loader = new FXMLLoader(); // додаємо об'єкт класу FXMLLoader для загрузки іншого вікна

        loader.setLocation(getClass().getResource("samples/MyProfile.fxml"));
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

    private void FillTheFields() {
        DatabaseHandler CurrentProfile = new DatabaseHandler();
        try {
            CurrentProfile.getCurrentUser(MyCurrentUsername);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        NameField.setText(DatabaseHandler.MyName);
        LastNameField.setText(DatabaseHandler.MyLastname);
        UsernameField.setText(DatabaseHandler.MyUsername);
        CountryField.setText(DatabaseHandler.MyCountry);
        eMailField.setText(DatabaseHandler.MyEmail);
    }

}
