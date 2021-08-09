import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDB
{
    private final EmployeeDBConnection empCon;

    public EmployeeDB()
    {
        empCon = EmployeeDBConnection.getEmployeeDBConnection();
    }

    public List<Employee> executeGetEmployee(String sql)
    {
        empCon.createConnection();
        Statement st = empCon.createStatement();
        return getEmployeeList(st, sql);
    }


    private List<Employee> getEmployeeList(Statement st, String sql)
    {
        List<Employee> employeeList = new ArrayList<>();
        ResultSet rs;
        try
        {
            rs = st.executeQuery(sql);
            while(rs.next())
            {
                Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getFloat(8), rs.getFloat(9), rs.getInt(10), rs.getInt(11));
                employeeList.add(employee);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Result set not generated");

        }
        empCon.closeConnection();
        return employeeList;
    }

    public int executeAddEmployee(Employee employee)
    {
        empCon.createConnection();
        PreparedStatement pdst = empCon.createPrepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?,?,?)");
        int result = 0;
        try
        {
            if(pdst != null)
            {
                pdst.setInt(1,employee.getId());
                pdst.setString(2, employee.getFirstName());
                pdst.setString(3, employee.getLastName());
                pdst.setString(4, employee.getEmail());
                pdst.setString(5, employee.getPhoneNumber());
                pdst.setDate(6, employee.getHireDate());
                pdst.setString(7, employee.getJobId());
                pdst.setFloat(8, employee.getSalary());
                pdst.setFloat(9,employee.getCommission());
                pdst.setInt(10, employee.getManagerId());
                pdst.setInt(11,employee.getDepartmentId());
                result = pdst.executeUpdate();
            }
        }
        catch(SQLException e)
        {
            System.out.println("Problem in fields");
        }
        empCon.closeConnection();
        return result;
    }

    public int[] executeAddEmployeeList(List<Employee> employeeList)
    {
        empCon.createConnection();
        PreparedStatement pdst = empCon.createPrepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?,?,?)");
        try
        {
            if(pdst != null)
            {
                for(Employee employee : employeeList)
                {
                    pdst.setInt(1,employee.getId());
                    pdst.setString(2, employee.getFirstName());
                    pdst.setString(3, employee.getLastName());
                    pdst.setString(4, employee.getEmail());
                    pdst.setString(5, employee.getPhoneNumber());
                    pdst.setDate(6, employee.getHireDate());
                    pdst.setString(7, employee.getJobId());
                    pdst.setFloat(8, employee.getSalary());
                    pdst.setFloat(9,employee.getCommission());
                    pdst.setInt(10, employee.getManagerId());
                    pdst.setInt(11,employee.getDepartmentId());
                    pdst.addBatch();
                }

                int[] result = pdst.executeBatch();
                empCon.closeConnection();
                return result;
            }
        }
        catch(SQLException e)
        {
            System.out.println("Problem in fields");
        }
        return new int[1];
    }

    public int executeUpdateEmployee(String sql)
    {
        empCon.createConnection();
        Statement st = empCon.createStatement();
        try
        {
            int result = st.executeUpdate(sql);
            empCon.closeConnection();
            return result;
        }
        catch(SQLException e)
        {
            System.out.println("Update query not working" + e);
        }
        return 0;
    }
}
