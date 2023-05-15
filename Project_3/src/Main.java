import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    static Stage primaryStage;
    static TawjihiDS tawjihiDS = new TawjihiDS();
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Interface ui = new Interface();
        primaryStage.setTitle("Tawjihi Records Search Tool");
        primaryStage.setScene(Interface.scene);
        primaryStage.show();
    }
}