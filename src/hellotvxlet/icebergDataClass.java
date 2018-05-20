/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;
import java.awt.Image;

/**
 *
 * @author student
 */
public class icebergDataClass {
    public int StartTime = 0;
    public int StartY = 0;
    public boolean IsMoving = false;
    
    public icebergDataClass(int startTime, int startY, boolean isMoving)
    {
        StartTime = startTime;
        StartY = startY;
        IsMoving = isMoving;
    }
    
}
