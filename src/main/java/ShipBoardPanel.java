import javax.swing.*;
import java.awt.*;

public class ShipBoardPanel extends JPanel{

    private JButton [][] boardFields1, boardFields2;
    private JLabel [] indexBoardVertical, indexBoardHorizontal;
    private GridBagConstraints c;
    private Dimension boardFieldSize;

    public ShipBoardPanel(){
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        boardFields1 = new JButton[10][10];
        boardFields2 = new JButton[10][10];
        boardFieldSize = new Dimension(40,40);
        indexBoardHorizontal = new JLabel[10];
        indexBoardVertical = new JLabel[10];

        createShipBoardFields(0,boardFields1);
        createIndexBoardFields(0);

        createIndexBoardFields(20);
        createShipBoardFields(20,boardFields2);


    }

    public void createShipBoardFields(int x,JButton [][] boardFields){
        for (int i=x; i<x+10; i++){
            for(int j=0; j<10;j++) {
                c.gridx = i + 1;
                c.gridy = j + 1;
                boardFields[i-x][j] = new JButton("");
                boardFields[i-x][j].setPreferredSize(boardFieldSize);
                add(boardFields[i-x][j],c);
            }
        }
    }

    public void createIndexBoardFields(int x){
        char sign='A';
        for (int i=x; i<x+10; i++){
            c.gridx=x;
            c.gridy=i-x+1;
            indexBoardVertical[i-x]=new JLabel(String.valueOf(i-x+1));
            indexBoardVertical[i-x].setHorizontalAlignment(SwingConstants.CENTER);
            indexBoardVertical[i-x].setPreferredSize(boardFieldSize);
            add(indexBoardVertical[i-x],c);

            c.gridy=0;
            c.gridx=i+1;
            indexBoardHorizontal[i-x]=new JLabel(String.valueOf(sign));
            indexBoardHorizontal[i-x].setHorizontalAlignment(SwingConstants.CENTER);
            indexBoardHorizontal[i-x].setPreferredSize(boardFieldSize);
            add(indexBoardHorizontal[i-x],c);
            sign++;
        }
    }

    public JButton[][] getBoardFields1() {
        return boardFields1;
    }

    public JButton[][] getBoardFields2() {
        return boardFields2;
    }

    public void setColor(JButton field, Color color){
        field.setBackground(color);
    }


}
