package employeemanagmentsystem;

import java.util.Scanner;

public class UserInterface {
    //menyer returnera siffra till nästa val. se ex. 

    static Scanner sc = new Scanner(System.in);

    public static int headMenu() {
        int menuNumber = 0;
        boolean loop = true;
        while (loop) {
            System.out.println("\nMain menu: ");
            System.out.println("\n1. Employee managment (add, update, delete etc.)");
            System.out.println("2. Employee statistics");
            System.out.println("3. Exit\n");
            System.out.print("Enter a number from the menu to continue: ");
            menuNumber = sc.nextInt();
            sc.nextLine();
            if (menuNumber == 1 || menuNumber == 2 || menuNumber == 3) {
                loop = false;
            } else {
                System.out.println("\nWrong choice, choose a number from the menu! ");
            }
        }
        return menuNumber;
    }

    public static int menuEmployeeManagement() {
        int menuNumber = 0;
        boolean loop = true;
        while (loop) {
            System.out.println("\n1. Register employee");
            System.out.println("2. Delete employee");
            System.out.println("3. Update name of employee");
            System.out.println("4. Update the birthdate of employee");
            System.out.println("5. Update the title of employee");
            System.out.println("6. Update salary of employee");
            System.out.println("7. Search employee by name");
            System.out.println("8. Search employee by date of birth");
            System.out.println("9. Search employee by title");
            System.out.println("10. Give employees bonus");
            System.out.println("11. Display all employees");
            System.out.println("0. Back to main menu");

            System.out.print("\nEnter a number from the menu to continue: \n");
            menuNumber = sc.nextInt();
            sc.nextLine();

            if (menuNumber == 1 || menuNumber == 2 || menuNumber == 3 || menuNumber == 4 || menuNumber == 5 || menuNumber == 6 || menuNumber == 7 || menuNumber == 8 || menuNumber == 9 || menuNumber == 10 || menuNumber == 11 || menuNumber == 0) {
                loop = false;
            } else {
                System.out.println("\nWrong choice, choose a number from the menu! ");
            }

        }
        return menuNumber;
    }

    public static int menuStatistics() {
        int menuNumber = 0;
        boolean loop = true;
        while (loop) {
            System.out.println("\nEmployee statistics: ");
            System.out.println("\n1. Average wage at the company");
            System.out.println("2. Maximum salary in the company");
            System.out.println("3. Minimum salary in the company");
            System.out.println("4. Total bonus");
            System.out.println("5. Average age at the company");
            System.out.println("0. Main menu");
            System.out.print("\nEnter a number from the menu to continue: ");
            menuNumber = sc.nextInt();
            sc.nextLine();
            if (menuNumber == 1 || menuNumber == 2 || menuNumber == 3 || menuNumber == 4 || menuNumber == 5 || menuNumber == 0) {
                loop = false;
            } else {
                System.out.println("\nWrong choice, choose a number from the menu! ");
            }
        }
        return menuNumber;
    }
}
