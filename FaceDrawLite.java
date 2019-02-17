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
        System.out.format("OvalDraw.paintComponent(x=%d, y=%d, w=%d, h=%d)\n",
            getPositionX(), getPositionY(), getWidth(), getHeight());
    }
}

class SadCyclopseFace extends OvalDraw {
    private OvalDraw eye;

    public SadCyclopseFace() {
        super(0,0,0,0);
        eye = new OvalDraw(10,10,100,100);    
    }

    public SadCyclopseFace(int positionXIn, int positionYIn, int widthIn, int heightIn) {
        super(positionXIn, positionYIn, widthIn, heightIn);
        eye = new OvalDraw(10,10,100,100); 
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        eye.paintComponent(g);

    } 
}


class SadCyclopsPanel extends JPanel {
    private OvalDraw myOvalDraw;
    private SadCyclopseFace mySadCyclopsFace;

    public SadCyclopsPanel() {
        myOvalDraw = new OvalDraw(200,200,160,240);
        mySadCyclopsFace = new SadCyclopseFace(100,100,80,160);

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        myOvalDraw.paintComponent(g);
        mySadCyclopsFace.paintComponent(g);


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