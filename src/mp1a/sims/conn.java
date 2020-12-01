//database connectivity

package mp1a.sims;
import java.sql.*;

public class conn
{
    Connection c;
    Statement s;
    public conn()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //register mysql driver using static method 'forName' from 'Class'
            c = DriverManager.getConnection("jdbc:mysql:///sam", "root", ""); //'gteConnection' method in 'DriverManager' takes connection url as arguments:
            s = c.createStatement(); //helps executing queries
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
