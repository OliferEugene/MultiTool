package company.controllers;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko 28.09.18
Class App was created in 21:42 28.09.18
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;


public class AppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CalcButton;

    @FXML
    private Button ReminderButton;

    @FXML
    private Button MultitoolButton;

    @FXML
    private SplitMenuButton SettingsMenu;

    @FXML
    private MenuItem MyAccountButton;

    @FXML
    private MenuItem ChangeUserButton;

    @FXML
    private MenuItem ExitButton;

    @FXML
    void initialize() {
        ChangeUserButton.setOnAction(event -> {
            ChangeUser("samples/loginWindow.fxml");
        });
        ExitButton.setOnAction(event -> {
            ExitProgramm();
        });
        CalcButton.setOnAction(event -> {
            CalcButton.getScene().getWindow().hide(); // берем поточну сцену, поточне вікно і закриваємо його
            FXMLLoader loader = new FXMLLoader(); // додаємо об'єкт класу FXMLLoader для загрузки іншого вікна

            loader.setLocation(getClass().getResource("samples/CalcTool.fxml"));
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
    }
    public void ChangeUser(String window) {
        SettingsMenu.getScene().getWindow().hide(); // берем поточну сцену, поточне вікно і закриваємо його
        FXMLLoader loader = new FXMLLoader(); // додаємо об'єкт класу FXMLLoader для загрузки іншого вікна

        loader.setLocation(getClass().getResource(window));
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
    public void ExitProgramm() {
        SettingsMenu.getScene().getWindow().hide();
    }
}

