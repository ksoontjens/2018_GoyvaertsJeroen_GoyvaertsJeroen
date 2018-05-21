package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;
/**
 *
 * @author student
 */
public class myComponent extends HComponent {
    
    Image schip;
    Image water;
    Image lost;
    Image victory;
    Image playAgain;
    public int sx=500, sy=250, ax=0, ly=-100, vy=-100, py=-100;
    public boolean displayPlayAgain = false;
    
    public myComponent(int x, int y, int b, int h){
        this.setBounds(x,y,x+b,y+h);
        MediaTracker mt = new MediaTracker(this);
        schip=this.getToolkit().getImage("boot.png");
        water=this.getToolkit().getImage("water2.jpg");
        lost=this.getToolkit().getImage("lost.png");
        victory=this.getToolkit().getImage("victory.png");
        playAgain=this.getToolkit().getImage("PlayAgain.png");
        mt.addImage(water, 0);
        mt.addImage(schip, 0);
        mt.addImage(lost, 0);
        mt.addImage(victory, 0);
        mt.addImage(playAgain, 0);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void paint(Graphics g){
    /*g.setColor(new DVBColor(10,10,10,100));
    g.fillRect(260, 270, 100, 70);
    g.setColor(new DVBColor(0,0,255,179));
    //g.setColor(Color.DARK_GRAY);
    g.fillRect(0,0,300,300);
    g.setColor(Color.YELLOW);
    g.drawOval(0,0,100,100);*/
    g.drawImage(water, ax -1600, 0, this);
    g.drawImage(water, ax, 0, this);
    g.drawImage(schip, sx, sy, this);
    g.drawImage(lost, 50, ly, this);
    g.drawImage(victory, 100, vy, this);
    g.drawImage(playAgain, 485, py, this);
}
}

