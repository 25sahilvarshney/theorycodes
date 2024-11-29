import java.util.*;
public class fibonacci_series {
    static void printFib(int n) {
        if (n < 1) {
            System.out.println("Invalid Number of terms");
            return;
        }
        int prev1 = 1;
        int prev2 = 0;

        System.out.print(prev2 + " ");
        if (n == 1)
            return;

        System.out.print(prev1 + " ");
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
            System.out.print(curr + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of an elements : ");
        int n =  sc.nextInt();
        printFib(n);
    }
}
