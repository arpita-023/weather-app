package com.example.demo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class loginController {
    private Stage primaryStage;
    @FXML
    private Button Login_button;
    @FXML
    private Button Signin_button;
    @FXML
    private TextField Username,Password;

    public void login_view() throws IOException{
        if (Username.getText().length() == 0) {
            Username.setStyle("-fx-border-color:red;-fx-border-width:2px;");
            //new animatefx.animation.Shake(Username).play();
        } else if (Password.getText().length() == 0) {

            Password.setStyle("-fx-border-color:red;-fx-border-width:2px;");
            //new animatefx.animation.Shake(Password).play();
        } else {

            System.out.println("hi");
            Stage stage = (Stage) Login_button.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("location.fxml"));
            primaryStage.setTitle("home page");
            primaryStage.setScene(new Scene(root, 339, 600));
            primaryStage.show();
        }

    }
    public void signup_view() throws IOException {
        System.out.println("hi");
        Stage stage = (Stage) Signin_button.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        primaryStage.setTitle("home page");
        primaryStage.setScene(new Scene(root, 339, 600));
        primaryStage.show();

    }
}
