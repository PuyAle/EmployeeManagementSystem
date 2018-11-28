
package employeemanagmentsystem;


public class CEO extends Employee {

    public CEO(String firstName, String lastName, int birthdate, int salary, String department) {
        
        super(firstName, lastName, birthdate, salary, department);
   
    }
    
    @Override
    public double bonus() {
       return getSalary()*0.2;
       
        
    }
    

}
