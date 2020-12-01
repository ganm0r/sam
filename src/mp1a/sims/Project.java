//main window

package mp1a.sims;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener
{
    JMenuBar mb;
    JMenu master, user, attendance, register, exit;
    JMenuItem m1, m2, r1, r2, u1, u2, a1, a2, e1;
    Project()
    {
        super("Student Attendance Management");

        setSize(1040, 760);
        setLocation(400, 180);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("Mp1a/Sims/Icons/Logo.png"));
        Image im = c1.getImage().getScaledInstance(1040, 700, Image.SCALE_DEFAULT);
        ImageIcon c2 = new ImageIcon(im);
        JLabel l1 = new JLabel(c2);

        add(l1);

        mb = new JMenuBar();

        //user data ip/op 
        master  = new JMenu("Master");
        master.setForeground(Color.BLACK);
        master.setFont(new Font("monospaced", Font.BOLD, 18));

        m1 = new JMenuItem("New Faculty");
        m2 = new JMenuItem("New Student");
        
        m1.setFont(new Font("monospaced", Font.BOLD, 16));
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("Mp1a/Sims/Icons/Icon2.png"));
        Image im1 = ic1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(im1));
        m1.setBackground(Color.WHITE);
        m1.addActionListener(this);
        master.add(m1);

        m2.setFont(new Font("monospaced", Font.BOLD, 16));
        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("Mp1a/Sims/Icons/Icon2.png"));
        Image im2 = ic2.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(im2));
        m2.setBackground(Color.WHITE);
        m2.addActionListener(this);
        master.add(m2);
         
        //user details 
        user = new JMenu("PersonnelInfo");
        user.setForeground(Color.BLACK);
        user.setFont(new Font("monospaced", Font.BOLD, 18));

        u1 = new JMenuItem("Faculty Details");
        u2 = new JMenuItem("Student Details");

        u1.setFont(new Font("monospaced", Font.BOLD, 16));
        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("Mp1a/Sims/Icons/Icon3.png"));
        Image im5 = ic3.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(im5));
        u1.setBackground(Color.WHITE);
        u1.addActionListener(this);
        user.add(u1);

        u2.setFont(new Font("monospaced", Font.BOLD, 16));
        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("Mp1a/Sims/Icons/Icon3.png"));
        Image im6 = ic4.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        u2.setIcon(new ImageIcon(im6));
        u2.setBackground(Color.WHITE);
        u2.addActionListener(this);
        user.add(u2);

        //attendance 
        attendance  = new JMenu("Attendance");
        attendance.setForeground(Color.BLACK);
        attendance.setFont(new Font("monospaced", Font.BOLD, 18));

        a1 = new JMenuItem("Faculty Attendance");
        a2 = new JMenuItem("Student Attendance");
        
        a1.setFont(new Font("monospaced", Font.BOLD, 16));
        ImageIcon ic5 = new ImageIcon(ClassLoader.getSystemResource("Mp1a/Sims/Icons/Icon15.png"));
        Image im7 = ic5.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        a1.setIcon(new ImageIcon(im7));
        a1.setBackground(Color.WHITE);
        a1.addActionListener(this);
        attendance.add(a1);

        a2.setFont(new Font("monospaced", Font.BOLD, 16));
        ImageIcon ic6 = new ImageIcon(ClassLoader.getSystemResource("Mp1a/Sims/Icons/Icon15.png"));
        Image im8 = ic6.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        a2.setIcon(new ImageIcon(im8));
        a2.setBackground(Color.WHITE);
        a2.addActionListener(this);
        attendance.add(a2);

        //attendance register
        JMenu register = new JMenu("AttendanceRegister");
        register.setForeground(Color.BLACK);
        register.setFont(new Font("monospaced", Font.BOLD, 18));

        r1 = new JMenuItem("Faculty Register");
        r2 = new JMenuItem("Student Register");
        
        r1.setFont(new Font("monospaced", Font.BOLD, 16));
        ImageIcon ic7 = new ImageIcon(ClassLoader.getSystemResource("Mp1a/Sims/Icons/Icon16.png"));
        Image im9 = ic7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        r1.setIcon(new ImageIcon(im9));
        r1.setBackground(Color.WHITE);
        r1.addActionListener(this);
        register.add(r1);

        r2.setFont(new Font("monospaced", Font.BOLD, 16));
        ImageIcon ic8 = new ImageIcon(ClassLoader.getSystemResource("Mp1a/Sims/Icons/Icon16.png"));
        Image im10 = ic8.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        r2.setIcon(new ImageIcon(im10));
        r2.setBackground(Color.WHITE);
        r2.addActionListener(this);
        register.add(r2);

        //exit
        exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("monospaced", Font.BOLD, 18));

        e1 = new JMenuItem("Exit SAM");

        e1.setFont(new Font("monospaced", Font.BOLD, 16));
        ImageIcon ic11 = new ImageIcon(ClassLoader.getSystemResource("Mp1a/Sims/Icons/Icon12.png"));
        Image im11 = ic11.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        e1.setIcon(new ImageIcon(im11));
        e1.setBackground(Color.WHITE);
        e1.addActionListener(this);
        exit.add(e1);

        mb.add(master);
        mb.add(user);
        mb.add(attendance);
        mb.add(register);
        mb.add(exit);

        setJMenuBar(mb);

        setFont(new Font ("monospace", Font.BOLD, 16));
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {   
        String ac = ae.getActionCommand();

        if(ac.equals("New Student"))
        {
            new AddStudent();
        }
        else if(ac.equals("New Faculty"))
        {
            new AddFaculty();
        }
        else if(ac.equals("Faculty Attendance"))
        {
            new FacultyAttendance();
        }
        else if(ac.equals("Student Attendance"))
        {
            new StudentAttendance();
        }
        else if(ac.equals("Faculty Register"))
        {
            new FacultyRegister();
        }
        else if(ac.equals("Student Register"))
        {
            new StudentRegister();
        }
        else if(ac.equals("Faculty Details"))
        {
            new FacultyDetails();
        }
        else if(ac.equals("Student Details"))
        {
            new StudentDetails();
        }
        else if(ac.equals("Exit SAM"))
        {
            this.setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args)
    {
        new Project();
    }
}
