import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

class OvalDraw extends Oval {
    public OvalDraw() {
        super(0,0,0,0);
    }

    public OvalDraw(int positionXIn, int positionYIn, int widthIn, int heightIn) {
        super(positionXIn, positionYIn, widthIn, heightIn);
    }

    public void paintComponent(Graphics g) {
        g.drawOval(getPositionX(), getPositionY(), getWidth(), getHeight());
    }
}
class SadCyclopsPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(100,100,80,120);

    }
}

public class FaceDrawLite {
    public static void main(String[]args) {
        System.out.println("FaceDrawLite...");

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame myFrame = new JFrame("Sad Cyclopse FaceDraw");
        myFrame.setBounds(100,100,600,400);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        SadCyclopsPanel mySadCyclopsPanel = new SadCyclopsPanel();
        myFrame.add(mySadCyclopsPanel);
        myFrame.setVisible(true);
    }
}