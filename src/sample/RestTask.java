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
            System.out.println(System.currentTimeMillis());
            Thread.sleep(45*60*1000);
            System.out.println(System.currentTimeMillis());
            time = System.currentTimeMillis();
            Platform.runLater(()->{
                stage.setAlwaysOnTop(true);
                stage.show();
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
