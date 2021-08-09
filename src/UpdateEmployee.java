import java.util.Map;

public class UpdateEmployee
{
    private EmployeeDB edb = null;

    public UpdateEmployee()
    {
        edb = new EmployeeDB();
    }

    public int updateEmployee(Map<String, String> empDetails, int id)
    {
        //update employees set first_name = ?, last_name = ?, email = ?, phone_number = ?, hire_date = ?, job_id = ?, salary = ?, commission = ?, manager_id = ?, department_id = ? where employee_id = ?
        String query = "";
        if(!empDetails.isEmpty())
        {
            query = "update employee set ";
            for(Map.Entry<String, String> entry: empDetails.entrySet())
            {
                String column = entry.getKey();
                query += column + " = ";
                if(column.equals("first_name") || column.equals("last_name") || column.equals("email") || column.equals("phone_number") || column.equals("hire_date"))
                {
                    query += "'"+entry.getValue()+"' ";
                }
                else
                    query += entry.getValue()+ " ";
            }

            query +=  "where employee_id = " + id + ";";
            return edb.executeUpdateEmployee(query);
        }
        return 0;
    }

}
