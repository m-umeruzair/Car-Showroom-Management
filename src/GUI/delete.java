package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import GUI.database.DBHandler;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class delete extends Application {
    private static DBHandler dbHandler;
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static PreparedStatement preparedStatement1;
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane g11= new GridPane();
        g11.setAlignment(Pos.CENTER);
        g11.setHgap(10);
        g11.setVgap(10);
        g11.setPadding(new Insets(25, 25, 25, 25));

        dbHandler = new DBHandler();
        connection= dbHandler.getDbconnection();
        String delete= "DELETE FROM customers WHERE Name = ?";
         preparedStatement = connection.prepareStatement(delete);
        String read = "SELECT * FROM customers";
        preparedStatement1= connection.prepareStatement(read);

        Label label= new Label("Enter Name to delete Record:");
        g11.add(label,1,1);

        TextField tf= new TextField();
        g11.add(tf,2,1);
        Scene scene= new Scene(g11,700,600);
        Button back= new Button("Back");
        g11.add(back,1,3);
        back.setOnAction(e->
        {
            admindets a1= new admindets();
            try {
                a1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button Submit= new Button("Submit");
        g11.add(Submit,2,3);
        Submit.setOnAction(e->
        {
            try {
                preparedStatement.setString(1,tf.getText());
                ResultSet resultSet= preparedStatement1.executeQuery();
               while (resultSet.next())
                if (tf.getText().equals(resultSet.getString("Name"))) {
                    JOptionPane.showMessageDialog(null, "Entry Deleted");
                    preparedStatement.execute();
                    admindets a1= new admindets();
                    a1.start(primaryStage);
                }
               else {
                   JOptionPane.showMessageDialog(null,"Record with this name does not exist");
                    admindets a1= new admindets();
                    a1.start(primaryStage);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        primaryStage.setScene(scene);
    }
}
