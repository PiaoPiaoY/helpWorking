package sample;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Controller {
    @FXML
    private Circle clock;

    @FXML
    private Line timeLine;

    void init(){
        Clock.init(this);
    }

    public Circle getClock() {
        return clock;
    }

    public Line getTimeLine() {
        return timeLine;
    }
}
