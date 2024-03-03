package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.concurrent.ThreadLocalRandom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterController {
    private Stage primaryStage;


    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;
    @FXML
    private Button Register_button;
    @FXML
    private DatabaseController databaseController;


    public void setDatabaseController(DatabaseController databaseController) {
        this.databaseController = databaseController;
    }


    public void register_view() throws IOException {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        int min = 0;
        int max = 10000000;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return;
        }




            System.out.println("hi");
            Stage stage = (Stage) Register_button.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("location.fxml"));
            primaryStage.setTitle("home page");
            primaryStage.setScene(new Scene(root, 339, 600));
            primaryStage.show();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String insertQuery = "INSERT INTO user (user_id, user_name, email, password ) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, randomNum);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Registration successful!");
            } else {
                System.out.println("Registration failed!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
