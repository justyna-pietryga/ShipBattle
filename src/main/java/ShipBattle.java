import java.awt.*;

public class ShipBattle {

    public static void main(String[] args) {
       // Board theModel = new Board(new User("Player 1"));
        Game theModel = new Game(new User("Player1"), new User("Player2"), new Board(), new Board());
        ShipFrame theView = new ShipFrame("Ship Battle");
        ShipController theController = new ShipController(theView,theModel);
        theView.setVisible(true);


    }
}
