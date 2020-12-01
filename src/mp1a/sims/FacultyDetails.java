package mp1a.sims;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class FacultyDetails extends JFrame implements ActionListener
{
    JLabel l1, l2;
    JTable t1;
    JButton b1, b2;
    JTextField tx;
    String col[] = {"EMP ID", "Name", "Email ID", "Department"};
    String tab[][] = new String[70][4];
    int i = 0, j = 0;
    
    public FacultyDetails()
    {
        super("Personnel Info - Faculty");
        setSize(1040, 760);
        setLocation(400, 180);
        setLayout(null);

        l1 = new JLabel("Delete Faculty(Enter EMP ID)");
        l1.setBounds(50, 560, 400, 30);
        l1.setFont(new Font("monospaced", Font.BOLD, 20));
        l1.setForeground(Color.BLACK);
        add(l1);

        tx = new JTextField();
        tx.setBounds(400, 560, 200, 30);
        add(tx);
        
        b1 = new JButton("Delete");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(620, 560, 100, 30);
        add(b1);
        
        b2 = new JButton("Add Faculty");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(50, 620, 400, 30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        try
        {
            conn co = new conn();
            String s1 = "select * from faculty";
            ResultSet rs = co.s.executeQuery(s1);
            while(rs.next())
            {
                tab[i][j++] = rs.getString("empid");
                tab[i][j++] = rs.getString("name");
                tab[i][j++] = rs.getString("department");
                tab[i][j++] = rs.getString("email");
                i++;
                j = 0;
            }
            t1 = new JTable(tab, col);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(50, 20, 900, 530);
        add(sp);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        conn co = new conn();
        if(ae.getSource() == b1)
        {
            try
            {   
                String st = tx.getText();
                String q = "delete from faculty where empid = '"+st+"'";
                co.s.executeUpdate(q);
                this.setVisible(false);
                new FacultyDetails();
            }
            catch(Exception e)
            {
                
            }
        }
        else if(ae.getSource() == b2)
        {
            new AddFaculty();
            this.setVisible(false); 
        }
    }
    public static void main(String[] args)
    {
        new FacultyDetails();
    }
}
