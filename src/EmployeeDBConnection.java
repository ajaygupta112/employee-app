import java.sql.*;

class EmployeeDBConnection
{
    private static EmployeeDBConnection employeeDBConnection = null;
    private Connection con;

    private EmployeeDBConnection()
    {
    }

    public static EmployeeDBConnection getEmployeeDBConnection()
    {
        if(employeeDBConnection == null)
            employeeDBConnection = new EmployeeDBConnection();
        return employeeDBConnection;
    }

    public void createConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Driver not found for SQL");
        }
        String url = "jdbc:mysql://localhost:3306/new_schema";
        try
        {
            con = DriverManager.getConnection(url, "root","root");
        }
        catch(SQLException e)
        {
            System.out.println("Connection can not be established");
        }

    }

    public void closeConnection()
    {
        try
        {
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println("Connection not closed " + e);
        }
    }

    public PreparedStatement createPrepareStatement(String sql)
    {
        try
        {
            return con.prepareStatement(sql);
        }
        catch(SQLException e)
        {
            System.out.println("Cannot create statement " + e);
        }
        return null;
    }

    public Statement createStatement()
    {
        try
        {
            return con.createStatement();
        }
        catch(SQLException e)
        {
            System.out.println("Cannot create statement " + e);
        }
        return null;
    }
}