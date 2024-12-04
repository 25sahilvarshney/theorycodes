import java.util.Scanner;
public class BinaryToHexadecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binaryString = scanner.nextLine();
        String hexadecimalString = convertBinaryToHexadecimal(binaryString);
        System.out.println("Hexadecimal representation: " + hexadecimalString);

        scanner.close();
    }
    public static String convertBinaryToHexadecimal(String binary){
        long decimal = Long.parseLong(binary, 2);
        return Long.toHexString(decimal).toUpperCase();
    }
}
