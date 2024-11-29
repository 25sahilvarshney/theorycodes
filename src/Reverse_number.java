import java.util.*;
public class Reverse_number {
        public static void main(String[] arg)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter a number");
            int x=sc.nextInt();
            int r=reverse(x);
            System.out.println("Reverse of a number is = "+r);
        }
        static int reverse(int nums) {
            int remainder, reverse = 0;
            while (nums!= 0) {
                remainder = nums % 10;
                reverse = (reverse * 10) + remainder;
                nums = nums / 10;
            }
            return reverse;
        }
}
