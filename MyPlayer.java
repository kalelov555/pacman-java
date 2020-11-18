package sample;

import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.swing.*;

public class MyPlayer implements Player{
    private Circle ball;        //player
    private Map map;          //our map(pane)
    private Position position;      //pos


    public MyPlayer(Map map){           //in this constructor we create our player and initialize it on the map
        this.map=map;
        this.position=map.getStartPosition();
        ball=new Circle();
        ball.setRadius(12.0);ball.setFill(Color.RED);ball.setStrokeWidth(0.1);
        for(int i=0; i<map.getSize(); i++){
            for(int j=0; j<map.getSize(); j++) {
                if (map.getValue(i,j)==2){
                    ball.setCenterX(i*30+15);ball.setCenterY(j*30+15);
                    map.getChildren().add(ball);
                }
            }
        }

    }


    //moves the ball to the right and checks whether the ball can move to the specific position
    //for ex, player cannot move through block(black rect) or cannot go out of the map
    //so in this move methods we are checking and doing all of this things
    @Override
    public void moveRight() {
        position.setX((position.getX() + 1));
        if(position.getX()<map.getSize() && position.getX()>=0){
            if (map.getValue(position.getY(), position.getX()) == 1) {
                position.setX((position.getX() - 1));
            }
            else ball.setCenterX(ball.getCenterX() + 31);
        }

        else {position.setX((position.getX() - 1));
        System.out.println("Invalid Postion!");}

    }

    @Override
    public void moveLeft() {
        position.setX(position.getX()-1);
        if(position.getX()<map.getSize() && position.getX()>=0){
            if (map.getValue(position.getY(), position.getX()) == 1 ) {
                position.setX((position.getX() + 1));
        }
            else ball.setCenterX(ball.getCenterX() - 31);
        }

        else {position.setX((position.getX() + 1));
        System.out.println("Invalid Postion!");}

    }

    @Override
    public void moveDown() {
        position.setY(position.getY()+1);
        if(position.getY()<map.getSize() && position.getY()>=0){
            if (map.getValue(position.getY(), position.getX()) == 1) {
                position.setY((position.getY() - 1));
            }
            else ball.setCenterY(ball.getCenterY() + 31);
        }
        else {position.setY((position.getY() - 1));
        System.out.println("Invalid Postion!");}

    }

    @Override
    public void moveUp() {
        position.setY(position.getY()-1);
        if(position.getY()<map.getSize() && position.getY()>=0){
            if (map.getValue(position.getY(), position.getX()) == 1) {
                position.setY((position.getY() + 1));
            }
            else ball.setCenterY(ball.getCenterY() - 31);
        }
        else {position.setY((position.getY() + 1));
        System.out.println("Invalid Postion!");}


    }



    @Override
    public Position getPosition() {
        return position;
    }
}
