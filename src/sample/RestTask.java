package sample;

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
            stage.show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
