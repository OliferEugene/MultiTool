package company.controllers.samples;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko 29.09.18
Class DatabaseHandler was created in 11:48 29.09.18
© 2018 Olifer. All rights reserved. All trademarks are the property of their respective.
*/
import company.controllers.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?autoReconnect=true&useSSL=false&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(User user) {
//        String insert = String.format("INSERT INTO%s(%s,%s,%s,%s,%s,%s,%s,%s)VALUES(?,?,?,?,?,?,?,?)",
//                Const.USER_TABLE, Const.USERS_FIRSTNAME, Const.USERS_LASTNAME, Const.USERS_USERNAME,
//                Const.USERS_PASSWORD, Const.USERS_COUNTRY, Const.USERS_LANGUAGE, Const.USERS_EMAIL,
//                Const.USERS_GENDER);

        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME
                + "," + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," + Const.USERS_COUNTRY + "," +
                Const.USERS_LANGUAGE + "," + Const.USERS_EMAIL + ","
                + Const.USERS_GENDER + ")" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";



        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUserName());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getCountry());
            prSt.setString(6, user.getLanguage());
            prSt.setString(7, user.getEmail());
            prSt.setString(8, user.getGender());
            prSt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            System.out.println("User with username " + user.getUserName() + " is already exists.");

            DatabaseHandler UniqError = new DatabaseHandler();
            UniqError.UserUniqError();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    protected void UserUniqError() {
        FXMLLoader error = new FXMLLoader();

        error.setLocation(getClass().getResource("UserUniqError.fxml"));
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

    public ResultSet getUser (User user) {

        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_USERNAME + " = ? AND " + Const.USERS_PASSWORD + " = ?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;

    }
}
