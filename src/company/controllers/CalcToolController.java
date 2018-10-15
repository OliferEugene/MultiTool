package company.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import static java.lang.Math.*;


public class CalcToolController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label ResultTextBlock;
    @FXML
    private Label ActionTextBlock;
    @FXML
    private Button backspaceButton;
    @FXML
    private Button zeroButton;
    @FXML
    private Button enterButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button eightButton;
    @FXML
    private Button nineButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button sixButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button plusButton;
    @FXML
    private Button minusButton;
    @FXML
    private Button multipleButton;
    @FXML
    private Button divideButton;
    @FXML
    private Button percentButton;
    @FXML
    private Button absButton;
    @FXML
    private Button leftBrecketButton;
    @FXML
    private Button rightBrecketButton;
    @FXML
    private Button degreeButton;
    @FXML
    private Button sqrtButton;
    @FXML
    private Button sinusButton;
    @FXML
    private Button cosinusButton;
    @FXML
    private Button tangesButton;
    @FXML
    private Button lnButton;
    @FXML
    private Button logButton;
    @FXML
    private Button PButton;
    @FXML
    private Button dotButton;
    @FXML
    private Label PasteActionTextBlock;

    private String ActionText;
    private String PasteActionText = null;
    private String Cls = "0";
    private String PasteCls = null;

    private double Operand1 = 0;
    private double Operand2 = 0;
    private double operationResult = 0;

    private boolean OperationChoosen = false;
    private boolean OperationDone = false;
    private boolean DotWasPressed = false;
    private boolean AbsWasUsed = false;
    private boolean BackspaceWasPressed = false;
    private boolean ContinueOperations = false;

    private char lastChar = '0';

    private String ResultText = null;
    private String operationType = null;

    @FXML
    void initialize() {



        ActionText = "0";
        System.out.println(ActionText);

        oneButton.setOnAction(event -> {
            if (ActionText == "0") {
                ActionText = "1";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            } else if (ActionText == "-0") {
                ActionText = "-1";
                ActionTextBlock.setText(ActionText);
            } else {
                ActionText += "1";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            }
        });
        twoButton.setOnAction(event -> {
            if (ActionText == "0") {
                ActionText = "2";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            } else if (ActionText == "-0") {
                ActionText = "-2";
                ActionTextBlock.setText(ActionText);
            } else {
                ActionText += "2";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            }
        });
        threeButton.setOnAction(event -> {
            if (ActionText == "0") {
                ActionText = "3";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            } else if (ActionText == "-0") {
                ActionText = "-3";
                ActionTextBlock.setText(ActionText);
            } else {
                ActionText += "3";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            }
        });
        fourButton.setOnAction(event -> {
            if (ActionText == "0") {
                ActionText = "4";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            } else if (ActionText == "-0") {
                ActionText = "-4";
                ActionTextBlock.setText(ActionText);
            } else {
                ActionText += "4";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            }
        });
        fiveButton.setOnAction(event -> {
            if (ActionText == "0") {
                ActionText = "5";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            } else if (ActionText == "-0") {
                ActionText = "-5";
                ActionTextBlock.setText(ActionText);
            } else {
                ActionText += "5";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            }
        });
        sixButton.setOnAction(event -> {
            if (ActionText == "0") {
                ActionText = "6";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            } else if (ActionText == "-0") {
                ActionText = "-6";
                ActionTextBlock.setText(ActionText);
            } else {
                ActionText += "6";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            }
        });
        sevenButton.setOnAction(event -> {
            if (ActionText == "0") {
                ActionText = "7";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            } else if (ActionText == "-0") {
                ActionText = "-7";
                ActionTextBlock.setText(ActionText);
            } else {
                ActionText += "7";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            }
        });
        eightButton.setOnAction(event -> {
            if (ActionText == "0") {
                ActionText = "8";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            } else if (ActionText == "-0") {
                ActionText = "-8";
                ActionTextBlock.setText(ActionText);
            } else {
                ActionText += "8";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            }
        });
        nineButton.setOnAction(event -> {
            if (ActionText == "0") {
                ActionText = "9";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            } else if (ActionText == "-0") {
                ActionText = "-9";
                ActionTextBlock.setText(ActionText);
            } else {
                ActionText += "9";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            }
        });
        zeroButton.setOnAction(event -> {
            if (ActionText != "0") {
                ActionText += "0";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
            } else if (ActionText == "-0") {
                ActionText += ".";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
                DotWasPressed = true;
            }
        });

        dotButton.setOnAction(event -> {
            if (DotWasPressed == false){
                ActionText += ".";
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
                DotWasPressed = true;
            }
        });
        backspaceButton.setOnAction(event -> {
            if ((BackspaceWasPressed == false)){
                ActionText = "-" + ActionText;
                System.out.println(ActionText);
                ActionTextBlock.setText(ActionText);
                BackspaceWasPressed = true;
            }
        });


        PButton.setOnAction(event -> {
            String Pee = Double.toString(PI);
            if (DotWasPressed == false) {
                if (ActionText == "0") {
                    ActionText = Pee;
                    System.out.println(ActionText);
                    ActionTextBlock.setText(ActionText);
                } else {
                    ActionText += Pee;
                    System.out.println(ActionText);
                    ActionTextBlock.setText(ActionText);
                }
            }
        });

        clearButton.setOnAction(event -> {
            ActionTextBlock.setText(Cls);
            ActionText = Cls;
            PasteActionTextBlock.setText(PasteCls);
            PasteActionText = PasteCls;
            OperationChoosen = false;
            OperationDone = false;
            DotWasPressed = false;
            BackspaceWasPressed = false;
            ContinueOperations = false;
        });
        enterButton.setOnAction(event -> {
            if ((OperationChoosen == true) & (OperationDone == false)) {
             Operand2 = Double.parseDouble(ActionText);
             ActionTextBlock.setText(PasteCls);
             switch (operationType) {
                 case "addition":
                     operationResult = addition(Operand1, Operand2);
                     ResultText = Double.toString(operationResult);
                     ResultTextBlock.setText(ResultText);
                     OperationDone = true;
                     break;
                 case "subtraction":
                     operationResult = subtraction(Operand1, Operand2);
                     ResultText = Double.toString(operationResult);
                     ResultTextBlock.setText(ResultText);
                     OperationDone = true;
                     break;
                 case "multiplication":
                     operationResult = multiplication(Operand1, Operand2);
                     ResultText = Double.toString(operationResult);
                     ResultTextBlock.setText(ResultText);
                     OperationDone = true;
                     break;
                 case "division":
                     operationResult = division(Operand1, Operand2);
                     ResultText =  Double.toString(operationResult);
                     ResultTextBlock.setText(ResultText);
                     OperationDone = true;
                     break;
                 case "degree":
                     operationResult = raiseToADegree(Operand1, Operand2);
                     ResultText = Double.toString(operationResult);
                     ResultTextBlock.setText(ResultText);
                     OperationDone = true;
                     break;
                 case "restDivision":
                     operationResult = restDivision(Operand1, Operand2);
                     ResultText = Double.toString(operationResult);
                     ResultTextBlock.setText(ResultText);
                     OperationDone = true;
             }

                OperationChoosen = false;
                Operand1 = operationResult;
                PasteActionTextBlock.setText(ResultText);
                ContinueOperations = true;

            }
        });

        plusButton.setOnAction(event -> {
            if (OperationChoosen == false) {
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);
                if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " + ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                OperationChoosen = true;
                operationType = "addition";
                OperationDone = false;
            }
        });
        minusButton.setOnAction(event -> {
            if (OperationChoosen == false) {
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);
                if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " - ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                OperationChoosen = true;
                operationType = "subtraction";
                OperationDone = false;
            }
        });
        multipleButton.setOnAction(event -> {
            if (OperationChoosen == false) {
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);
                if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " * ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                OperationChoosen = true;
                operationType = "multiplication";
                OperationDone = false;
            }
        });
        divideButton.setOnAction(event -> {
            if (OperationChoosen == false) {
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);
                if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " / ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                OperationChoosen = true;
                operationType = "division";
                OperationDone = false;
            }
        });

        degreeButton.setOnAction(event -> {
            if (OperationChoosen == false) {
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);
                if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " ^ ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                OperationChoosen = true;
                operationType = "degree";
                OperationDone = false;
            }
        });
        sqrtButton.setOnAction(event -> {
            if (OperationChoosen == false) {
                OperationDone = false;
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);
                if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " sqrt ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                OperationChoosen = true;
                operationResult = squareRoot(Operand1);
                ResultText = Double.toString(operationResult);
                ResultTextBlock.setText(ResultText);
                OperationDone = true;
            }
        });
        absButton.setOnAction(event -> {
            if (AbsWasUsed == false) {
                OperationDone = false;
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);
                if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " abs ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                AbsWasUsed = true;
                operationResult = absolute(operationResult);
                ResultText = Double.toString(operationResult);
                ResultTextBlock.setText(ResultText);
                OperationDone = true;
            }
        });
        percentButton.setOnAction(event -> {
            if (OperationChoosen == false) {
                OperationDone = false;
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);
                if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " % ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                OperationChoosen = true;
                operationType = "restDivision";
            }
        });
        lnButton.setOnAction(event -> {
            if (OperationChoosen == false) {
                OperationDone = false;
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " sqrt ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                OperationChoosen = true;
                operationResult = ln(Operand1);
                ResultText = Double.toString(operationResult);
                ResultTextBlock.setText(ResultText);
                OperationDone = true;
            }
        });
        logButton.setOnAction(event -> {
            if (OperationChoosen == false) {
                OperationDone = false;
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " sqrt ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                OperationChoosen = true;
                operationResult = log(Operand1);
                ResultText = Double.toString(operationResult);
                ResultTextBlock.setText(ResultText);
                OperationDone = true;
            }
        });

        sinusButton.setOnAction(event -> {
            if (OperationChoosen == false) {
                OperationDone = false;
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " sin ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                OperationChoosen = true;
                operationResult = sinA(Operand1);
                ResultText = Double.toString(operationResult);
                ResultTextBlock.setText(ResultText);
                OperationDone = true;
            }
        });
        cosinusButton.setOnAction(event -> {
            if (OperationChoosen == false) {
                OperationDone = false;
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " cos ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                OperationChoosen = true;
                operationResult = cosA(Operand1);
                ResultText = Double.toString(operationResult);
                ResultTextBlock.setText(ResultText);
                OperationDone = true;
            }
        });
        tangesButton.setOnAction(event -> {
            if (OperationChoosen == false) {
                OperationDone = false;
                lastChar = ActionText.charAt(ActionText.length() - 1);
                System.out.println("Last Char is " + lastChar);
                if (lastChar == '.'){
                    System.out.println("Executed");
                    ActionText += "0";
                }
                System.out.println("Action text is " + ActionText);
                ActionTextBlock.setText(Cls);if (ContinueOperations == true) {
                    PasteActionText = ResultText;
                } else {
                    PasteActionText = ActionText;
                }
                if (ContinueOperations == false) {
                    Operand1 = Double.parseDouble(PasteActionText);
                }
                PasteActionText += " tan ";
                ActionText = Cls;
                PasteActionTextBlock.setText(PasteActionText);
                OperationChoosen = true;
                operationResult = tanA(Operand1);
                ResultText = Double.toString(operationResult);
                ResultTextBlock.setText(ResultText);
                OperationDone = true;
            }
        });
    }

    private double addition (double Operand1, double Operand2) {
        double result = Operand1 + Operand2;
        return result;
    }
    private double subtraction (double Operand1, double Operand2) {
        double result = Operand1 - Operand2;
        return result;
    }
    private double multiplication (double Operand1, double Operand2) {
        double result = Operand1 * Operand2;
        return result;
    }
    private double division (double Operand1, double Operand2) {
        double result = Operand1 / Operand2;
        return result;
    }

    private double raiseToADegree (double Operand1, double Operand2) {
        double result = pow(Operand1, Operand2);
        return result;
    }
    private double squareRoot (double Operand1) {
        double result = sqrt(Operand1);
        return result;
    }
    private double absolute (double Operand1) {
       double result = abs(Operand1);
       return result;
    }
    private double restDivision (double Operand1, double Operand2) {
        double result = Operand1 % Operand2;
        return result;
    }

    private double sinA(double Operand1) {
        double result = sin(Operand1);
        return result;
    }
    private double cosA(double Operand1) {
        double result = cos(Operand1);
        return result;
    }
    private double tanA(double Operand1) {
        double result = tan(Operand1);
        return result;
    }

    private double ln (double Operand1) {
        double result = ln(Operand1);
        return result;
    } // Doesn't work.
    private double log (double Operand1) {
        double result = log(Operand1);
        return result;
    } // Doesn't work.

}

//TODO: розібратися з логарифмами
//TODO: придумати як застосовувати дужки