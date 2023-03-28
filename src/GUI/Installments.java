package GUI;

import classes.Car;
import classes.customer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import GUI.database.DBHandler;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Installments extends Application {
    private static DBHandler dbHandler;
    private static Connection connection;
    private static PreparedStatement preparedStatement;


    @Override
    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
        GridPane g4= new GridPane();
        g4.setAlignment(Pos.CENTER);
        g4.setHgap(10);
        g4.setVgap(10);

        Text t1= new Text("Installments Section");
        t1.setTextAlignment(TextAlignment.CENTER);
        g4.setAlignment(Pos.TOP_CENTER);
        g4.add(t1,0,0);

        Scene installments= new Scene(g4,700,600);
        Label l1= new Label("Choose number of months:");
        g4.add(l1,0,1);
        String[] months= {"12 Months", "24 Months","36 Months"};
        String p1[]= new String[1];
        ChoiceBox cb1= new ChoiceBox(FXCollections.observableArrayList(months));
        cb1.getSelectionModel().selectedIndexProperty().addListener((observableValue, oldValue, newValue) ->
                p1[0]= months[newValue.intValue()]);
        g4.add(cb1,1,1);

        dbHandler = new DBHandler();
        connection= dbHandler.getDbconnection();
        String delete= "DELETE FROM customers WHERE Name = ?";
        preparedStatement = connection.prepareStatement(delete);

        Button Back= new Button("Back");
        g4.add(Back,0,2);
        Back.setOnAction(e->
        {
            payment pay= new payment();
            pay.start(primaryStage);
        });

        Button next= new Button("Next");
        g4.add(next,1,2);
        next.setOnAction(e->{
            Car c= Car.getInstance();
            customer customer= classes.customer.getInstance();
            if (cb1.getValue().toString().equals("12 Months")){

                if(customer.getSalary()<(c.getCarprice()/12)){
                    JOptionPane.showMessageDialog(null,"Your Salary is not high enough to get this car on Installments");
                    try {
                        preparedStatement.setString(1,customer.getName());
                        preparedStatement.execute();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    Main main= new Main();

                    try {
                        main.start(primaryStage);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "You will have to deposit " + (c.getCarprice() / 12) + "$ for 12 months");
                    Finalmenu f1= new Finalmenu();
                    try {
                        f1.start(primaryStage);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
                }
            else if (cb1.getValue().toString().equals("24 Months")) {
                if (customer.getSalary() < (c.getCarprice() / 24)) {
                    JOptionPane.showMessageDialog(null, "Your Salary is not high enough to get this car on Installments");
                    try {
                        preparedStatement.setString(1,customer.getName());
                        preparedStatement.execute();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    Main main = new Main();
                    try {
                        main.start(primaryStage);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You will have to deposit " + (c.getCarprice() / 24) + "$ for 24 months");
                    Finalmenu f1= new Finalmenu();
                    try {
                        f1.start(primaryStage);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
            else if (cb1.getValue().toString().equals("36 Months")) {
                if (customer.getSalary() < (c.getCarprice() / 24)) {
                    JOptionPane.showMessageDialog(null, "Your Salary is not high enough to get this car on Installments");
                    try {
                        preparedStatement.setString(1,customer.getName());
                        preparedStatement.execute();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    Main main = new Main();
                    try {
                        main.start(primaryStage);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You will have to deposit " + (c.getCarprice() / 36) + "$ for 36 months");
                    Finalmenu f1= new Finalmenu();
                    try {
                        f1.start(primaryStage);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }


        });
        primaryStage.setScene(installments);
    }
}