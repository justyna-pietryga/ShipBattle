import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShipController {
    ShipFrame theView;
    Game theModel;

    public ShipController(ShipFrame theView, Game theModel) {
        this.theView = theView;
        this.theModel = theModel;
        this.theView.addBoardFieldsListener(new BoardFieldsListener());
    }


    public void display()
    {
        for (int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                theView.getPanel().getBoardFields1()[i][j].setText(String.valueOf(theModel.getBoard1().getBoard()[i][j]));
            }
        }

        for (int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                theView.getPanel().getBoardFields2()[i][j].setText(String.valueOf(theModel.getBoard2().getBoard()[i][j]));
            }
        }
    }

    class BoardFieldsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String p=e.getActionCommand();
            String[] parts = p.split("-");
            //JButton[][] field;
            //Board board;

            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int whichBoard=Integer.parseInt(parts[2]);

            handleTheMove(x,y,whichBoard);


        }

        public void handleTheMove(int x, int y, int whichBoard){
            JButton[][] field;
            Board board;

            if(whichBoard==theModel.getTurn()) {
                if (whichBoard == 1) {
                    field = theView.getPanel().getBoardFields1();
                    board = theModel.getBoard1();
                } else {
                    field = theView.getPanel().getBoardFields2();
                    board = theModel.getBoard2();
                }


                if (!(field[x][y].getBackground().getRGB() == -2696737))
                    return;

                if (board.isHitOn(x, y)) {
                    theView.getPanel().setColor(field[x][y],Color.BLUE);
                    if (board.whichShip(x, y).isSunk(board)) {
                        //System.out.println("Zatopiony!");
                        setSunkShip(board, field);

                    }
                } else {
                    theView.getPanel().setColor(field[x][y],Color.RED);
                    theModel.nextTurn();
                }


            }
            else return;
        }

        public void setSunkShip(Board theBoard, JButton[][] field){
            //int [][] board=theModel.getBoard1().getBoard();
            int [][]  board=theBoard.getBoard();
            for(int i=0; i<board.length; i++){
                for (int j=0; j<board.length; j++){
                    if(board[i][j]==5 && field[i][j].getBackground().getRGB() != Color.decode("#FF9933").getRGB())
                        theView.getPanel().setColor(field[i][j],Color.decode("#FF9933"));

                    if(board[i][j]==6 && field[i][j].getBackground().getRGB() != Color.RED.getRGB())
                        theView.getPanel().setColor(field[i][j],Color.RED);
                }

            }
        }
    }


}
