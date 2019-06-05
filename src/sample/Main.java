package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main extends Application {
    public static ExecutorService threads = Executors.newFixedThreadPool(1);

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));

        RestTask restTask = new RestTask(primaryStage);

        primaryStage.setOnCloseRequest(Event->{
            if(System.currentTimeMillis() > RestTask.time + 300000){
                primaryStage.close();
                threads.submit(restTask);
            }
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
