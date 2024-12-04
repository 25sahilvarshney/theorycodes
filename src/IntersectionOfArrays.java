import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        // Sample input
        int[] arr1 = {1, 2, 2, 3};
        int[] arr2 = {2, 2, 4, 5};

        // Find the intersection
        List<Integer> intersection = findIntersection(arr1, arr2);

        // Print the result
        System.out.println("Intersection: " + intersection);
    }

    public static List<Integer> findIntersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Count occurrences of each element in the first array
        for (int num : arr1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find common elements in the second array
        for (int num : arr2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                result.add(num); // Add to result
                countMap.put(num, countMap.get(num) - 1); // Decrease count
            }
        }

        return result;
    }
}
