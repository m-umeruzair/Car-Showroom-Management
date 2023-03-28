package GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Toyota Showroom Management");
        GridPane grid= new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        FileInputStream inputstream = new FileInputStream("C:\\Users\\umeru\\IdeaProjects\\Car Showroom Management System\\images\\toyota.jpg");
        Image image = new Image(inputstream);
        ImageView imageView = new ImageView(image);
        imageView.setX(-10);
        imageView.setY(-10);
        imageView.setFitHeight(300);
        imageView.setFitWidth(600);
        imageView.setPreserveRatio(true);
        grid.add(imageView,0,0);

        Scene mainmenu= new Scene(grid,700,600);
        primaryStage.setScene(mainmenu);

        Text t1= new Text("Welcome to Toyota Showroom");
        t1.setFont(Font.font("Verdana", FontWeight.NORMAL,20));
        grid.add(t1,0,5);
        grid.setAlignment(Pos.TOP_CENTER);

        Button b1= new Button("Customer");
        grid.add(b1,0,6);
        b1.setOnAction(e->
        {
                carselection c11= new carselection();
            try {
                c11.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Button b2= new Button("Admin");
        grid.add(b2,0,7);
        primaryStage.show();
        b2.setOnAction(e->
        {
            adminpanel ad=new adminpanel();
            try {
                ad.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Button b3= new Button("Exit");
        grid.add(b3,0,10);
        b3.setOnAction(e-> Platform.exit()
        );
    }


    public static void main(String[] args)  {
        launch(args);
    }
}
