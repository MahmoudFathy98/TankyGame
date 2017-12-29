

package ch8threads;

import java.awt.Point;

/**
 *
 * @author MahmoudFathy
 */
public class Tank {
    public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket=new Bullet();
    
    public Point pos2=new Point();
    public String ImagePath2;
    public Bullet Rocket2=new Bullet();
    
    public int speed;
    public Tank (String ImagePath)
    {
        
        speed=5;
        this.ImagePath=ImagePath;
        Rocket.imgPath="d:\\rocket.gif";
        this.ImagePath2=ImagePath;
        Rocket2.imgPath2="d:\\rocket2.png";
        
    }

    void mover() {
        this.pos.x+=speed;
        this.pos2.x+=speed;
    }
      void movel() {
        this.pos.x-=speed;
        this.pos2.x-=speed;
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x+55;
        Rocket.pos.y=this.pos.y;
        Thread t1=new Thread (Rocket);
        t1.start();
         Rocket2.pos2.x=this.pos2.x+40;
        Rocket2.pos2.y=this.pos2.y;
        Thread t2=new Thread (Rocket2);
        t2.start();
    }
}
