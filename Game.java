package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;

import static javafx.scene.input.KeyCode.*;


public class Game extends Application {
    private Map map;
    private MyPlayer player;
    private Food food;

    @Override
    public void start(Stage primaryStage) throws Exception {
        map = new Map("map1.txt");
        player = new MyPlayer(map);
        food = new Food(map, player);
        Scene scene = new Scene(map, 400,300);

        //this event handler method allows player to move any direction applying methods from Map class
                    scene.setOnKeyPressed(e -> {
                            switch (e.getCode()) {
                                case UP:
                                    player.moveUp();
                                    break;
                                case DOWN:
                                    player.moveDown();
                                    break;
                                case LEFT:
                                    player.moveLeft();
                                    break;
                                case RIGHT:
                                    player.moveRight();
                                    break;
                            }
                        });

                    primaryStage.setTitle("Game");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    map.requestFocus();
}
}
