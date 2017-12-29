package ch8threads;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author MahmoudFathy
 */
public class Ch8Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame jf=new JFrame();
        jf.setSize(600, 600);
        
        
       // jf.pack();
        
        MovingBalls mb=new MovingBalls();
     
        jf.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1=new Thread(mb);
        t1.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);  
    }
    
}
