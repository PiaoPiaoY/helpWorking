package sample;

import javafx.application.Application;
import javafx.application.Platform;
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene=new Scene(root);
        primaryStage.setTitle("Rest time");
        primaryStage.setScene(scene);

        Controller controller = fxmlLoader.getController();
        controller.init();
        Platform.setImplicitExit(false);

        RestTask restTask = new RestTask(primaryStage);
        threads.submit(restTask);
        primaryStage.setOnCloseRequest(Event->{
            if(System.currentTimeMillis() > RestTask.time + 300000){
                Clock.end();
                threads.submit(restTask);
            }else {
                Event.consume();
            }
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
