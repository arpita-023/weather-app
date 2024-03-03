package com.example.demo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseController {
    @FXML
    private Label User_reg;
    public void register_view(ActionEvent event){


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = "SELECT user_name FROM user";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);
            while (queryOutput.next()){
                User_reg.setText(queryOutput.getString("user_name"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}