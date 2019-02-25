package employeemanagmentsystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeManagement {

    private static ArrayList<Employee> employerList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void menuSwitch() {

        switch (UserInterface.headMenu()) {
            case 1:
                switchEmployeeManagement(UserInterface.menuEmployeeManagement());
                break;
            case 2:
                switchEmployeeStatistics(UserInterface.menuStatistics());
            case 3:
                break;
            default:
                menuSwitch();

        }
    }

    public static void switchEmployeeManagement(int i) {

        switch (i) {
            case 0:
                menuSwitch();
                break;
            case 1:

                employerList.add(addEmployee());
                menuSwitch();
                break;
            case 2:
                deleteEmployee();
                menuSwitch();
                break;
            case 3:
                updateEmployeeName();
                menuSwitch();
                break;
            case 4:
                updateBirthDate();
                menuSwitch();

                break;
            case 5:
                updateTitle();
                menuSwitch();
                break;
            case 6:
                updateSalary();
                menuSwitch();
                break;
            case 7:
                searchFirstName();
                menuSwitch();
                break;
            case 8:
                searchDateOfBirth();
                menuSwitch();
                break;
            case 9:
                searchTitle();
                menuSwitch();
                break;
            case 10:
                giveBonus();
                menuSwitch();
                break;
            case 11:
                printAll();
                menuSwitch();
            default:
                System.out.println("\nWrong choice, chose a number from the menu!");

        }

    }

    public static void switchEmployeeStatistics(int i) {
        switch (i) {
            case 0:
                menuSwitch();
                break;
            case 1:
                averageWage();
                menuSwitch();
                break;
            case 2:
                maxSalary();
                menuSwitch();
                break;
            case 3:
                minSalary();
                menuSwitch();
                break;
            case 4:
                totalGivenBonus();
                menuSwitch();
                break;
            case 5:
                averageAge();
                menuSwitch();
                break;
        }
    }

    public static Employee addEmployee() {

        System.out.println("\nRegister a new employee");
        System.out.print("\nEnter first name: ");
        String firstName = sc.nextLine();

        System.out.print("\nEnter last name: ");
        String lastName = sc.nextLine();

        System.out.print("\nEnter date of birth, YYYYMMDD: ");
        int dateOfBirth = sc.nextInt();

        System.out.print("\nEnter the monthly salary for the employee: ");
        int salary = sc.nextInt();
        sc.nextLine();

        boolean loop = true;
        while (loop) {
            System.out.print("\nEnter the employees work titel: ");
            String title = sc.nextLine();

            switch (title) {
                case "CEO":
                    CEO c1 = new CEO(firstName, lastName, dateOfBirth, salary, title);
                    loop = false;
                    System.out.println("\nEmployer added!");
                    return c1;
                case "Manager":
                    Manager m1 = new Manager(firstName, lastName, dateOfBirth, salary, title);
                    loop = false;
                    System.out.println("\nEmployer added!");
                    return m1;
                case "Worker":
                    Worker w1 = new Worker(firstName, lastName, dateOfBirth, salary, title);
                    loop = false;
                    System.out.println("\nEmployer added!");
                    return w1;
                default:
                    System.out.println("\nThere is no title named: " + title);
                    System.out.println("\nPlease enter a correct title, for example CEO, Manager or Worker");
                    break;
            }
        }

        return null;
    }

    public static void deleteEmployee() {
        boolean loop1 = true;

        while (loop1) {

            System.out.println("\nDelete an employee");
            System.out.print("\nEnter the date of birth of the employee you want to delete from the system (if you would like to go back to the main menu just enter 0: ");
            int id = sc.nextInt();
            sc.nextLine();
            boolean hit = false;
            boolean loop2 = true;
            if (id == 0) {
                loop1 = false;
            }
            for (int i = employerList.size() - 1; i >= 0; i--) {

                if (employerList.get(i).getBirthdate() == id) {
                    hit = true;
                    System.out.println("\nDo you want to delete: " + employerList.get(i).toString() + "?");
                    while (loop2) {
                        System.out.print("\nEnter 1 to delete the employee or 0 to go back to the main menu: ");
                        int choiceDelete = sc.nextInt();
                        sc.nextLine();
                        switch (choiceDelete) {
                            case 0:
                                loop2 = false;
                                loop1 = false;
                                break;
                            case 1:

                                employerList.remove(i);
                                System.out.println("The employee has been deleted.\n");
                                System.out.println("Would you like to delete another employe enter 1 else press 0 to go back to main menu.");
                                int deleteAnother = sc.nextInt();
                                sc.nextLine();
                                if (deleteAnother == 1) {
                                    loop2 = false;
                                } else if (deleteAnother == 0) {
                                    loop1 = false;
                                    loop2 = false;
                                }
                                break;

                            default:
                                System.out.println("\nWrong number, enter a number from the menu:  ");

                        }
                    }

                }
            }

            if (hit == false && id != 0) {
                System.out.println("\nThere is no employee with that date of birth.");
            }
        }

    }

    public static void updateEmployeeName() {

        boolean loop1 = true;

        while (loop1) {
            System.out.println("\nChange an employees name");
            System.out.println("\nEnter the date of birth of the employee (if you would like to go back to the main menu just enter 0: ");
            int id = sc.nextInt();
            sc.nextLine();
            boolean hit = false;
            boolean loop2 = true;
            if (id == 0) {
                loop1 = false;
            }
            for (int i = employerList.size() - 1; i >= 0; i--) {

                if (employerList.get(i).getBirthdate() == id) {
                    hit = true;
                    System.out.println("\nDo you want to change name for: " + employerList.get(i).toString() + " ?");
                    while (loop2) {
                        System.out.println("\nEnter 1. to change the employees first name ");
                        System.out.println("Enter 2. to change the employees last name ");
                        System.out.println("Enter 3. to change the employees first and last name");
                        System.out.println("Enter 0. to go back to the main menu: ");
                        int choiceChange = sc.nextInt();
                        sc.nextLine();
                        switch (choiceChange) {
                            case 0:
                                loop1 = false;
                                loop2 = false;
                                break;

                            case 1:
                                System.out.println("\nWhat is the new first name: ");
                                String newName = sc.nextLine();
                                employerList.get(i).setFirstName(newName);
                                loop1 = false;
                                loop2 = false;
                                break;

                            case 2:
                                System.out.println("\nWhat is the new last name: ");
                                String newLastName = sc.nextLine();
                                employerList.get(i).setLastName(newLastName);
                                loop2 = false;
                                loop1 = false;
                                break;
                            case 3:
                                System.out.println("\nWhat is the new first name: ");
                                String new1Name = sc.nextLine();
                                employerList.get(i).setFirstName(new1Name);
                                System.out.println("What is the new last name: ");
                                String new1LastName = sc.nextLine();
                                employerList.get(i).setLastName(new1LastName);
                                loop2 = false;
                                loop1 = false;
                                break;

                            default:
                                System.out.println("\nWrong number, enter a number from the menu: ");

                        }
                    }

                }
            }

            if (hit == false && id != 0) {
                System.out.println("\nThere is no employee with that date of birth. ");
            }
        }

    }

    public static void updateBirthDate() {

        boolean loop1 = true;

        while (loop1) {

            System.out.println("\nChange an employees date of birth!");
            int id = -1;
            boolean loop3 = true;

            while (loop3) {
                try {
                    System.out.println("\nEnter the date of birth of the employee (if you would like to go back to the main menu just enter 0: ");

                    id = sc.nextInt();
                    sc.nextLine();
                    loop3 = false;

                } catch (Exception e) {
                    sc.nextLine();

                    System.out.println("Only numeric please!");
                }
            }

            boolean hit = false;
            boolean loop2 = true;

            if (id == 0) {
                loop1 = false;
            }
            for (int i = employerList.size() - 1; i >= 0; i--) {

                if (employerList.get(i).getBirthdate() == id) {

                    hit = true;
                    System.out.println("\nDo you want to change date of birth for " + employerList.get(i).toString() + " ?");
                    while (loop2) {
                        System.out.println("\nEnter 1 to change the date of birth ");
                        System.out.println("Enter 0 to go back to the main menu: ");
                        int choiceChange = sc.nextInt();
                        sc.nextLine();
                        switch (choiceChange) {

                            case 0:
                                loop1 = false;
                                loop2 = false;
                                break;

                            case 1:
                                System.out.println("\nWhat is the new date of birth: ");
                                int newDateOfBirth = sc.nextInt();
                                employerList.get(i).setBirthdate(newDateOfBirth);
                                loop2 = false;
                                loop1 = false;
                                break;

                            default:
                                System.out.println("\nWrong number, enter a number from the menu: ");

                        }
                    }

                }
            }
            if (hit == false && id != 0) {
                System.out.println("\nThere is no employee with that date of birth. ");
            }
        }
    }

    public static void updateTitle() {
        boolean loop1 = true;

        while (loop1) {

            System.out.println("\nChange an employees title!");
            System.out.println("\nEnter the date of birth of the employee (if you would like to go back to the main menu just enter 0: ");
            int id = sc.nextInt();
            sc.nextLine();
            //creating a bool that is set to false outside of the for loop.
            boolean hit = false;
            boolean loop2 = true;
            if (id == 0) {
                loop1 = false;
            }
            for (int i = employerList.size() - 1; i >= 0; i--) {

                if (employerList.get(i).getBirthdate() == id) {

                    hit = true;
                    System.out.println("\nDo you want to change title of " + employerList.get(i).toString() + " ?");
                    while (loop2) {
                        System.out.println("\nEnter 1 to change the title ");
                        System.out.println("Enter 0 to go back to the main menu: ");
                        int choiceChange = sc.nextInt();
                        sc.nextLine();
                        switch (choiceChange) {

                            case 0:
                                loop1 = false;
                                loop2 = false;
                                break;

                            case 1:
                                changeTitle(i);
                                loop1 = false;
                                loop2 = false;
                                break;

                            default:
                                System.out.println("Wrong number, enter a number from the menu: ");

                        }

                    }
                    System.out.println("Employers title changed!");

                }
            }
            if (hit == false && id != 0) {
                System.out.println("\nThere is no employee with that date of birth. ");
            }
        }
    }

    private static void changeTitle(int i) {
        System.out.println("\nWhat is the new title: ");
        Employee newTitle = null;
        String newTit = sc.nextLine();
        switch (newTit) {
            case "CEO":
                newTitle = new CEO(employerList.get(i).getFirstName(), employerList.get(i).getLastName(), employerList.get(i).getBirthdate(), employerList.get(i).getSalary(), newTit);
                break;

            case "Manager":
                newTitle = new Manager(employerList.get(i).getFirstName(), employerList.get(i).getLastName(), employerList.get(i).getBirthdate(), employerList.get(i).getSalary(), newTit);
                break;

            case "Worker":
                newTitle = new Worker(employerList.get(i).getFirstName(), employerList.get(i).getLastName(), employerList.get(i).getBirthdate(), employerList.get(i).getSalary(), newTit);
                break;

            default:
                System.out.println("There is no title named: ." + newTitle);
                System.out.println("Please enter a correct title, for example CEO, Manager or Worker");
        }
        newTitle.setBonus(employerList.get(i).getBonus());
        newTitle.setId(employerList.get(i).getId());
        employerList.remove(i);
        employerList.add(newTitle);
    }

    public static void updateSalary() {

        boolean loop1 = true;

        while (loop1) {

            System.out.println("\nChange an employees salary!");
            System.out.println("\nEnter the date of birth of the employee (if you would like to go back to the main menu just enter 0: ");
            int id = sc.nextInt();
            sc.nextLine();

            boolean hit = false;
            boolean loop2 = true;
            if (id == 0) {
                loop1 = false;
            }
            for (int i = employerList.size() - 1; i >= 0; i--) {

                if (employerList.get(i).getBirthdate() == id) {

                    hit = true;
                    System.out.println("\nDo you want to change salary for " + employerList.get(i).toString() + " ?");
                    while (loop2) {
                        System.out.println("\nEnter 1 to change the salary ");
                        System.out.println("Enter 0 to go back to the main menu: ");
                        int choiceChange = sc.nextInt();
                        sc.nextLine();
                        switch (choiceChange) {

                            case 0:
                                loop1 = false;
                                loop2 = false;
                                break;

                            case 1:
                                System.out.println("\nWhat is the new salary: ");
                                int newSalary = sc.nextInt();
                                employerList.get(i).setSalary(newSalary);
                                loop2 = false;
                                loop1 = false;
                                break;

                            default:
                                System.out.println("Wrong number, enter a number from the menu: ");

                        }
                    }

                }
            }
            if (hit == false && id != 0) {
                System.out.println("\nThere is no employee with that date of birth. ");
            }
        }
    }

    public static void searchFirstName() {

        boolean loop1 = true;

        while (loop1) {

            System.out.println("\nSearch by name!");
            System.out.println("\nEnter the name of the employee (if you would like to go back to the main menu just enter 0: ");
            String id = sc.nextLine();
            //creating a bool that is set to false outside of the for loop.
            boolean hit = false;
            if (id.equals("0")) {
                loop1 = false;
            }
            for (int i = employerList.size() - 1; i >= 0; i--) {

                if (employerList.get(i).getFirstName().equals(id)) {

                    hit = true;
                    System.out.println(employerList.get(i).toString() + "\n");
                }
            }
            if (hit == false && !id.equals("0")) {
                System.out.println("\nThere is no employee with that name! ");
            }
        }
    }

    public static void searchDateOfBirth() {

        boolean loop1 = true;

        while (loop1) {

            System.out.println("\nSearch a employee by date of birth!");
            System.out.println("\nEnter the date of birth of the employee (if you would like to go back to the main menu just enter 0: ");
            int id = sc.nextInt();
            sc.nextLine();

            boolean hit = false;
            if (id == 0) {
                loop1 = false;
            }
            for (int i = employerList.size() - 1; i >= 0; i--) {

                if (employerList.get(i).getBirthdate() == id) {

                    hit = true;
                    System.out.println(employerList.get(i).toString() + "\n");
                    loop1 = false;

                }
            }
            if (hit == false && id != 0) {
                System.out.println("\nThere is no employee with that date of birth. ");
            }
        }
    }

    public static void searchTitle() {

        boolean loop1 = true;

        while (loop1) {

            System.out.println("\nSearch employees by title!");
            System.out.println("\nEnter the title (if you would like to go back to the main menu just enter 0: ");
            String id = sc.nextLine();
            boolean hit = false;
            if (id.equals("0")) {
                loop1 = false;
            }
            for (int i = employerList.size() - 1; i >= 0; i--) {

                if (employerList.get(i).getTitle().equals(id)) {
                    hit = true;
                    System.out.println(employerList.get(i).toString() + "\n");
                    loop1 = false;

                }
            }
            if (hit == false && !id.equals("0")) {
                System.out.println("\nThere is no matching title. ");
            }
        }
    }

    public static void printAll() {
        System.out.println("\nPrint list with sorted name or age or title");
        System.out.println("===========================================");
        System.out.println("1. Print by name");
        System.out.println("2. Print by age");
        System.out.println("3. Print by title");
        System.out.println("0. Return");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:

                employerList.sort((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));

                employerList.forEach((employee) -> {
                    System.out.println(employee);
                });
                break;
            case 2:
                employerList.sort((o1, o2) -> o1.getBirthdate() - o2.getBirthdate());
                employerList.forEach((employee) -> {
                    System.out.println(employee);
                });
                break;
            case 3:
                employerList.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
                employerList.forEach((employee) -> {
                    System.out.println(employee);
                });
                break;
            case 0:
                break;
            default:
                System.out.println("\nWrong choice, try again.");

        }
    }

    public static void giveBonus() {
        boolean loop1 = true;
        while (loop1) {
            System.out.println("\nGive bonus!");
            System.out.println("=============");
            System.out.println("\nWould you like to give bonus to all employees, just employees with a certain title or one employee?");
            System.out.println("1. All employees");
            System.out.println("2. Bonus by title");
            System.out.println("3. Bonus to a certain employee");
            System.out.println("0. Main menu");
            int menuBonus = sc.nextInt();
            sc.nextLine();
            if (menuBonus == 0) {
                loop1 = false;
            }
            switch (menuBonus) {
                case 0:
                    menuSwitch();
                    break;
                case 1:
                    employerList.forEach((employee) -> {
                        employee.setBonus(employee.getBonus() + employee.bonus());
                    });
                    System.out.println("\nAll employees has now receved a bonus!");
                    loop1 = false;
                    break;
                case 2: {
                    boolean loop2 = true;
                    boolean hit1 = false;
                    while (loop2) {

                        System.out.println("\nEnter the title (if you would like to go back to the main menu just enter 0: ");
                        String id = sc.nextLine();

                        if (id.equals("0")) {
                            loop1 = false;
                            loop2 = false;

                        }

                        for (int i = employerList.size() - 1; i >= 0; i--) {

                            if (employerList.get(i).getTitle().equals(id)) {
                                hit1 = true;
                                System.out.println("\nDo you want to give all employees with the title " + id + " a bonus? Enter yes or no");
                                String choiceBonus = sc.nextLine();
                                switch (choiceBonus) {
                                    case "yes":
                                        employerList.get(i).setBonus(employerList.get(i).getBonus() + employerList.get(i).bonus());
                                        System.out.println("\nEmployees with title " + id + " has recived the bonus!");
                                        loop1 = false;
                                        loop2 = false;
                                        break;
                                    case "no":
                                        loop1 = false;
                                        loop2 = false;
                                        break;
                                    default:
                                        System.out.println("Invalid choice, choose yes or no");
                                        break;
                                }
                            }
                        }
                        if (hit1 == false && !id.equals("0")) {
                            System.out.println("There is no matching title!");
                        } else {

                        }
                    }
                    break;
                }
                case 3: {
                    boolean hit = false;
                    boolean loop2 = true;
                    while (loop2) {

                        System.out.print("\nEnter the date of birth of the employee (if you would like to go back to the main menu just enter 0: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        if (id == 0) {
                            loop1 = false;
                            loop2 = false;
                        }
                        String choiceBonus = "";
                        for (int i = employerList.size() - 1; i >= 0; i--) {

                            if (employerList.get(i).getBirthdate() == id) {

                                hit = true;
                                System.out.println("\nDo you want to give " + employerList.get(i).toString() + " a bonus? Enter yes or no");
                                choiceBonus = sc.nextLine();
                                switch (choiceBonus) {
                                    case "yes":
                                        employerList.get(i).setBonus(employerList.get(i).getBonus() + employerList.get(i).bonus());
                                        break;
                                    case "no":
                                        loop1 = false;
                                        loop2 = false;
                                        break;
                                    default:
                                        System.out.println("Invalid choice, choose yes or no");
                                        break;
                                }
                            }
                        }
                        if (choiceBonus.equals("yes")) {
                            System.out.println("\nEmployee has recived the bonus");
                        }
                        if (hit == false && id != 0) {
                            System.out.println("\nThere is no employee with that date of birth. ");
                        }
                    }
                    break;
                }
                default:
                    System.out.println("\nInvalid choice, make a choice from the menu!");
            }
        }
    }

    public static void averageWage() {
        boolean loop1 = true;
        while (loop1) {
            System.out.println("\nAverage wage! ");
            System.out.println("\nDo you want to use every employees salary or just a particular title? ");
            System.out.println("1. Calculate average salary with every employees salary.");
            System.out.println("2. Calculate average salary by title");
            System.out.println("0. Main menu");
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    loop1 = false;
                case 1:
                    int sum1 = 0;
                    for (int i = 0; i < employerList.size(); i++) {
                        sum1 += employerList.get(i).getSalary();

                    }
                    System.out.println("\nThe average salary at the company is " + sum1 / employerList.size());
                    break;
                case 2:
                    int sum2 = 0;
                    int count = 0;
                    System.out.print("\nEnter the title: ");
                    String choice2 = sc.nextLine();
                    for (int i = 0; i < employerList.size(); i++) {
                        if (employerList.get(i).getTitle().equals(choice2)) {
                            sum2 += employerList.get(i).getSalary();
                            count++;

                        }

                    }
                    System.out.println("\nThe average salary is" + sum2 / count);
                    break;
                default:
                    System.out.println("\nInvalid choice, choose from the menu!");

            }

        }
    }

    public static void maxSalary() {
        boolean loop1 = true;
        while (loop1) {
            System.out.println("\nFind max salary in the company!");

            System.out.println("1. Search highest salary in the company:");
            System.out.println("0. Main menu. ");

            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    loop1 = false;
                    break;
                case 1:
                    employerList.sort((o1, o2) -> o2.getSalary() - o1.getSalary());
                    System.out.println("\nHighest salary at the company: " + employerList.get(0));

                    loop1 = false;
                    break;
                default:
                    System.out.println("Wrong choice, choose from the menu.");

            }

        }
    }

    public static void minSalary() {
        boolean loop1 = true;
        while (loop1) {
            System.out.println("\nFind lowest salary in the company!");
            System.out.println("1. Search lowest salary in the company:");
            System.out.println("0. Main menu. ");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    loop1 = false;
                    break;
                case 1:
                    Employee temp;
                    for (int i = 0; i < employerList.size(); i++) {
                        for (int j = 1; j < employerList.size() - i; j++) {
                            if (employerList.get(j).getSalary() < employerList.get(j - 1).getSalary()) {
                                temp = employerList.get(j);
                                employerList.set(j, employerList.get(j - 1));
                                employerList.set(j - 1, temp);

                            }
                        }
                    }
                    System.out.println("\nLowest salary at the company: " + employerList.get(0));
                    loop1 = false;
                    break;
                default:
                    System.out.println("Wrong choice, choose from the menu.");
            }

        }
    }

    public static void totalGivenBonus() {
        int sum = 0;
        for (Employee employee : employerList) {
            sum += employee.getBonus();

        }
        System.out.println("The company has given a total of " + sum + "SEK to all the employees.");
    }

    public static void averageAge() {

        System.out.println("\nCalculate average age at the company.");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int sum = 0;
        for (Employee employee : employerList) {
            int d1 = employee.getBirthdate();
            int d2 = Integer.parseInt(formatter.format(new Date()));
            int age = (d2 - d1) / 10000;

            sum += age;
        }
        System.out.println("\nAverage age in the company is " + sum / employerList.size() + "years");
    }

}
