package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ClockAnimate {
    public static void start(Stage primaryStage){
//        ClockPane clock = new ClockPane();
//        BorderPane borderPane=new BorderPane();
//
//        EventHandler<ActionEvent> eventHandler= e -> {
//            clock.setCurrentTime();
//            String timeString=clock.getHour()+":"+clock.getMinute()+":"+clock.getSecond();
//            Label lblCurrentTime=new Label(timeString);
//            borderPane.setCenter(clock);
//            borderPane.setBottom(lblCurrentTime);
//            BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
//        };
//
//        Timeline animation=new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));
//        animation.setCycleCount(Timeline.INDEFINITE);
//        animation.play();
//
//        Scene scene=new Scene(borderPane,250,250);
//        primaryStage.setTitle("ClockAnimation");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        borderPane.widthProperty().addListener(ov ->
//                clock.setW(borderPane.getWidth())
//        );
//
//        borderPane.heightProperty().addListener(ov ->
//                clock.setH(borderPane.getHeight())
//        );
    }
}
