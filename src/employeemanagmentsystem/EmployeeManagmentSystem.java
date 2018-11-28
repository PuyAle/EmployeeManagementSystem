

package employeemanagmentsystem;

public class EmployeeManagmentSystem {
   
    public static void main(String[] args) {
        //Possible to create and call a method here, every time the program starts it connects to a database where we put all the employees. 
        //After the connection we can read all the employees to our arraylist so wee can use it as the program is set without 
        //the need of changes in this program. In this way the employees will not be deleted after closing the program.  
        System.out.println("Welcome to the employee managment system!");
        EmployeeManagement.menuSwitch();
        
    }

}
