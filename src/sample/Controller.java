package sample;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Shape;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    Shape circle;

    private double positionX;
    private double positionY;

    public static int randomNumber(double from, double to) {
        return (int) (Math.random() * (to + 1 - from) + from);
    }

    public void startGame(){
        circle.setLayoutX(randomNumber(0, 799.0));
        circle.setLayoutY(randomNumber(0, 599.0));
        circle.setVisible(true);
    }

    public void onMouseClicked(MouseEvent mouseEvent){
       if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
           circle.setLayoutX(mouseEvent.getSceneX());
           circle.setLayoutY(mouseEvent.getSceneY());
       }
    }

    public void moveOnKeyPressed(KeyEvent multipleEvent){
        KeyCode keyPressed = multipleEvent.getCode();
        if (keyPressed == KeyCode.UP || keyPressed == KeyCode.W){
            positionY = circle.getLayoutY() - 10;
            circle.setLayoutY(positionY);
        }else if (keyPressed == KeyCode.DOWN || keyPressed == KeyCode.S){
            positionY = circle.getLayoutY() + 10;
            circle.setLayoutY(positionY);
        } else if (keyPressed == KeyCode.LEFT || keyPressed == KeyCode.A){
            positionX = circle.getLayoutX() - 10;
            circle.setLayoutX(positionX);
        } else if (keyPressed == KeyCode.RIGHT || keyPressed == KeyCode.D){
            positionX = circle.getLayoutX() + 10;
            circle.setLayoutX(positionX);
        }
    }
}
