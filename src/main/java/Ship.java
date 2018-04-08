import java.util.ArrayList;

public class Ship {

    private int length;
    private int x,y;
    private int orientation;


    public Ship(int length) {
        this.length = length;
    }

    public Ship(int length, int x, int y) {
        this.length = length;
        this.x = x;
        this.y = y;
    }


    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isSunk(Board board){
        for(int i=0; i<length; i++){
            if(orientation==0) {
                if (board.getBoard()[x + i][y] != 4) return false;
            }
            else {
                if (board.getBoard()[x][y + i] != 4) return false;
            }

        }

        //marking sunk ship and surroundings of this ship
            if(orientation==0) {

                for (int k = -1; k <= length; k++) {
                    for (int j = -1; j <= 1; j++) {
                        if (x + k < board.getBoard().length && x + k >= 0 && y + j < board.getBoard().length && y + j >= 0){
                            board.setBoardValue(x+k, y+j, 6);
                        }
                    }
                }

                for(int i=0; i<length; i++)
                    board.setBoardValue(x+i, y, 5);
            }

            else {

                for (int k = -1; k <= 1; k++) {
                    for (int j = -1; j <= length; j++)
                        if (x + k < board.getBoard().length && x + k >= 0 && y + j < board.getBoard().length && y + j >= 0){
                            board.setBoardValue(x+k, y+j, 6);
                        }
                }

                for(int i=0; i<length; i++)
                    board.setBoardValue(x, y+i, 5);

            }





        return true;
    }

    public boolean isThisShip(int x, int y){
        if(orientation==0){
            for (int i=0; i<length; i++){
                if(this.x+i==x && this.y==y) return true;
            }
        }

        else {
            for (int i=0; i<length; i++){
                if(this.x==x && this.y+i==y) return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "length=" + length +
                ", x=" + x +
                ", y=" + y +
                ", orientation=" + orientation +
                '}';
    }
}
