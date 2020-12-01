package mp1a.sims;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class AddFaculty implements ActionListener
{
    JFrame f;
    JLabel l1, l2, l3, l4, im;
    JComboBox cb;
    JTextField t1, t2, t3;
    JButton b1, b2;

    public AddFaculty()
    {
        f = new JFrame("Master - New Faculty");
        f.setLayout(null);

        im = new JLabel();
        im.setBounds(0, 0, 1040, 760);
        im.setLayout(null);

        //header
        l1 = new JLabel("Fill Faculty Details");
        l1.setBounds(370, 130, 500, 50);
        l1.setFont(new Font("monospaced", Font.BOLD, 25));
        l1.setForeground(Color.BLACK);
        im.add(l1);
        f.add(im);

        //name i/p
        l2 = new JLabel("Name");
        l2.setForeground(Color.BLACK);
        l2.setBounds(150, 250, 100, 30);
        l2.setFont(new Font("monospaced", Font.BOLD, 20));
        im.add(l2);

        t1 = new JTextField();
        t1.setBounds(300, 250, 150, 30);
        im.add(t1);

        //email id i/p
        l3 = new JLabel("Email ID");
        l3.setForeground(Color.BLACK);
        l3.setBounds(150, 350, 100, 30);
        l3.setFont(new Font("monospaced", Font.BOLD, 20));
        im.add(l3);

        t3 = new JTextField();
        t3.setBounds(300, 350, 150, 30);
        im.add(t3);

        //department
        l4 = new JLabel("Department");
        l4.setForeground(Color.BLACK);
        l4.setBounds(500, 350, 150, 30);
        l4.setFont(new Font("monospaced", Font.BOLD, 20));
        im.add(l4);

        String branch[] = {"COMPS", "IT", "EXTC"};
        cb = new JComboBox(branch);
        cb.setBackground(Color.WHITE);
        cb.setBounds(700, 350, 150, 30);
        im.add(cb);

        //emp id i/p
        l3 = new JLabel("EMP ID");
        l3.setForeground(Color.BLACK);
        l3.setBounds(500, 250, 100, 30);
        l3.setFont(new Font("monospaced", Font.BOLD, 20));
        im.add(l3);

        t2 = new JTextField();
        t2.setBounds(700, 250, 150, 30);
        im.add(t2);

        //submit button
        b1 = new JButton("Add");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(300, 550, 150, 30);
        im.add(b1);
        b1.addActionListener(this);

        //cancel button
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(550, 550, 150, 30);
        im.add(b2);
        b2.addActionListener(this);

        f.setVisible(true);
        f.setSize(1040, 760);
        f.setLocation(400, 180);
    }

    public void actionPerformed(ActionEvent ae)
    {   
        String s1 = t1.getText(); //Name
        String s2 = t2.getText(); //Emp ID
        String s3 = t3.getText(); //Email ID
        String s4 = (String)cb.getSelectedItem(); // Department

        if(ae.getSource() == b1)
        {
            try
            {
                conn co = new conn();
                String q = "insert into faculty values('"+s2+"','"+s1+"','"+s4+"','"+s3+"')";
                co.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "New Faculty Added");
                f.setVisible(false);
            }
            catch(Exception e)
            {
                System.out.println("Error: "+e);
            }
        }
        else if(ae.getSource() == b2)
        {
            f.setVisible(false);
            new Project();
        }
    }

    public static void main(String[] arg)
    {
        new AddFaculty().f.setVisible(true);
    }
}