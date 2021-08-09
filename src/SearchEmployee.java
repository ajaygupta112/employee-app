import java.util.List;
import java.util.Map;

public class SearchEmployee
{
    private EmployeeDB edb = null;

    public SearchEmployee()
    {
        edb = new EmployeeDB();
    }

    public List<Employee> customerSearch(Map<String, String> empFields)
    {
        return null;
    }

    public List<Employee> getAllEmployee()
    {
        String query = "select * from employee";
        return edb.executeGetEmployee(query);
    }

    public List<Employee> getEmployeeById(int id)
    {
        String query = "select * from employees where id = " + id + ";";
        return edb.executeGetEmployee(query);
    }

    public List<Employee> getEmployeeByName(String firstName, String lastName)
    {
        String query = "select * from employees where first_name = '" + firstName + "' and last_name = '"+lastName+"';";
        return edb.executeGetEmployee(query);
    }

    public List<Employee> getEmployeeByManagerId(int id)
    {
        String query = "select * from employees as e where e.manager_id = " +id+";";
        return edb.executeGetEmployee(query);
    }

    public List<Employee> getEmployeeByDepartmentId(int id)
    {
        String query = "select * from employees as e where e.department_id = " +id+";";
        return edb.executeGetEmployee(query);
    }

    public List<Employee> getEmployeeByDepartmentName(String department)
    {
        String query = "select * from employees as e, departments as d where e.department_id = d.department_id and d.department_name = '" +department+"';";
        return edb.executeGetEmployee(query);
    }

    public List<Employee> getEmployeeByLocationId(int id)
    {
        String query = "select * from employees as e, departments as d where e.department_id = d.department_id and d.location_id = " +id+";";
        return edb.executeGetEmployee(query);
    }

    public List<Employee> getEmployeeByCityName(String city)
    {
        String query = "select * from employees as e, departments as d, locations as l where e.department_id = d.department_id and d.location_id = l.locations_id and l.city = '"+city+"';";
        return edb.executeGetEmployee(query);
    }

    public List<Employee> getEmployeeByCountry(String country)
    {
        String query = "select * from employees as e, departments as d, location as l " +
                        "where e.department_id = d.department_id and d.location_id = l.location_id " +
                        "and l.country = '" + country+"';";
        return edb.executeGetEmployee(query);
    }
}
