package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Map extends Pane {
    private int unit=30;   //size of one cell in map
    private int size;    //size of the map
    private int[][] map;    //position of the ball on the map
    private Position start;    //initial position of the ball

    public Map(String file) throws Exception {
        File fileRead = new File(file);                                //by reading from file we construct our map
        Scanner in = new Scanner(fileRead);
        size = in.nextInt();
        map = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                map[i][j] = in.nextInt();
            }
        }

        for(int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                if(map[i][j]==2){
                    start=new Position(i, j);           //we obtain initial position of the ball(player)
                }
            }

        }
        GridPane pane = new GridPane();     //after creating gridpane until the end of the constructor we are drawing the map by creating rectangles
        for(int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 0 || map[i][j] == 2) {
                    Rectangle r1 = new Rectangle();
                    r1.setWidth(unit); r1.setHeight(unit); r1.setFill(Color.WHITE); r1.setStrokeWidth(1); r1.setStroke(Color.BLACK);
                    pane.add(r1, j, i);
                } else if (map[i][j] == 1) {
                    Rectangle r2 = new Rectangle();
                    r2.setWidth(unit); r2.setHeight(unit); r2.setFill(Color.BLACK); r2.setStrokeWidth(1); r2.setStroke(Color.BLACK);
                    pane.add(r2, j, i);
                }
            }
        }
        getChildren().add(pane);
    }

    //returns size of one rectangle in map
    public int getUnit(){
        return unit;
    }

    //returns size of the map eg 8/8
    public int getSize() {
        return size;
    }

    //returns the position of the on the gridpane
    public int getValue(int row, int column) {
        return map[row][column];
    }

    //returns initial position of the ball
    public Position getStartPosition(){
        return start;
        }
    }



