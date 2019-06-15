package sample;

import javafx.application.Platform;
import javafx.stage.Stage;


public class RestTask implements Runnable{
    public static long time = 0;

    Stage stage;

    public RestTask(Stage stage){
        this.stage = stage;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(45*60*1000);
            time = System.currentTimeMillis();
            Platform.runLater(()->{
                stage.setAlwaysOnTop(true);
                Clock.start();
                stage.show();
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
