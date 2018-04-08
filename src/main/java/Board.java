import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private List<Ship> ships;
    private int [][] board; // 0- here a ship might be set ; 1- surrounding of ship ; 2- a ship ; 3-not hit on ; 4- hit on; 5-is sunk
    //6- surroundings of sunk ship

    public Board() {

        initializeStandardShipList();
        board = new int[10][10];
        randShipPositions();
    }


    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void setBoardValue(int x, int y, int value){
        board[x][y]=value;
    }

    public void initializeStandardShipList(){
        ships=new ArrayList<Ship>();
        for (int i=0; i<4; i++)
                ships.add(new Ship(1));
        for (int i=0; i<3;i++)
                ships.add(new Ship(2));
        for (int i=0; i<2; i++)
                ships.add(new Ship(3));
        ships.add(new Ship(4));

    }

    public void randShipPositions() {
        Random generator = new Random();
        int x,y, orientation;

        for (int i=0; i<ships.size(); i++){
            orientation=generator.nextInt(2);
            if(orientation==0)
            {
               do{
                   x=generator.nextInt(10);
                   y=generator.nextInt(10);
               }while(!tryHorizontally(x,y, ships.get(i).getLength()));
               ships.get(i).setX(x);
               ships.get(i).setY(y);
               ships.get(i).setOrientation(0);
            }
            else
            {
                do{
                    x=generator.nextInt(10);
                    y=generator.nextInt(10);
                }while(!tryVertically(x,y, ships.get(i).getLength()));
                ships.get(i).setX(x);
                ships.get(i).setY(y);
                ships.get(i).setOrientation(1);
            }

        }
    }

    public boolean tryHorizontally(int x, int y, int length){
        //check if putting a ship is possible in this place

            for (int i = 0; i < length; i++) {
                try {
                    if (board[x + i][y] != 0)
                        return false;
                }catch (Exception e){
                    return false;
                }
            }

            //marking the surroundings
            for (int i = -1; i <= length; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (x + i < board.length && x + i >= 0 && y + j < board.length && y + j >= 0){
                        board[x + i][y + j] = 1;
                    }

                }
            }

            //marking the ship
            for (int i = 0; i < length; i++) {
                board[x + i][y] = 2;
            }

        return true;
    }

    public boolean tryVertically(int x, int y, int length){
        //check if putting a ship is possible in this place

            for (int i = 0; i < length; i++) {
                try {
                    if (board[x][y + i] != 0)
                        return false;
                }catch (Exception e){
                    return false;
                }
            }

            //marking the surroundings

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= length; j++)
                    if (x + i < board.length && x + i >= 0 && y + j < board.length && y + j >= 0)
                        board[x + i][y + j] = 1;
            }

            //marking the ship
            for (int i = 0; i < length; i++) {
                board[x][y + i] = 2;
            }

        return true;
    }


    public boolean isHitOn(int x, int y){
        if(board[x][y] == 2) {
            board[x][y] = 4;
            return true;
        }
        else {
            board[x][y] = 3;
            return false;
        }
    }

    public Ship whichShip(int x, int y){
        for (int i=0; i<ships.size(); i++){
            if(ships.get(i).isThisShip(x,y)) return ships.get(i);
        }
        return null;
    }
}
