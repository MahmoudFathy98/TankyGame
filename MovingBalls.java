

package ch8threads;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
/**
 *
 * @author MahmoudFathy
 */
public class MovingBalls extends JPanel implements Runnable{
   boolean b = true;
   public Tank BlueTank=new Tank("d:\\TankBlueS.jpg");
   public Tank BlueTank2=new Tank("d:\\Tank1.png");
    public MovingBalls()
    {
        setSize(600,600);
        //setBackground(Color.red);
       // setLayout(new BorderLayout())
        BlueTank.pos.x=220;
        BlueTank.pos.y=340;
        BlueTank2.pos2.x=220;
        BlueTank2.pos2.y=10;
        this.addKeyListener(new keylist());
        
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("Test");
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                BlueTank.mover();
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                BlueTank.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_D)
            {
                BlueTank2.mover();
            }
            if (e.getKeyCode()==KeyEvent.VK_A)
            {
                BlueTank2.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                BlueTank.fireBullet();
            }
            if (e.getKeyCode()==KeyEvent.VK_F)
            {
                BlueTank2.fireBullet();
            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
        
        try
        {
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        
        BufferedImage imgtank2 = ImageIO.read(new File(BlueTank2.ImagePath2));
        BufferedImage imgrocket2 = ImageIO.read(new File(BlueTank2.Rocket2.imgPath2));
        g.drawImage(imgtank2, BlueTank2.pos2.x, BlueTank2.pos2.y,null);
        g.drawImage(imgrocket2, BlueTank2.Rocket2.pos2.x, BlueTank2.Rocket2.pos2.y,null);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
       
        if (BlueTank.Rocket.pos.distance(BlueTank2.pos2.x,BlueTank2.pos2.y)<=73)
            {
                b=false;
              JOptionPane.showMessageDialog(null, "Player1 wins!!!", "WINNER!", JOptionPane.INFORMATION_MESSAGE);
              
              System.exit(0);    
            }
        
        if (BlueTank2.Rocket2.pos2.distance(BlueTank.pos.x,BlueTank.pos.y)<=73)
            {
                 b=false;
              JOptionPane.showMessageDialog(null, "Player2 Wins!!!", "WINNER!", JOptionPane.INFORMATION_MESSAGE);
             
              System.exit(0);
            }
    }
    
    public void run() {
    while(b)
    {
        repaint();
    }
    }
    
    }
    

