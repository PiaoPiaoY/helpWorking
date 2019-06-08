package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main extends Application {
    public static ExecutorService threads = Executors.newFixedThreadPool(1);

    @Override
    public void start(Stage primaryStage) throws Exception{
        ClockPane clock = new ClockPane();
        BorderPane borderPane=new BorderPane();

        EventHandler<ActionEvent> eventHandler = e -> {
            clock.setCurrentTime();
            String timeString=clock.getHour()+":"+clock.getMinute()+":"+clock.getSecond();
            Label lblCurrentTime=new Label(timeString);
            borderPane.setCenter(clock);
            borderPane.setBottom(lblCurrentTime);
            BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
        };

        Timeline animation=new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene=new Scene(borderPane,250,250);
        primaryStage.setTitle("ClockAnimation");
        primaryStage.setScene(scene);
        primaryStage.show();

        borderPane.widthProperty().addListener(ov ->
                clock.setW(borderPane.getWidth())
        );

        borderPane.heightProperty().addListener(ov ->
                clock.setH(borderPane.getHeight())
        );

        RestTask restTask = new RestTask(primaryStage);
        threads.submit(restTask);
//        primaryStage.setOnCloseRequest(Event->{
//            if(System.currentTimeMillis() > RestTask.time + 300000){
//                primaryStage.close();
//                threads.submit(restTask);
//            }else {
//                System.out.println("please have a rest!");
//                Event.consume();
//            }
//        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
