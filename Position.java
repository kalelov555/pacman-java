package sample;

public class Position {
    private int x;    //column of the player in gridpane
    private int y;    //row in gridpane
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;      //returns col
    }

    public void setX(int x) {
        this.x = x;    //sets new column to the ball
    }

    public int getY() {
        return y;     //returns row
    }

    public void setY(int y) {
        this.y = y;     //sets new row to the ball
    }

    //equals method checks whether the two different objects stays at one positions
    //if yes returns  true; else returns false
    public boolean equals(Position position){
        if(this.x==position.getX() && this.y==position.getY()) return true;
        else return false;
    }
}
