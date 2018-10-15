package company.controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import company.animations.Shake;
import company.controllers.samples.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class loginWindowController extends ErrorMaker {

    Date date = new Date();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private CheckBox RememberCheckbox;

    @FXML
    private Button LogInButton = new Button();

    @FXML
    private Button SignUpButton = new Button();

    @FXML
    void initialize() { // дії у вікні

        rememberUser();

        LogInButton.setOnAction(event -> {

            String loginText = login_field.getText().trim();
            String loginPass = password_field.getText().trim();

            if (!loginText.equals("") && !loginPass.equals("")) {
                loginUser(loginText, loginPass);
                if (RememberCheckbox.isSelected()) {
                    try {
                        File nameFile = new File("LastUsername.txt");
                        if(!nameFile.exists()){
                            nameFile.createNewFile();
                        }

                        PrintWriter namewriter = new PrintWriter(nameFile);
                        namewriter.println(loginText);
                        namewriter.close();

                        File passFile = new File("LastPass.txt");
                        if(!passFile.exists()){
                            passFile.createNewFile();
                        }


                        PrintWriter passwriter = new PrintWriter(passFile);
                        passwriter.println(loginPass);
                        passwriter.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                ErrorMaker empty_field = new ErrorMaker();
                empty_field.LoginError();
            }

        });

        SignUpButton.setOnAction(event -> { // дія для кнопки Sign Up
            SignUpButton.getScene().getWindow().hide(); // берем поточну сцену, поточне вікно і закриваємо його
            FXMLLoader loader = new FXMLLoader(); // додаємо об'єкт класу FXMLLoader для загрузки іншого вікна

            loader.setLocation(getClass().getResource("samples/SignUp.fxml"));
            // вказуємо шлях до файлу вікна, яке збираємось відкрити

            try {
                loader.load(); // запускаємо вікно
            } catch (IOException e) {
                e.printStackTrace();
            } finally {


                Parent root = loader.getRoot(); // отримуємо шлях до вікна (хуй знає нашо це робиться)
                Stage stage = new Stage();
                stage.setScene(new Scene(root)); // вказуємо шлях до файлу який потрібно підключити
                stage.showAndWait(); // показуємо вікно і чекаємо
            }
        });
    }

    private void loginUser(String loginText, String loginPass) {
        DatabaseHandler dbHander = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPass);

        dbHander.getUser(user);

        ResultSet result = dbHander.getUser(user);

        int counter = 0;

        try {
            while (result.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (counter >= 1) {
            openNewScene("samples/App.fxml");
        } else {
            Shake userLoginAnim = new Shake(login_field);
            Shake userPasswordAnim = new Shake(password_field);
            userLoginAnim.playAnim();
            userPasswordAnim.playAnim();
            ErrorMaker empty_field = new ErrorMaker();
            empty_field.LoginError();
        }
    }

    public void openNewScene(String window) {
        SignUpButton.getScene().getWindow().hide(); // берем поточну сцену, поточне вікно і закриваємо його
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
            stage.showAndWait(); // показуємо вікно і чекаємо
        }
    }

    private void rememberUser () {
        BufferedReader br = null;
        BufferedReader br1 = null;


        try {
            File nameFile = new File("LastUsername.txt");
            if(!nameFile.exists()){
                nameFile.createNewFile();
            }

            File passFile = new File("LastPass.txt");
            if(!passFile.exists()){
                passFile.createNewFile();
            }

            br = new BufferedReader(new FileReader("LastUsername.txt"));
            br1 = new BufferedReader(new FileReader("LastPass.txt"));
            String NameLine;
            String PassLine;

            while ((NameLine = br.readLine()) != null) {
                login_field.setText(NameLine);
            }
            while((PassLine = br1.readLine()) != null) {
                password_field.setText(PassLine);
            }
        }catch (IOException e) {
            e.printStackTrace();
        } try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
Info from itProger.com:
 Для перехода между окнами стоит использовать специальный класс FXMLLoader.
 Он отвечает за загрузку нужного fxml файла.
 Для его отображения необходимо использовать другие классы, позволяющие отобразить загруженный fxml файл.
 Это такие классы, как: Parent, Stage и Scene.
 */

