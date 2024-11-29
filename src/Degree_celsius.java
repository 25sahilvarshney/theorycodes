import java.util.*;
public class Degree_celsius {
        public static void main(String[] args)
        {
            double a,c;
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter Fahrenheit temperature = ");
            a=sc.nextDouble();
            System.out.println("Celsius temperature is = "+celsius(a));
        }
        static double celsius(double f) {
            return (f - 32) * 5 / 9;
        }
}
