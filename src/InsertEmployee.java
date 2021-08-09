import java.util.List;

class InsertEmployee
{
    private EmployeeDB edb = null;

    public InsertEmployee()
    {
        edb = new EmployeeDB();
    }

    public int addEmployee(Employee employee)
    {
        return edb.executeAddEmployee(employee);
    }

    public int addEmployeeList(List<Employee> employeeList)
    {
        int[] count = edb.executeAddEmployeeList(employeeList);
        int sum = 0;
        for(int i : count)
            sum += i;
        return sum;
    }
}
