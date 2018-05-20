/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.TimerTask;

/**
 *
 * @author student
 */
public class myTimerTask extends TimerTask{

    public myComponent mc;
    
    public void run() {
        mc.ax++;
        if(mc.ax>=1600){
        mc.ax = 0;
        }
        mc.repaint();
    }

}
