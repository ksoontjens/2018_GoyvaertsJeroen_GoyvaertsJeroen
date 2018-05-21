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
public class icebergTimerTask extends TimerTask{

    //referentie naar boot toevoegen
    public myComponent mc;
    public icebergComponent[] ic;
    public icebergDataClass[] icebergData;
    int time = 0;
    int icebergsPastBoat = 0;
    boolean hit = false;
    
    
    public void run() {

        for(int i = 0; i < ic.length; i++)
        {
            if(icebergData[i].StartTime == time || icebergData[i].IsMoving)
            {
                ic[i].sx++;
                if(icebergData[i].IsMoving == false)
                {
                    time = 0;
                }
                icebergData[i].IsMoving = true;
                if((ic[i].sx+100) >= mc.sx && ic[i].sx <= mc.sx+174)
                {   
                    if(ic[i].sy+66 >= mc.sy && ic[i].sy <= mc.sy+90)
                    {
                        //System.out.println("you lost");
                        hit = true;
                        resetGame();
                    }
                }
                if(ic[i].sx >= 733)
                {
                    if(ic[i].IsPastBoat == false)
                    {
                        icebergsPastBoat += 1;
                        ic[i].IsPastBoat = true;
                    }
  
                    //System.out.println(icebergsPastBoat);
                }
                if(icebergsPastBoat == ic.length && hit != true)
                {
                    //System.out.println("you won");
                    mc.vy = 230;
                    mc.py = 330;
                    mc.displayPlayAgain = true;
                }
                if(mc.ly == 230 && time >= 30)
                {
                    mc.ly = -100;
                }
            }
            ic[i].repaint();
        }
        time += 20;
        if(time >= 60001)
        {
            time = 0;
        }

    }
    
    public void resetGame()
    {
        if(hit == true)
        {
            mc.ly = 230;
            hit = false;
        }
        mc.vy = -100;
        mc.py = -100;
        mc.sy = 250;
        time = 0;
        icebergsPastBoat = 0;
        mc.displayPlayAgain = true;
        for(int i = 0; i < ic.length; i++)
        {
            icebergData[i].IsMoving = false;
            ic[i].IsPastBoat = false;
            ic[i].sx = -100;
        }
    }
    
}
