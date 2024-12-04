import java.util.HashMap;
public class TwoSum {
    public static int[] findTwoSum(int[] arr, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(arr[i], i);
        }
        return new int[] {};
    }
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = findTwoSum(arr, target);
        if (result.length == 0) {
            System.out.println("No two sum solution found.");
        } else {
            System.out.println("Indices of the two numbers: [" + result[0] + ", " + result[1] + "]");
        }
    }
}
