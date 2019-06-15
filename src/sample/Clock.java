package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Clock{
    private static Timeline animation=new Timeline(new KeyFrame(Duration.millis(1000),
            Event -> paintClock()));

    private static int time = -1;
    private static double centerX;
    private static double centerY;
    private static double LineLength = 155;
    private static Line line;
    private static Controller controller;

    public static void init(Controller C) {
        controller = C;
        animation.setCycleCount(Timeline.INDEFINITE);

        line = controller.getTimeLine();
        centerX = line.getStartX();
        centerY = line.getStartY();

        paintClock();
    }

    public static void start(){
        animation.play();
    }

    public static void end(){
        time = -1;
        animation.stop();
    }

    protected static void paintClock() {
        time ++;
        double X = centerX + LineLength * Math.sin(time * (2 * Math.PI / 300));
        double Y = centerY - LineLength * Math.cos(time * (2 * Math.PI / 300));
        line.setEndX(X);
        line.setEndY(Y);
    }
}
