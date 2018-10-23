package company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
Created 28.09.2018
Build #315 23.10.2018
3568 lines 23.10.2018
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("controllers/samples/loginWindow.fxml"));
        primaryStage.setTitle("Olifer's Multitool 2018");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

//TODO: додати калькулятор матриць
//TODO: додади адмінку
//TODO: додади мови
//TODO: додати функціонал вікну Settings