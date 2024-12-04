import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of rows
        System.out.print("Enter the number of rows for Pascal's Triangle: ");
        int rows = scanner.nextInt();

        // Generate Pascal's Triangle
        int[][] triangle = new int[rows][];

        for (int i = 0; i < rows; i++) {
            // Initialize each row with the appropriate size
            triangle[i] = new int[i + 1];

            // The first and last elements of each row are always 1
            triangle[i][0] = 1;
            triangle[i][i] = 1;

            // Calculate the values for the inner elements
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        // Print Pascal's Triangle
        System.out.println("Pascal's Triangle:");
        for (int i = 0; i < rows; i++) {
            // Print leading spaces for formatting
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }

        // Close the scanner
        scanner.close();
    }
}
