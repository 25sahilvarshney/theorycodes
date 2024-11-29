import java.util.Scanner;
public class palindrome {
    public static void main(String[] args)
    {
        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter the number n : ");
        int num = sc.nextInt();
        int reversedNum = 0;
        int remainder;
        int originalNum = num;
        while (num != 0) {
            remainder = num % 10;
            reversedNum = reversedNum * 10 + remainder;
            num /= 10;
        }
        if (originalNum == reversedNum) {
            System.out.println(originalNum + " is Palindrome.");
        }
        else {
            System.out.println(originalNum + " is not Palindrome.");
        }
    }
}

