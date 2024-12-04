import java.util.Scanner;

public class sliding_window {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Input the elements of the array
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input the size of the window
        System.out.print("Enter the size of the sliding window (K): ");
        int k = scanner.nextInt();

        // Find the maximum sum of a subarray of size K
        int maxSum = maxSumSubarray(arr, k);
        System.out.println("Maximum sum of a subarray of size " + k + " is: " + maxSum);

        // Close the scanner
        scanner.close();
    }

    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            System.out.println("Array size is smaller than the window size.");
            return 0; // or throw an exception
        }

        // Calculate the sum of the first window
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;

        // Slide the window from the start to the end of the array
        for (int i = k; i < n; i++) {
            // Slide the window to the right by subtracting the element going out and adding the element coming in
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
