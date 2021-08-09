import java.sql.Date;
import java.util.List;

public class MainDriver
{
    public static void main(String[] args)
    {
        SearchEmployee se = new SearchEmployee();
        List<Employee> employee = se.getEmployeeById(100);
        List<Employee> employeeList = se.getAllEmployee();

        if(employee != null)
        {
            System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s",
                    "Employee ID","First Name","Last Name","Email","Phone Number","Hire Date","Job Id","Salary","Commission %","Manager Id","Department Id"));
            System.out.println(employee);
        }


        System.out.println();

        if(employeeList != null)
        {
            System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s",
                    "Employee ID","First Name","Last Name","Email","Phone Number","Hire Date","Job Id","Salary","Commission PCT","Manager Id","Department Id"));
            for(Employee emp : employeeList)
                System.out.println(emp);
        }

        Employee emp = new Employee(1000, "Ajay", "Gupta", "agupta", "1234567890", new Date(System.currentTimeMillis()),"AD_PRES", 12400, 0, 0, 90 );
        InsertEmployee ie = new InsertEmployee();
        int result = ie.addEmployee(emp);
        if(result > 0)
            System.out.println("Employee added");
        else
            System.out.println("Encountered a problem while adding employee");



    }

    public void addOp()
    {

    }

    public void searchOp()
    {

    }

    public void updateOp()
    {

    }
}
