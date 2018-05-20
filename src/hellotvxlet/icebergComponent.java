package hellotvxlet;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

//21
/**
 *
 * @author student
 */
public class icebergComponent extends HComponent {
    
    Image iceberg;
    
    public boolean IsPastBoat = false;

    public int sx=-100, sy=264;
    
    public icebergComponent(int x, int y, int b, int h){
        this.setBounds(x,y,x+b,y+h);
        MediaTracker mt = new MediaTracker(this);
        iceberg=this.getToolkit().getImage("ijsberg.png");
        mt.addImage(iceberg, 0);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void paint(Graphics g){
    g.drawImage(iceberg, sx, sy, this);
}
}

