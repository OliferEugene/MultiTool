package company.controllers;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko 22.10.18
Class ScoreCounterController was created in 19:01 22.10.18
© 2018 Olifer. All rights reserved. All trademarks are the property of their respective.
*/

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import company.animations.Shake;
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
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private Button GoButton;

    @FXML
    private Label PlayerWonLabel;

    @FXML
    private Label WonLabel;

    @FXML
    private Button CancelButton;

    int PlayersNumber = 0;

    boolean NumberOfPlayersChoosen =false;
    boolean NamesEntered = false;
    boolean go = false;
    boolean GameOver = false;

    public String name1 = null;
    public String name2 = null;
    public String name3 = null;
    public String name4 = null;

    public int intScore1 = 0;
    public int intScore2 = 0;
    public int intScore3 = 0;
    public int intScore4 = 0;

    public String stringScore1 = "0";
    public String stringScore2 = "0";
    public String stringScore3 = "0";
    public String stringScore4 = "0";

    public int ScoresInThisRound1 = 0;
    public int ScoresInThisRound2 = 0;
    public int ScoresInThisRound3 = 0;
    public int ScoresInThisRound4 = 0;

    public int intRound = 1;
    public String stringRound = null;

    @FXML
    void initialize() {

        intScore1 = 0;
        intScore2 = 0;
        intScore3 = 0;
        intScore4 = 0;

        PlayerWonLabel.setVisible(false);
        WonLabel.setVisible(false);

        CancelButton.setOnAction(event -> CancelButton());

        twoPlayersButton.setOnAction(event -> TwoPlayersButton());
        threePlayersButton.setOnAction(event -> ThreePlayersButton());
        fourPlayersButton.setOnAction(event -> FourPlayersButton());

        SubmitButton.setOnAction(event -> {
            if (NumberOfPlayersChoosen == false) {
                SubmitButton();
            } else if (NamesEntered == false){
                StartButton();
            }
            if ((NamesEntered == true) & (go == true) & (GameOver == false)) {
                RoundButton();

                Shake Player1ScoresLabelAnim = new Shake(Player1ScoresLabel);
                Shake Player2ScoresLabelAnim = new Shake(Player2ScoresLabel);
                Shake Player3ScoresLabelAnim = new Shake(Player3ScoresLabel);
                Shake Player4ScoresLabelAnim = new Shake(Player4ScoresLabel);
                Player1ScoresLabelAnim.playAnim();
                Player2ScoresLabelAnim.playAnim();
                Player3ScoresLabelAnim.playAnim();
                Player4ScoresLabelAnim.playAnim();

                Player1ScoresTextField.setText("");
                Player2ScoresTextField.setText("");
                Player3ScoresTextField.setText("");
                Player4ScoresTextField.setText("");
            }
        });

        GoButton.setOnAction(event -> goButton());

        Player1Name.setOnAction(event -> Player1Label.setText(Player1Name.getText()));
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

    private void goButton() {
        go = true;
        GoButton.setVisible(false);
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

        GoButton.setVisible(true);

        ScoresLabel.setVisible(true);

        if (PlayersNumber == 2) {
            Player1ScoresLabel.setVisible(true);
            Player2ScoresLabel.setVisible(true);

            Player1ScoresTextField.setVisible(true);
            Player2ScoresTextField.setVisible(true);

            name1 = Player1Label.getText();
            name2 = Player2Label.getText();

        } else if (PlayersNumber == 3) {
            Player1ScoresLabel.setVisible(true);
            Player2ScoresLabel.setVisible(true);
            Player3ScoresLabel.setVisible(true);

            Player1ScoresTextField.setVisible(true);
            Player2ScoresTextField.setVisible(true);
            Player3ScoresTextField.setVisible(true);

            name1 = Player1Label.getText();
            name2 = Player2Label.getText();
            name3 = Player3Label.getText();
        } else if (PlayersNumber == 4) {
            Player1ScoresLabel.setVisible(true);
            Player2ScoresLabel.setVisible(true);
            Player3ScoresLabel.setVisible(true);
            Player4ScoresLabel.setVisible(true);

            Player1ScoresTextField.setVisible(true);
            Player2ScoresTextField.setVisible(true);
            Player3ScoresTextField.setVisible(true);
            Player4ScoresTextField.setVisible(true);

            name1 = Player1Label.getText();
            name2 = Player2Label.getText();
            name3 = Player3Label.getText();
            name4 = Player4Label.getText();
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

        if(PlayersNumber == 2) {
            stringScore1 = Player1ScoresTextField.getText();
            stringScore2 = Player2ScoresTextField.getText();

            ScoresInThisRound1 = Integer.parseInt(stringScore1);
            ScoresInThisRound2 = Integer.parseInt(stringScore2);

            intScore1 += ScoresInThisRound1;
            intScore2 += ScoresInThisRound2;

            stringScore1 = Integer.toString(intScore1);
            stringScore2 = Integer.toString(intScore2);

            Player1ScoresLabel.setText(stringScore1);
            Player2ScoresLabel.setText(stringScore2);
        } else if(PlayersNumber == 3) {
            stringScore1 = Player1ScoresTextField.getText();
            stringScore2 = Player2ScoresTextField.getText();
            stringScore3 = Player3ScoresTextField.getText();

            ScoresInThisRound1 = Integer.parseInt(stringScore1);
            ScoresInThisRound2 = Integer.parseInt(stringScore2);
            ScoresInThisRound3 = Integer.parseInt(stringScore3);

            intScore1 += ScoresInThisRound1;
            intScore2 += ScoresInThisRound2;
            intScore3 += ScoresInThisRound3;

            stringScore1 = Integer.toString(intScore1);
            stringScore2 = Integer.toString(intScore2);
            stringScore3 = Integer.toString(intScore3);

            Player1ScoresLabel.setText(stringScore1);
            Player2ScoresLabel.setText(stringScore2);
            Player3ScoresLabel.setText(stringScore3);
        } else if (PlayersNumber == 4) {
            stringScore1 = Player1ScoresTextField.getText();
            stringScore2 = Player2ScoresTextField.getText();
            stringScore3 = Player3ScoresTextField.getText();
            stringScore4 = Player4ScoresTextField.getText();

            ScoresInThisRound1 = Integer.parseInt(stringScore1);
            ScoresInThisRound2 = Integer.parseInt(stringScore2);
            ScoresInThisRound3 = Integer.parseInt(stringScore3);
            ScoresInThisRound4 = Integer.parseInt(stringScore4);

            intScore1 += ScoresInThisRound1;
            intScore2 += ScoresInThisRound2;
            intScore3 += ScoresInThisRound3;
            intScore4 += ScoresInThisRound4;

            stringScore1 = Integer.toString(intScore1);
            stringScore2 = Integer.toString(intScore2);
            stringScore3 = Integer.toString(intScore3);
            stringScore4 = Integer.toString(intScore4);

            Player1ScoresLabel.setText(stringScore1);
            Player2ScoresLabel.setText(stringScore2);
            Player3ScoresLabel.setText(stringScore3);
            Player4ScoresLabel.setText(stringScore4);

        }
        if(intScore1 >= 1000) {
            PlayerWonLabel.setText(name1);
            PlayerWonLabel.setVisible(true);
            WonLabel.setVisible(true);
            GameOver = true;
        } else if(intScore2 >= 1000) {
            PlayerWonLabel.setText(name2);
            PlayerWonLabel.setVisible(true);
            WonLabel.setVisible(true);
            GameOver = true;
        } else if(intScore3 >= 1000) {
            PlayerWonLabel.setText(name3);
            PlayerWonLabel.setVisible(true);
            WonLabel.setVisible(true);
            GameOver = true;
        } else if(intScore4 >= 1000) {
            PlayerWonLabel.setText(name4);
            PlayerWonLabel.setVisible(true);
            WonLabel.setVisible(true);
            GameOver = true;
        }
    }
}
