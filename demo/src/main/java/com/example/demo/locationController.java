package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class locationController {

    @FXML
    private TextField showtemperatureLabel;

    @FXML
    private TextField showhumidityLabel;

    @FXML
    private TextField locationTextField;

    @FXML
    private void handleSearchButton() {
        String location = locationTextField.getText();
        String query = "SELECT temperature, humidity FROM weather_data WHERE location_name = ?";
        try{
            Connection connection = new DatabaseConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, location);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                double temperature = resultSet.getDouble("temperature");
                double humidity = resultSet.getDouble("humidity");
                System.out.println("temp: " + temperature);
                showtemperatureLabel.setText(String.valueOf(temperature));
                showhumidityLabel.setText(String.valueOf(humidity));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
       /* WeatherData weatherData = fetchDataFromDatabase(location);

        if (weatherData != null) {
            showtemperatureLabel.setText(String.valueOf(weatherData.getTemperature()));
            showhumidityLabel.setText(String.valueOf(weatherData.getHumidity()));
        }*/
    }

    private WeatherData fetchDataFromDatabase(String location) {
        String query = "SELECT temperature, humidity FROM weather_data WHERE location = ?";
        try (Connection connection = new DatabaseConnection().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, location);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                double temperature = resultSet.getDouble("temperature");
                double humidity = resultSet.getDouble("humidity");

                return new WeatherData(temperature, humidity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
