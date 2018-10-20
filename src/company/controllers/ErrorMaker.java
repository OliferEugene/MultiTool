package company.controllers;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko 29.09.18
Class ErrorMaker was created in 12:56 29.09.18
© 2018 Olifer. All rights reserved. All trademarks are the property of their respective.
*/

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ErrorMaker {
    protected void LoginError() {
            FXMLLoader error = new FXMLLoader();

            error.setLocation(getClass().getResource("samples/LoginError.fxml"));
            try{
                error.load();
            } catch(IOException e) {
                e.printStackTrace();
            } finally {
                Parent dir = error.getRoot();
                Stage first = new Stage();
                first.setScene(new Scene(dir));
                first.showAndWait();
            }
    }
    protected void SignUpError() {
        FXMLLoader error = new FXMLLoader();

        error.setLocation(getClass().getResource("samples/SignUpError.fxml"));
        try{
            error.load();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            Parent dir = error.getRoot();
            Stage first = new Stage();
            first.setScene(new Scene(dir));
            first.showAndWait();
        }
    }
    public void EditError() {
        FXMLLoader error = new FXMLLoader();

        error.setLocation(getClass().getResource("samples/EditError.fxml"));
        try{
            error.load();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            Parent dir = error.getRoot();
            Stage first = new Stage();
            first.setScene(new Scene(dir));
            first.showAndWait();
        }
    }
    public void UserUniqError() {
        FXMLLoader error = new FXMLLoader();

        error.setLocation(getClass().getResource("samples/UserUniqError.fxml"));
        try{
            error.load();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            Parent dir = error.getRoot();
            Stage first = new Stage();
            first.setScene(new Scene(dir));
            first.show();
        }
    }

    public void ChangesSaved() {
        FXMLLoader error = new FXMLLoader();

        error.setLocation(getClass().getResource("samples/ChangesSaved.fxml"));
        try{
            error.load();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            Parent dir = error.getRoot();
            Stage first = new Stage();
            first.setScene(new Scene(dir));
            first.showAndWait();
        }
    }

}
