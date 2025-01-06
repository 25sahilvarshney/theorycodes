import java.util.Scanner;
public class sliding_window {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the size of the sliding window (K): ");
        int k = scanner.nextInt();
        int maxSum = maxSumSubarray(arr, k);
        System.out.println("Maximum sum of a subarray of size " + k + " is: " + maxSum);
        scanner.close();
    }
    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            System.out.println("Array size is smaller than the window size.");
            return 0;
        }
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }
        int windowSum = maxSum;
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
