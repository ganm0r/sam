package mp1a.sims;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FacultyAttendance extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, im, l4;
    JTextField t1, t2;
    JButton b1, b2;
    Choice ch;
    JComboBox cb1, cb2;

    public FacultyAttendance()
    {
        super("Attendance - Faculty Attendance");
        setSize(1040, 760);
        setLocation(400, 180);
        setLayout(null);

        im = new JLabel();
        im.setBounds(0, 0, 1040, 760);
        im.setLayout(null);

        l1 = new JLabel("Mark Faculty Attendance");
        l1.setBounds(370, 130, 500, 50);
        l1.setFont(new Font("monospaced", Font.BOLD, 25));
        l1.setForeground(Color.BLACK);
        im.add(l1);


        l3 = new JLabel("EMP ID");
        l3.setForeground(Color.BLACK);
        l3.setBounds(350, 250, 100, 30);
        l3.setFont(new Font("monospaced", Font.BOLD, 20));
        im.add(l3);
        
        ch = new Choice();
        try
        {
            conn co = new conn();
            ResultSet rs = co.s.executeQuery("select * from faculty");
            while(rs.next())
            {   
                ch.add(rs.getString("empid"));
            }
        }
        catch(Exception e)
        {
            
        }

        ch.setBackground(Color.WHITE);
        ch.setBounds(500, 255, 150, 30);
        im.add(ch);
        
        l4 = new JLabel("Status");
        l4.setForeground(Color.BLACK);
        l4.setBounds(350, 350, 100, 30);
        l4.setFont(new Font("monospaced", Font.BOLD, 20));
        im.add(l4);

        String status[] = {"Present", "Absent"};
        cb2 = new JComboBox(status);
        cb2.setBackground(Color.WHITE);
        cb2.setBounds(500, 350, 150, 30);
        im.add(cb2);

        //mark button
        b1 = new JButton("Mark");
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

        setVisible(true);
        add(im);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String st = (String)cb2.getSelectedItem();
        String d = new java.util.Date().toString();
        String id = ch.getSelectedItem();
        String q = "insert into faculty_attendance values('"+id+"','"+d+"','"+st+"')";

        if(ae.getSource() == b1)
        {
            try
            {
                conn co = new conn();
                co.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Attendance Marked");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == b2)
        {
            this.setVisible(false);
            new Project();
        }
    }

    public static void main(String s[])
    {   
        new FacultyAttendance();
    }
}
