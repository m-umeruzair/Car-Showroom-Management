package GUI;

import classes.Car;
import classes.customer;
import GUI.database.DBHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class customerinput extends Application {
    private static DBHandler dbHandler;
    private static Connection connection;
    private static PreparedStatement preparedStatement;



    public void start(Stage primarystage)throws Exception{
    GridPane g1= new GridPane();
    g1.setAlignment(Pos.CENTER);
    g1.setHgap(10);
    g1.setVgap(10);
    g1.setPadding(new Insets(25, 25, 25, 25));

    Scene input= new Scene(g1,700,600);
    Text t1= new Text("Customer Form");
    g1.setAlignment(Pos.TOP_CENTER);
    g1.add(t1,0,0);

    Label cname = new Label("Name:");
    g1.add(cname,0,1);
    TextField cname1= new TextField();
    g1.add(cname1,1,1);

    Label ccnic= new Label("CNIC*:");
    g1.add(ccnic,0,2);
    TextField ccnic1= new TextField();
    g1.add(ccnic1,1,2);

    Label cgender = new Label("Gender:");
     g1.add(cgender,0,3);
    TextField cgender1= new TextField();
    g1.add(cgender1,1,3);

    Label cphoneno= new Label("Phone no*:");
    g1.add(cphoneno,0,4);
    TextField cphone1= new TextField();
    g1.add(cphone1,1,4);

    Label caddress = new Label("Address:");
    g1.add(caddress,0,5);
    TextField caddress1= new TextField();
    g1.add(caddress1,1,5);

    Label csalary= new Label("Salary*:");
    g1.add(csalary,0,6);
    TextField csalary1= new TextField();
    g1.add(csalary1,1,6);

    Label lx= new Label("* Fields are numbers only field.");
    g1.add(lx,0,7);

    Button Back = new Button("Back");
    g1.add(Back,0,8);
    Back.setOnAction(e->
    {
        try {
            carselection c11 = new carselection();
            c11.start(primarystage);
        }catch (NullPointerException e1){
            JOptionPane.showMessageDialog(null,"Please Don't leave the fields empty");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    });
    Button Submit= new Button("Submit");
    g1.add(Submit,2,8);
    Submit.setOnAction(e ->
        {
        dbHandler = new DBHandler();
        try {
            connection= dbHandler.getDbconnection();
            Car car= Car.getInstance();
            customer c1= customer.getInstance();
            c1.setName(cname1.getText());
            c1.setCnic(Long.parseLong(ccnic1.getText()));
            c1.setGender(cgender1.getText());
            c1.setAddress(caddress1.getText());
            c1.setPhoneno(Integer.parseInt(cphone1.getText()));
            c1.setSalary(Integer.parseInt(csalary1.getText()));


            String insert= "Insert INTO customers(Name,CNIC,Gender,Phoneno,Address,Salary,Car,Variation,Colour,Price)"+"Values(?,?,?,?,?,?,?,?,?,?)";
                preparedStatement= connection.prepareStatement(insert);
                preparedStatement.setString(1,cname1.getText());
                preparedStatement.setInt(2, Integer.parseInt(ccnic1.getText()));
                preparedStatement.setString(3,cgender1.getText());
                preparedStatement.setInt(4, Integer.parseInt(cphone1.getText()));
                preparedStatement.setString(5,caddress1.getText());
                preparedStatement.setInt(6, Integer.parseInt(csalary1.getText()));
                preparedStatement.setString(7,car.getCarname());
                preparedStatement.setString(8,car.getCarvariant());
                preparedStatement.setString(9,car.getcarcolour());
                preparedStatement.setInt(10, car.getCarprice());
                preparedStatement.executeUpdate();
                preparedStatement.close();


            payment p= new payment();
            p.start(primarystage);

        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Wrong input in numbers only field");
        }
        catch (NullPointerException e2){
            JOptionPane.showMessageDialog(null,"Please fill all the fields");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

    });
    primarystage.setScene(input);
}
}
