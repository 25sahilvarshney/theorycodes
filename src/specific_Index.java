import java.util.ArrayList;
import java.util.Scanner;

public class specific_Index {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        System.out.println("Original List: " + numbers);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the element to insert: ");
        int elementToInsert = scanner.nextInt();
        System.out.print("Enter the index at which to insert the element: ");
        int index = scanner.nextInt();
        if (index < 0 || index > numbers.size()) {
            System.out.println("Invalid index. Please enter an index between 0 and " + numbers.size());
        } else {
            numbers.add(index, elementToInsert);
            System.out.println("Modified List: " + numbers);
        }
        scanner.close();
    }
}
