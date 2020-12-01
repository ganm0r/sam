package mp1a.sims;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegister extends JFrame implements ActionListener
{
    JTable t1;
    JButton b1;
    String col[] = {"XIE ID", "Date/Time", "Status"};
    String tab[][] = new String[70][4];
    int i = 0, j = 0;
    
    public StudentRegister()
    {
        super("Attendance Register - Students");
        setSize(1040, 760);
        setLocation(400, 180);

        try
        {
            String q = "select * from student_attendance";
            conn co = new conn();
            ResultSet rs = co.s.executeQuery(q);
            while(rs.next())
            {
                tab[i][j++] = rs.getString("xieid");
                tab[i][j++] = rs.getString("date");
                tab[i][j++] = rs.getString("status");
                i++;
                j = 0;
            }
            t1 = new JTable(tab, col);
        }
        catch(Exception e)
        {
            
        }
        b1 = new JButton("Print");
        add(b1, "South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try
            {
                t1.print();
            }
            catch(Exception e)
            {

            }
        }
    }
    
    public static void main(String[] args)
    {
        new StudentRegister();
    }
}