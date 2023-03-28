package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Finalmenu extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane g6= new GridPane();
        g6.setHgap(10);
        g6.setVgap(10);
        g6.setPadding(new Insets(25, 25, 25, 25));
        Text tx= new Text("Thank you for your Purchase.");
        g6.add(tx,0,0);
        g6.setAlignment(Pos.TOP_CENTER);
        Scene finalm= new Scene(g6,700,600);

        Button menu = new Button("Main Menu");
        g6.add(menu,0,2);
        menu.setOnAction(e->{
            Main m= new Main();
            try {
                m.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        primaryStage.setScene(finalm);
    }
}
