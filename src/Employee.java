import java.sql.Date;

public class Employee
{
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private float salary;
    private float commission;
    private int managerId;
    private int departmentId;

    public Employee(int id, String firstName, String lastName, String email, String phoneNumber, Date hireDate, String job_id, float salary, float commission, int managerId, int departmentId)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = job_id;
        this.salary = salary;
        this.commission = commission;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return this.id; }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }

    public Date getHireDate()
    {
        return this.hireDate;
    }

    public void setJobId(String jobId)
    {
        this.jobId = jobId;
    }

    public String getJobId()
    {
        return this.jobId;
    }

    public void setSalary(float salary)
    {
        this.salary = salary;
    }

    public float getSalary()
    {
        return this.salary;
    }

    public void setCommission(float commission)
    {
        this.commission = commission;
    }

    public float getCommission()
    {
        return this.commission;
    }

    public void setManagerId(int managerId) { this.managerId = managerId; }

    public int getManagerId()
    {
        return this.managerId;
    }

    public void setDepartmentId(int departmentId)
    {
        this.departmentId = departmentId;
    }

    public int getDepartmentId()
    {
        return this.departmentId;
    }

    @Override
    public String toString() {

        return String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s",
                id,
                firstName,
                lastName,
                email,
                phoneNumber,
                hireDate,
                jobId,
                salary,
                commission,
                managerId,
                departmentId);
    }
}