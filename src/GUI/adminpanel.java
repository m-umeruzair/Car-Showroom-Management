package GUI;

import classes.Admin;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;


public class adminpanel extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane g7= new GridPane();
        g7.setHgap(10);
        g7.setVgap(10);
        g7.setPadding(new Insets(25, 25, 25, 25));
        g7.setAlignment(Pos.CENTER);

        Scene adm= new Scene(g7,700,600);

        Label l11= new Label("Admin ID:");
        g7.add(l11,0,1);

        TextField t1= new TextField();
        g7.add(t1,1,1);

        Label l22= new Label("Password:");
        g7.add(l22,0,2);
        PasswordField p1= new PasswordField();
        g7.add(p1,1,2);

        Button back= new Button("Back");
        g7.add(back,0,3);
        back.setOnAction(e->{
            Main m= new Main();
            try {
                m.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Button sb= new Button("Submit");
        g7.add(sb,1,3);

        sb.setOnAction(e->{
            Admin a1= new Admin();
            if (t1.getText().equals(String.valueOf(a1.getAdminid())) & p1.getText().equals(a1.getApassword()) ){
                admindets ad= new admindets();
                try {
                    ad.start(primaryStage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null,"Wrong ID/Password");
            }
        });
        primaryStage.setScene(adm);

    }
}
