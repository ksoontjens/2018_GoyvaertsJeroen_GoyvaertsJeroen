package hellotvxlet;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet, UserEventListener{
    
    myComponent mc;
    icebergComponent[] ic = new icebergComponent[21];
            
    public void startXlet() throws XletStateChangeException {
        HScene scene=HSceneFactory.getInstance().getDefaultHScene();
        
        icebergDataClass[] icebergData = new icebergDataClass[21];
    
        icebergData[0]  = new icebergDataClass(3500,  264,   false);
        icebergData[1]  = new icebergDataClass(2500,  264,   false);
        icebergData[2]  = new icebergDataClass(3500,  66,    false);
        icebergData[3]  = new icebergDataClass(3500,  462,   false);
        icebergData[4]  = new icebergDataClass(3500,  66,    false);
        icebergData[5]  = new icebergDataClass(3500,  396,   false);
        icebergData[6]  = new icebergDataClass(3500,  132,   false);
        icebergData[7]  = new icebergDataClass(3500,  462,   false);
        icebergData[8]  = new icebergDataClass(2000,  198,   false);
        icebergData[9]  = new icebergDataClass(3500,  264,   false);
        icebergData[10] = new icebergDataClass(2500,  396,   false);
        icebergData[11] = new icebergDataClass(3500,  198,   false);
        icebergData[12] = new icebergDataClass(3500,  0,     false);
        icebergData[13] = new icebergDataClass(2000,  66,    false);
        icebergData[14] = new icebergDataClass(3500,  462,   false);
        icebergData[15] = new icebergDataClass(2500,  198,   false);
        icebergData[16] = new icebergDataClass(2000,  462,   false);
        icebergData[17] = new icebergDataClass(3500,  264,   false);
        icebergData[18] = new icebergDataClass(2500,  396,   false);
        icebergData[19] = new icebergDataClass(3500,  198,   false);
        icebergData[20] = new icebergDataClass(3500,  462,   false);
        
        
        mc = new myComponent(0,0,720,576);
        for(int i=0; i<ic.length;i++)
        {
            ic[i] = new icebergComponent(0,0,720,576);
            ic[i].sy = icebergData[i].StartY;
            scene.add(ic[i]);
        }
        
        scene.add(mc);
        //mc.setBounds(200,200,400,400);
        
        scene.validate();
        scene.setVisible(true);
        
        UserEventRepository repo = new UserEventRepository("naam");
        repo.addAllArrowKeys();
        
        EventManager manager = EventManager.getInstance();
        manager.addUserEventListener(this, repo);
        
        myTimerTask mtt = new myTimerTask();
        icebergTimerTask itt = new icebergTimerTask();
        mtt.mc=mc;
        itt.mc=mc;
        itt.ic=ic;
        itt.icebergData=icebergData;
        Timer t = new Timer();
        t.scheduleAtFixedRate(mtt, 0, 20);
        t.scheduleAtFixedRate(itt, 0, 20);
    }

    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
    }

    public void pauseXlet() {
       
    }

    public void userEventReceived(UserEvent e) {
        System.out.println(e.getCode());
        //System.out.println("boat y pos: " + mc.sy);
        if(e.getType()==HRcEvent.KEY_PRESSED){
            if(e.getCode()==HRcEvent.VK_UP){
                mc.sy-=10;
                if(mc.sy<0)
                {
                    mc.sy = 0;
                }
                mc.repaint();
            }
            if(e.getCode()==HRcEvent.VK_DOWN){
                mc.sy+=10;
                if(mc.sy>486)
                {
                    mc.sy = 486;
                    //System.out.println("lol " + mc.sy);
                }
                mc.repaint();
            }
        }
    }

    
    

  
}