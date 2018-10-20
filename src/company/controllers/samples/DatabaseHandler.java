package company.controllers.samples;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko 29.09.18
Class DatabaseHandler was created in 11:48 29.09.18
© 2018 Olifer. All rights reserved. All trademarks are the property of their respective.
*/

import company.controllers.EditProfileController;
import company.controllers.ErrorMaker;
import company.controllers.User;

import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public static String MyId = null;
    public static String MyName = null;
    public static String MyLastname = null;
    public static String MyUsername = null;
    public static String MyCountry = null;
    public static String MyLanguage = null;
    public static String MyEmail = null;
    public static String MyGender = null;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?autoReconnect=true&useSSL=false&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(User user) {

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
            ErrorMaker UniqError = new ErrorMaker();
            UniqError.UserUniqError();

            e.printStackTrace();
            System.out.println("User with username " + user.getUserName() + " is already exists.");



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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

    public Connection getCurrentUser(String CurrentUser) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://" + dbHost + ":"+ dbPort + "/"+ dbName + "?autoReconnect=true&useSSL=false&serverTimezone=UTC";

        dbConnection = DriverManager.getConnection(url, dbUser, dbPass);

        PreparedStatement ps = dbConnection.prepareStatement("SELECT * FROM Users WHERE Username = '" + CurrentUser + "'");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
             MyId = resultSet.getString(1);
             MyName = resultSet.getString(2);
             MyLastname = resultSet.getString(3);
             MyUsername = resultSet.getString(4);
             MyCountry = resultSet.getString(6);
             MyLanguage = resultSet.getString(7);
             MyEmail = resultSet.getString(8);
             MyGender = resultSet.getString(9);
        }

        dbConnection.close();
        return dbConnection;
    }

    public void getCurrentPass(String CurrentUser) {
        String CurrentPass = null;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement("SELECT Password FROM Users WHERE Username = '" + CurrentUser + "'");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                CurrentPass = resultSet.getString("Password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        EditProfileController.MyCurrentPass = CurrentPass;
    }

    public void EditUser(String CurrentUsername, String NewName, String NewLastName, String NewUserName,
                        String NewCountry, String NewEmail, String NewPassword) {
        String CurrentId = null;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement("SELECT * FROM Users WHERE Username = '" + CurrentUsername + "'");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                CurrentId = resultSet.getString("idUsers");
            }
        } catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String insertUsername = "UPDATE Users SET Username = '" + NewUserName + "' WHERE idUsers = " + CurrentId;
        String insertName = "UPDATE Users SET Firstname = '" + NewName + "' WHERE idUsers = " + CurrentId;
        String insertLastName = "UPDATE Users SET Lastname = '" + NewLastName + "' WHERE idUsers = " + CurrentId;
        String insertCountry = "UPDATE Users SET Country = '" + NewCountry + "' WHERE idUsers = " + CurrentId;
        String insertEmail = "UPDATE Users SET Email = '" + NewEmail + "' WHERE idUsers = " + CurrentId;
        String insertPassword = "UPDATE Users SET Password = '" + NewPassword + "' WHERE idUsers = " + CurrentId;

        try {
            PreparedStatement prSt1 = getDbConnection().prepareStatement(insertUsername);
            prSt1.executeUpdate();
            PreparedStatement prSt2 = getDbConnection().prepareStatement(insertName);
            prSt2.executeUpdate();
            PreparedStatement prSt3 = getDbConnection().prepareStatement(insertLastName);
            prSt3.executeUpdate();
            PreparedStatement prSt4 = getDbConnection().prepareStatement(insertCountry);
            prSt4.executeUpdate();
            PreparedStatement prSt6 = getDbConnection().prepareStatement(insertEmail);
            prSt6.executeUpdate();
            PreparedStatement prSt7 = getDbConnection().prepareStatement(insertPassword);
            prSt7.executeUpdate();

            ErrorMaker changesSaved = new ErrorMaker();
            changesSaved.ChangesSaved();

        } catch (SQLIntegrityConstraintViolationException e) {
            ErrorMaker userExists = new ErrorMaker();
            userExists.UserUniqError();
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
