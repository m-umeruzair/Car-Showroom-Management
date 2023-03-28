package GUI;

import classes.Car;
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

import javax.swing.*;
import java.sql.SQLException;


public class payment extends Application {



    @Override
    public void start(Stage primaryStage)  {
        GridPane g3= new GridPane();
        g3.setHgap(10);
        g3.setVgap(10);

        Text tx= new Text("Payment Section");
        tx.setTextAlignment(TextAlignment.CENTER);
        g3.add(tx,0,0);
        g3.setAlignment(Pos.TOP_CENTER);

        Scene s1=new Scene(g3,700,600);

        Label l1= new Label("Choose payment method:");
        g3.add(l1,0,1);
        String[] method= {"Full Cash Payment", "Installments"};
        String pay[]= new String[1];
        ChoiceBox selection= new ChoiceBox(FXCollections.observableArrayList(method));
        selection.getSelectionModel().selectedIndexProperty().addListener((observableValue, oldValue, newValue) ->
                pay[0]= method[newValue.intValue()]);
        g3.add(selection,1,1);

        Button Back= new Button("Back");
        g3.add(Back,0,2);
        Back.setOnAction(e->
        {
            customerinput c= new customerinput();
            try {
                c.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Button next= new Button("Next");
        g3.add(next,1,2);
        next.setOnAction(e->
        {   Car car= Car.getInstance();
            if (selection.getValue().toString().equals("Full Cash Payment")){
            JOptionPane.showMessageDialog(null,"Please pay "+car.getCarprice()+"$ at the cash counter.");
            Finalmenu f= new Finalmenu();
            try {
                f.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }else {
            Installments i= new Installments();
                try {
                    i.start(primaryStage);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            } }
        );
        primaryStage.setScene(s1);


    }
}
