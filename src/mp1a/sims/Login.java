//login window

package mp1a.sims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JLabel l1, l2;
    JTextField un;
    JPasswordField pw;
    JButton jb1, jb2;

    Login()
    {
        super("Login");
        
        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        add(l2);
        
        un = new JTextField();
        un.setBounds(150, 20, 150, 30);
        add(un);

        pw = new JPasswordField();
        pw.setBounds(150, 70, 150, 30);
        add(pw);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("Mp1a/Sims/Icons/Second.jpg"));
        Image im = c1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon c2 = new ImageIcon(im);
        JLabel l3 = new JLabel(c2);
        l3.setBounds(350, 20, 150, 150);
        add(l3);

        jb1 = new JButton("Login");
        jb1.setBounds(40, 140, 120, 30);
        jb1.setFont(new Font("monospaced", Font.BOLD, 15));
        jb1.addActionListener(this);
        jb1.setBackground(Color.BLACK);
        jb1.setForeground(Color.WHITE);
        add(jb1);

        jb2 = new JButton("Cancel");
        jb2.setBounds(180, 140, 120, 30);
        jb2.setFont(new Font("monospaced", Font.BOLD, 15));
        jb2.addActionListener(this);
        jb2.setBackground(Color.BLACK);
        jb2.setForeground(Color.WHITE);
        add(jb2);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600, 300);
        setLocation(650, 370);
    }

    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == jb1)
        {
            try
            {   
                conn co = new conn();
                String userName = un.getText();
                String passWord = pw.getText();

                String q = "select * from login where username = '"+userName+"' and password = '"+passWord+"'";

                ResultSet rs = co.s.executeQuery(q);   
                if(rs.next())
                {   
                    new Project();
                    setVisible(false);
                }
                else
                {   
                    JOptionPane.showMessageDialog(null, "Invalid Username/Password");
                    new Login();
                    setVisible(false);
                }
            }
            catch(Exception e)
            {   
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == jb2)
        {
            System.exit(0);
        }
    }

    public static void main(String[] arg)
    {
        new Login();
    }
}
