public class Employee implements Comparable<Employee>
{
    private String firstName;
    private double salary;

    public Employee(String fname, double salary)
    {
        this.firstName = fname;
        this.salary = salary;
    }

    public double getSalary()
    {
        return salary;
    }

    public boolean equals(Employee o)
    {
        if (o.salary == this.salary && o.firstName.equals(this.firstName))
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "Employee{" + "name= " + firstName + ", salary= $" + salary + '}';
    }

    @Override
    public int compareTo(Employee o)
    {
        if (this.getSalary() > o.getSalary())
        {
            return 1;
        }

        else if (this.getSalary() < o.getSalary())
        {
            return -1;
        }

        else
        {
            return 0;
        }
    }

}
