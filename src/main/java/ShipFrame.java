import javax.swing.*;
import java.awt.event.ActionListener;

public class ShipFrame extends  JFrame {
    ShipBoardPanel panel;

   /* public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShipFrame frame = new ShipFrame();

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    } */

    public ShipBoardPanel getPanel() {
        return panel;
    }

    public ShipFrame(String title){
        setTitle(title);
       // JFrame frame = new JFrame("Ship Battle");
        panel = new ShipBoardPanel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panel);
        pack();
        //frame.setVisible(true);

        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }



       // frame.setResizable(false);
    }

    void addBoardFieldsListener(ActionListener listenForBoardFieldsButton){
        JButton[][] boardFields1=panel.getBoardFields1();
        JButton[][] boardFields2=panel.getBoardFields2();
        for(int i=0; i<boardFields1.length; i++){
            for(int j=0; j<boardFields1.length; j++){
                boardFields1[i][j].setActionCommand(i+"-"+j+"-"+1);
                boardFields1[i][j].addActionListener(listenForBoardFieldsButton);
                boardFields2[i][j].setActionCommand(i+"-"+j+"-"+2);
                boardFields2[i][j].addActionListener(listenForBoardFieldsButton);
            }
        }


    }

}
