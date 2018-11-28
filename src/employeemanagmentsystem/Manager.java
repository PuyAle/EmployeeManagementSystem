
package employeemanagmentsystem;


public class Manager extends Employee {

    public Manager(String firstName, String lastName, int birthdate, int salary, String department) {
        super(firstName, lastName, birthdate, salary, department);
        
    }

    
    @Override
    public double bonus() {
       return getSalary()*0.15;
       
        
    }
}
