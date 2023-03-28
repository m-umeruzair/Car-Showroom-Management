package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import GUI.database.DBHandler;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class view extends Application {
    private static DBHandler dbHandler;
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane g10= new GridPane();
        g10.setHgap(80);
        g10.setVgap(80);
        g10.setPadding(new Insets(25, 25, 25, 25));
        g10.setAlignment(Pos.TOP_CENTER);
        Scene view= new Scene(g10,1400,1100);

        dbHandler = new DBHandler();
        try {
            connection= dbHandler.getDbconnection();
            String read = "SELECT * FROM customers";
            preparedStatement =connection.prepareStatement(read);
            ResultSet resultSet= preparedStatement.executeQuery();
            Text t=new Text("No.");
            g10.add(t,1,0);
            Text t1= new Text("Name");
            g10.add(t1,2,0);
            Text t2= new Text("CNIC");
            g10.add(t2,3,0);
            Text t3= new Text("Gender");
            g10.add(t3,4,0);
            Text t4= new Text("Phone No");
            g10.add(t4,5,0);
            Text t5= new Text("Address");
            g10.add(t5,6,0);
            Text t6= new Text("Salary");
            g10.add(t6,7,0);
            Text t7= new Text("Car");
            g10.add(t7,8,0);
            Text t8= new Text("Variation");
            g10.add(t8,9,0);
            Text t9= new Text("Colour");
            g10.add(t9,10,0);
            Text t10= new Text("Price");
            g10.add(t10,11,0);


            int i=-1;
            while(resultSet.next()) {
                i++;
                Text [] tx= new Text[25];
                Text txx= new Text(""+(i+1));
                tx[i]= txx;
                g10.add(tx[i],1,i+1);
                Text[] tt = new Text[25];
                Text text = new Text(resultSet.getString("Name"));
                tt[i] = text;
                g10.add(tt[i], 2, i + 1);
                Text[] tt2 = new Text[25];
                Text text1 = new Text(resultSet.getString("CNIC"));
                tt2[i] = text1;
                g10.add(tt2[i], 3, i + 1);
                Text[] tt3 = new Text[25];
                Text text2= new Text(resultSet.getString("Gender"));
                tt3[i]=text2;
                g10.add(tt3[i], 4, i+1);
                Text[] tt4 = new Text[25];
                Text text3= new Text(resultSet.getString("Phoneno"));
                tt4[i]=text3;
                g10.add(tt4[i], 5, i+1);
                Text[] tt5 = new Text[25];
                Text text4= new Text(resultSet.getString("Address"));
                tt5[i]=text4;
                g10.add(tt5[i], 6, i+1);
                Text[] tt6 = new Text[25];
                Text text5 = new Text(resultSet.getString("Salary"));
                tt6[i]=text5;
                g10.add(tt6[i], 7, i+1);
                Text[] tt7 = new Text[25];
                Text text6= new Text(resultSet.getString("Car"));
                tt7[i]=text6;
                g10.add(tt7[i], 8, i+1);
                Text[] tt8 = new Text[25];
                Text text7= new Text(resultSet.getString("Variation"));
                tt8[i]=text7;
                g10.add(tt8[i], 9, i+1);
                Text[] tt9 = new Text[25];
                Text text8= new Text(resultSet.getString("Colour"));
                tt9[i]=text8;
                g10.add(tt9[i], 10, i+1);
                Text[] tt10 = new Text[25];
                Text text9= new Text(resultSet.getString("Price"));
                tt10[i]=text9;
                g10.add(tt10[i], 11, i+1);


            }


            resultSet.close();


        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (NullPointerException n){
            JOptionPane.showMessageDialog(null,"No Data to Show");
        }
        Button back= new Button("Back");
        g10.add(back,0,10);
        back.setOnAction(e->
        {
            admindets a1= new admindets();
            try {
                a1.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        primaryStage.setMaximized(true);
        primaryStage.setScene(view);
    }
}
