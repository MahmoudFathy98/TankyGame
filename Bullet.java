package ch8threads;

import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MahmoudFathy
 */
public class Bullet implements Runnable{
    public Point pos=new Point();
    public Point pos2=new Point();
    public Color CurrentColor;
    public int Speed;
    public String imgPath;
    public String imgPath2;
    public Bullet()
    {
        Speed=1;
    }
    public  void  move()
    {
        pos.y-=Speed;
        pos2.y+=Speed;
    }

    @Override
    public void run() {
        for (int i=0;i<400;i++)
        {
            //System.out.println("Rocket Moving " +pos.y);
            move();
            try {
                Thread.sleep(8);
            } catch (InterruptedException ex) {
                
            }
            
        }
    }
}
