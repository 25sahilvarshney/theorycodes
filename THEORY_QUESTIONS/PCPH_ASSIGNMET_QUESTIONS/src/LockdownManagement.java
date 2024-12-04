import java.util.*;
public class LockdownManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxAllowed = 10;
        int currentPeople = 0;
        System.out.print("Enter the number of people entering: ");
        int entering = scanner.nextInt();
        System.out.print("Enter the number of people exiting: ");
        int exiting = scanner.nextInt();
        currentPeople += entering;
        currentPeople -= exiting;
        if (currentPeople > maxAllowed) {
            System.out.println("Lockdown!");
        } else {
            System.out.println("Safe");
        }
        scanner.close();
    }
}
