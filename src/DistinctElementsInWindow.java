import java.util.*;

public class DistinctElementsInWindow {

    public static List<Integer> countDistinctInWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());
        for (int i = k; i < arr.length; i++) {
            int outgoingElement = arr[i - k];
            if (map.get(outgoingElement) == 1) {
                map.remove(outgoingElement);
            } else {
                map.put(outgoingElement, map.get(outgoingElement) - 1);
            }
            int incomingElement = arr[i];
            map.put(incomingElement, map.getOrDefault(incomingElement, 0) + 1);
            result.add(map.size());
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter the window size (k):");
        int k = scanner.nextInt();

        if (k > n) {
            System.out.println("Window size should not be greater than array size.");
            return;
        }
        List<Integer> result = countDistinctInWindow(arr, k);
        System.out.println("Distinct elements count in each window:");
        for (int count : result) {
            System.out.print(count + " ");
        }
    }
}

