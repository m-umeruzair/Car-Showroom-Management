package GUI;

import classes.Car;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileInputStream;

public class carselection extends Application {


    @Override
    public void start(Stage primaryStage)throws Exception {


        GridPane g2= new GridPane();
        g2.setAlignment(Pos.CENTER);
        g2.setHgap(10);
        g2.setVgap(10);

        FileInputStream inputstream = new FileInputStream("C:\\Users\\umeru\\IdeaProjects\\Car Showroom Management System\\images\\t1.jpg");
        Image image = new Image(inputstream);
        ImageView imageView = new ImageView(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitHeight(450);
        imageView.setFitWidth(1400);
        imageView.setPreserveRatio(true);
        g2.add(imageView,1,8);

        Scene selection= new Scene(g2,900,800);
        g2.setAlignment(Pos.TOP_CENTER);
        Text t2= new Text("Car Selection");
        t2.setTextAlignment(TextAlignment.CENTER);
        g2.add(t2,0,0);

        Label c1= new Label("Car Model:");
        g2.add(c1,0,1);

        String[] carmodel= {"Sequoia","Land Cruiser","Fortuner","Camry","Corolla","Yaris"};
        String [] cr1= new String[1];
        ChoiceBox cb1= new ChoiceBox(FXCollections.observableArrayList(carmodel));
            cb1.getSelectionModel().selectedIndexProperty().addListener((observableValue, oldValue, newValue) ->
                cr1[0]= carmodel[newValue.intValue()]);
        g2.add(cb1,1,1);

        Label c2= new Label("Car Variant");
        g2.add(c2,0,2);

        String[] carvariant= {"Automatic", "Manual"};
        String [] cr2= new String[1];
        ChoiceBox cb2= new ChoiceBox(FXCollections.observableArrayList(carvariant));
        cb2.getSelectionModel().selectedIndexProperty().addListener((observableValue, oldValue, newValue) ->
                cr2[0]= carvariant[newValue.intValue()]);
        g2.add(cb2,1,2);

        Label c3= new Label("Car Color:");
        g2.add(c3,0,3);

        String[] carcolour= {"Platinum White","Dark Blue Mica","Attitude Black","Metallic Grey","Graphite Metallic"};
        String [] cr3= new String[1];
        ChoiceBox cb3= new ChoiceBox(FXCollections.observableArrayList(carcolour));
        cb3.getSelectionModel().selectedIndexProperty().addListener((observableValue, oldValue, newValue) ->
                cr3[0]= carcolour[newValue.intValue()]);
        g2.add(cb3,1,3);

        Button back= new Button("Back");
        g2.add(back,1,4);
        back.setOnAction(e->{
            Main main= new Main();
            try {
                main.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Button next= new Button("Next");
        g2.add(next,2,4);

        next.setOnAction(e->
        {
            try {
                Car car = Car.getInstance();
                car.setCarname(cb1.getValue().toString());
                car.setCarvariant(cb2.getValue().toString());
                car.setcarcolour(cb3.getValue().toString());
                if (cb1.getValue().toString().equals("Sequoia") & cb2.getValue().toString().equals("Automatic")) {
                    car.setCarprice(100000);
                } else if (cb1.getValue().toString().equals("Sequoia") & cb2.getValue().toString().equals("Manual")) {
                    car.setCarprice(95000);
                } else if (cb1.getValue().toString().equals("Land Cruiser") & cb2.getValue().toString().equals("Automatic")) {
                    car.setCarprice(90000);
                } else if (cb1.getValue().toString().equals("Land Cruiser") & cb2.getValue().toString().equals("Manual")) {
                    car.setCarprice(85000);
                } else if (cb1.getValue().toString().equals("Fortuner") & cb2.getValue().toString().equals("Automatic")) {
                    car.setCarprice(80000);
                } else if (cb1.getValue().toString().equals("Fortuner") & cb2.getValue().toString().equals("Manual")) {
                    car.setCarprice(75000);
                } else if (cb1.getValue().toString().equals("Camry") & cb2.getValue().toString().equals("Automatic")) {
                    car.setCarprice(68000);
                } else if (cb1.getValue().toString().equals("Camry") & cb2.getValue().toString().equals("Manual")) {
                    car.setCarprice(65000);
                } else if (cb1.getValue().toString().equals("Corolla") & cb2.getValue().toString().equals("Automatic")) {
                    car.setCarprice(60000);
                } else if (cb1.getValue().toString().equals("Corolla") & cb2.getValue().toString().equals("Manual")) {
                    car.setCarprice(55000);
                } else if (cb1.getValue().toString().equals("Yaris") & cb2.getValue().toString().equals("Automatic")) {
                    car.setCarprice(50000);
                } else if (cb1.getValue().toString().equals("Yaris") & cb2.getValue().toString().equals("Manual")) {
                    car.setCarprice(45000);
                }

                customerinput c = new customerinput();
                c.start(primaryStage);
            }catch (NullPointerException e1){
                JOptionPane.showMessageDialog(null,"Please Don't leave the fields empty");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        primaryStage.setScene(selection);



    }
}
