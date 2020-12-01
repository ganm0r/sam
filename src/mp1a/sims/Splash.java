//for entry page. uses Swing, Multithreading

package mp1a.sims;

import java.awt.*;
import javax.swing.*;

class Splash 
{
    public static void main(String s[])
    {
        Frame fr = new Frame();
        fr.setVisible(true);
        fr.setLocation(400, 180);
        fr.setSize(1040, 760);
        try
        {
            Thread.sleep(10);
        }
        catch(Exception e)
        {
            
        }
    }
}

class Frame extends JFrame implements Runnable //opening frame contains only an image. this gets and sets the image in the frame
{
    Thread t1;
    Frame()
    {
        super("Student Attendance Management");
        setLayout(new FlowLayout()); 
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("Mp1a/Sims/Icons/Logo.png"));
        Image i1 = c1.getImage().getScaledInstance(1040, 700, Image.SCALE_DEFAULT);
        ImageIcon c2 = new ImageIcon(i1);

        JLabel m1 = new JLabel(c2);
        add(m1);
        t1 = new Thread(this);
        t1.start();
    }
    public void run()
    {
        try
        {   
            Thread.sleep(5000); //5 sec hold for opening frame
            this.setVisible(false);
            Login ln = new Login(); 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
