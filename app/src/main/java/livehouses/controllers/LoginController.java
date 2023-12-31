package livehouses.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import livehouses.db.DBConection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userTextField;

    @FXML
    private void initialize() {
        loginButton.setOnAction(event -> {
            if (userTextField.getText().isBlank() && passwordField.getText().isBlank()) {
                System.out.println("There is no user or password");
            } else {
                validateLogin();
            }
        });
    }

    public void validateLogin() {
        DBConection conectionNow = new DBConection();
        Connection connectDB = conectionNow.getConnection();

        String verifyLogin = (
            "SELECT COUNT(1) FROM account WHERE username = '" + userTextField.getText() + "' AND hashed_password = '" + passwordField.getText() + "'"
        );

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if(queryResult.getInt(1) == 1){
                    System.out.println("Login success");
                }
                else{
                    System.out.println("Invalid login");
                }
            }

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
}
