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
        primaryStage.setTitle("Rest time");
        primaryStage.setScene(new Scene(root));

        RestTask restTask = new RestTask(primaryStage);
        threads.submit(restTask);
        primaryStage.setOnCloseRequest(Event->{
            if(System.currentTimeMillis() > RestTask.time + 300000){
                primaryStage.close();
                threads.submit(restTask);
            }else {
                System.out.println("please have a rest!");
                Event.consume();
            }
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
