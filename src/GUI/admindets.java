package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class admindets extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane g8= new GridPane();
        g8.setHgap(10);
        g8.setVgap(10);
        g8.setPadding(new Insets(25, 25, 25, 25));
        g8.setAlignment(Pos.TOP_CENTER);
        Scene vd= new Scene(g8,700,600);

        Button sr= new Button("1.View Customers Data");
        g8.add(sr,0,1);
        sr.setOnAction(e->
        {
          view v= new view();
            try {
                v.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button del= new Button("2.Delete Customers Data");
        g8.add(del,0,2);
        del.setOnAction(e->
        {
            delete delete= new delete();
            try {
                delete.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        Button mm= new Button("Main Menu");
        g8.add(mm,0,5);
        mm.setOnAction(e->{
            Main m= new Main();
            try {
                m.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        primaryStage.setScene(vd);
    }
}
