
package employeemanagmentsystem;


public abstract class Employee {
    //variables that every employer have. 
    private String firstName;
    private String lastName;
    //borde ha varit en sträng för att få med fyra sista som sedan kapas genom substring för att bara få datum som görs om till en int
    //för att subtrahera med dagens datum delat på 10 000 för att få ålder.
    private int birthdate;
    private int salary;
    //borde varit enum så att man bara får x antal val.
    private String title;
    private int id;
    private static int idGenerator = 0;
    private double bonus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public abstract double bonus ();
        
    //constructor to set information about employer.
    public Employee(String firstName, String lastName, int dateOfBirth, int salary, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = dateOfBirth;
        this.salary = salary;
        this.title = title;
        idGenerator++;
        this.id=idGenerator;
        this.bonus=0;
        
        
    }
    
    
    //getter and setters to show and/or change information about employer.
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    
    
    public String toString(){
        return "\n" + title + ": " + firstName + " " + lastName + " " + birthdate + " salary: " + salary + " recived bonus " + bonus + "kr.";
    }
    
    
}
//enum kolla upp begränsar alt till de man vill tillåta för att inte skriva ex. två kön för att inte kunna skriva vad som helst eller något annant.
