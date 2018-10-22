package company.controllers;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko 22.10.18
Class ScoreCounterController was created in 19:01 22.10.18
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class ScoreCounterController {

    @FXML
    private Button twoPlayersButton;

    @FXML
    private Button threePlayersButton;

    @FXML
    private Button fourPlayersButton;

    @FXML
    private Label ChoosePlayersNumberLabel;

    @FXML
    private Button SubmitButton;

    @FXML
    private Label Player1Label;

    @FXML
    private Label Player2Label;

    @FXML
    private Label Player3Label;

    @FXML
    private Label Player4Label;

    @FXML
    private TextField Player1Name;

    @FXML
    private TextField Player2Name;

    @FXML
    private TextField Player3Name;

    @FXML
    private TextField Player4Name;

    @FXML
    private Line twoPlayersLine;

    @FXML
    private Line threePlayersLine;

    @FXML
    private Line fourPlayersLine;

    @FXML
    private Label ScoresLabel;

    @FXML
    private Label RoundLabel;

    @FXML
    private Label RoundNumberLabel;

    @FXML
    private Label Player1ScoresLabel;

    @FXML
    private Label Player2ScoresLabel;

    @FXML
    private Label Player3ScoresLabel;

    @FXML
    private Label Player4ScoresLabel;

    @FXML
    private TextField Player1ScoresTextField;

    @FXML
    private TextField Player2ScoresTextField;

    @FXML
    private TextField Player3ScoresTextField;

    @FXML
    private TextField Player4ScoresTextField;

    @FXML
    private Button CancelButton;

    int PlayersNumber = 0;

    String name = null;
    int intScore = 0;
    String stringScore = "0";

    int ScoresInThisRound = 0;

    int intRound = 1;
    String stringRound = null;

    boolean NumberOfPlayersChoosen =false;
    boolean NamesEntered = false;

    ScoreCounterController Player1 = new ScoreCounterController();
    ScoreCounterController Player2 = new ScoreCounterController();
    ScoreCounterController Player3 = new ScoreCounterController();
    ScoreCounterController Player4 = new ScoreCounterController();

    @FXML
    void initialize() {

        Player1.intScore = 0;
        Player2.intScore = 0;
        Player3.intScore = 0;
        Player4.intScore = 0;

        CancelButton.setOnAction(event -> CancelButton());

        twoPlayersButton.setOnAction(event -> TwoPlayersButton());
        threePlayersButton.setOnAction(event -> ThreePlayersButton());
        fourPlayersButton.setOnAction(event -> FourPlayersButton());

        SubmitButton.setOnAction(event -> {
            if (NumberOfPlayersChoosen == false) {
                SubmitButton();
            } else {
                StartButton();
            }
            if (NamesEntered == true) {
                RoundButton();
            }
        });

        Player1Name.setOnAction(event ->  Player1Label.setText(Player1Name.getText()));
        Player2Name.setOnAction(event -> Player2Label.setText(Player2Name.getText()));
        Player3Name.setOnAction(event -> Player3Label.setText(Player3Name.getText()));
        Player4Name.setOnAction(event -> Player4Label.setText(Player4Name.getText()));
    }

    private void CancelButton() {
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

    private void TwoPlayersButton() {
        PlayersNumber = 2;
        twoPlayersLine.setVisible(true);
        threePlayersLine.setVisible(false);
        fourPlayersLine.setVisible(false);
    }
    private void ThreePlayersButton() {
        PlayersNumber = 3;
        twoPlayersLine.setVisible(false);
        threePlayersLine.setVisible(true);
        fourPlayersLine.setVisible(false);
    }
    private void FourPlayersButton() {
        PlayersNumber = 4;
        twoPlayersLine.setVisible(false);
        threePlayersLine.setVisible(false);
        fourPlayersLine.setVisible(true);
    }

    private void SubmitButton(){
        if (PlayersNumber == 2) {
            twoPlayersButton.setVisible(false);
            threePlayersButton.setVisible(false);
            fourPlayersButton.setVisible(false);
            ChoosePlayersNumberLabel.setVisible(false);
            twoPlayersLine.setVisible(false);
            threePlayersLine.setVisible(false);
            fourPlayersLine.setVisible(false);

            Player1Label.setVisible(true);
            Player2Label.setVisible(true);

            Player1Name.setVisible(true);
            Player2Name.setVisible(true);

            NumberOfPlayersChoosen =true;

            SubmitButton.setText("Start");
        } else if (PlayersNumber == 3) {
            twoPlayersButton.setVisible(false);
            threePlayersButton.setVisible(false);
            fourPlayersButton.setVisible(false);
            ChoosePlayersNumberLabel.setVisible(false);
            twoPlayersLine.setVisible(false);
            threePlayersLine.setVisible(false);
            fourPlayersLine.setVisible(false);

            Player1Label.setVisible(true);
            Player2Label.setVisible(true);
            Player3Label.setVisible(true);

            Player1Name.setVisible(true);
            Player2Name.setVisible(true);
            Player3Name.setVisible(true);

            NumberOfPlayersChoosen =true;

            SubmitButton.setText("Start");
        } else if (PlayersNumber == 4) {
            twoPlayersButton.setVisible(false);
            threePlayersButton.setVisible(false);
            fourPlayersButton.setVisible(false);
            ChoosePlayersNumberLabel.setVisible(false);
            twoPlayersLine.setVisible(false);
            threePlayersLine.setVisible(false);
            fourPlayersLine.setVisible(false);

            Player1Label.setVisible(true);
            Player2Label.setVisible(true);
            Player3Label.setVisible(true);
            Player4Label.setVisible(true);

            Player1Name.setVisible(true);
            Player2Name.setVisible(true);
            Player3Name.setVisible(true);
            Player4Name.setVisible(true);

            NumberOfPlayersChoosen =true;

            SubmitButton.setText("Start");
        }
    }
    private void StartButton() {
        Player1Name.setVisible(false);
        Player2Name.setVisible(false);
        Player3Name.setVisible(false);
        Player4Name.setVisible(false);

        ScoresLabel.setVisible(true);

        if (PlayersNumber == 2) {
            Player1ScoresLabel.setVisible(true);
            Player2ScoresLabel.setVisible(true);

            Player1ScoresTextField.setVisible(true);
            Player2ScoresTextField.setVisible(true);

            Player1.name = Player1Label.getText();
            Player2.name = Player1Label.getText();

        } else if (PlayersNumber == 3) {
            Player1ScoresLabel.setVisible(true);
            Player2ScoresLabel.setVisible(true);
            Player3ScoresLabel.setVisible(true);

            Player1ScoresTextField.setVisible(true);
            Player2ScoresTextField.setVisible(true);
            Player3ScoresTextField.setVisible(true);

            Player1.name = Player1Label.getText();
            Player2.name = Player1Label.getText();
            Player3.name = Player1Label.getText();
        } else if (PlayersNumber == 4) {
            Player1ScoresLabel.setVisible(true);
            Player2ScoresLabel.setVisible(true);
            Player3ScoresLabel.setVisible(true);
            Player4ScoresLabel.setVisible(true);

            Player1ScoresTextField.setVisible(true);
            Player2ScoresTextField.setVisible(true);
            Player3ScoresTextField.setVisible(true);
            Player4ScoresTextField.setVisible(true);

            Player1.name = Player1Label.getText();
            Player2.name = Player1Label.getText();
            Player3.name = Player1Label.getText();
            Player4.name = Player1Label.getText();
        }

        RoundLabel.setVisible(true);
        RoundNumberLabel.setVisible(true);

        stringRound = Integer.toString(intRound);
        RoundNumberLabel.setText(stringRound);

        NamesEntered = true;
        SubmitButton.setText("Round");
    }
    private void RoundButton() {
        intRound++;
        stringRound = Integer.toString(intRound);
        RoundNumberLabel.setText(stringRound);

        Player1.stringScore = Player1ScoresTextField.getText();
        Player2.stringScore = Player1ScoresTextField.getText();
        Player3.stringScore = Player1ScoresTextField.getText();
        Player4.stringScore = Player1ScoresTextField.getText();

        Player1.ScoresInThisRound = Integer.parseInt(Player1.stringScore);
        Player2.ScoresInThisRound = Integer.parseInt(Player1.stringScore);
        Player3.ScoresInThisRound = Integer.parseInt(Player1.stringScore);
        Player4.ScoresInThisRound = Integer.parseInt(Player1.stringScore);

        Player1.intScore += Player1.ScoresInThisRound;
        Player2.intScore += Player1.ScoresInThisRound;
        Player3.intScore += Player1.ScoresInThisRound;
        Player4.intScore += Player1.ScoresInThisRound;

        Player1ScoresLabel.setText(Integer.toString(Player1.intScore));
        Player2ScoresLabel.setText(Integer.toString(Player2.intScore));
        Player3ScoresLabel.setText(Integer.toString(Player3.intScore));
        Player4ScoresLabel.setText(Integer.toString(Player4.intScore));
    }
}
