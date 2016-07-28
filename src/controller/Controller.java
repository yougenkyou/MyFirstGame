package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

public class Controller {

    @FXML Pane mainScene;
    @FXML Shape player;
    @FXML Shape blackTreasure;
    @FXML Label score;



    private double positionX;
    private double positionY;

    @FXML
    public void initialize(){
        System.out.println(mainScene.getChildren().size());
    }

    public static int randomNumber(double from, double to) {
        return (int) (Math.random() * (to + 1 - from) + from);
    }

    public void startGame() {
        player.setLayoutX(randomNumber(0, 799.0));
        player.setLayoutY(randomNumber(0, 599.0));
        player.setVisible(true);
        }


    public void onMouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
            player.setLayoutX(mouseEvent.getSceneX());
            player.setLayoutY(mouseEvent.getSceneY());
            checkIntersections();
        }
    }

    public void moveOnKeyPressed(KeyEvent multipleEvent) {
        KeyCode keyPressed = multipleEvent.getCode();
        if (keyPressed == KeyCode.UP || keyPressed == KeyCode.W) {
            positionY = player.getLayoutY() - 10;
            player.setLayoutY(positionY);
            checkIntersections();
        } else if (keyPressed == KeyCode.DOWN || keyPressed == KeyCode.S) {
            positionY = player.getLayoutY() + 10;
            player.setLayoutY(positionY);
            checkIntersections();
        } else if (keyPressed == KeyCode.LEFT || keyPressed == KeyCode.A) {
            positionX = player.getLayoutX() - 10;
            player.setLayoutX(positionX);
            checkIntersections();
        } else if (keyPressed == KeyCode.RIGHT || keyPressed == KeyCode.D) {
            positionX = player.getLayoutX() + 10;
            player.setLayoutX(positionX);
            checkIntersections();
        }
    }

    private void checkIntersections() {
        List<Node> removableNodes = new ArrayList<>();
        for (Node gameObject: mainScene.getChildren()) {
            if (gameObject.getClass() == Circle.class && !Objects.equals(gameObject.getId(), "player")){
                Shape intersection = Circle.intersect(player, (Circle) gameObject);
                if (intersection.getBoundsInLocal().getWidth() != -1){
                    score.setText(String.valueOf(Integer.parseInt(score.getText()) + 1));
                    removableNodes.add(gameObject);
                }
            }
        }
        if(!removableNodes.isEmpty()){
            for (Node node : removableNodes) {
                mainScene.getChildren().remove(node);
            }
        }

    }
}



