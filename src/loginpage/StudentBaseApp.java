package loginpage;

import java.util.Scanner;

public class StudentBaseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Welcome message
        System.out.println("Welcome to Student Base App");
        
        // Prompt for and read the student's details
        System.out.print("Enter the student's first name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter the student's last name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter the student's division: ");
        String division = scanner.nextLine();
        
        System.out.print("Enter the student's age: ");
        int age = scanner.nextInt();
        
        // Print the student's details
        System.out.println("\nStudent Details:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Division: " + division);
        System.out.println("Age: " + age);
        
        scanner.close();
    }
}
