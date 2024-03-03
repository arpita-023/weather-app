package com.example.demo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WeatherController {
        @FXML
        private AnchorPane anchorPane;

        @FXML
        private TextField cityTextField;

        @FXML
        private Label temperatureLabel;

        @FXML
        private Label conditionLabel;

        @FXML
        private Button getWeatherButton;



        // Other methods and fields

        @FXML
        private void navigateToRegistration() {
                try {
                        // Load the second FXML using a relative path
                        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo/register.fxml"));

                        // Create a new scene
                        Scene scene = new Scene(root);

                        // Get the stage from the current scene
                        Stage stage = (Stage) anchorPane.getScene().getWindow();

                        // Set the new scene on the stage
                        stage.setScene(scene);
                } catch (Exception e) {
                        e.printStackTrace(); // Handle exception appropriately
                }
        }



        @FXML
        private void getWeather() {
        // Handle the logic to fetch weather data here
        // For simplicity, let's just display a sample data
        String city = cityTextField.getText();
        String temperature = "25°C";
        String condition = "Sunny";

        // Update UI with the fetched data
        temperatureLabel.setText("Temperature: " + temperature);
        conditionLabel.setText("Condition: " + condition);
        }
        }
