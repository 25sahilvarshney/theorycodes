import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        // Sample input
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Get the top K frequent elements
        List<Integer> result = topKFrequent(arr, k);

        // Print the result
        System.out.println("Top " + k + " frequent elements: " + result);
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a priority queue to find the top K frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue() // Min-heap based on frequency
        );

        // Add all entries to the min-heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            // If the size of the heap exceeds k, remove the least frequent element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Extract the elements from the min-heap
        List<Integer> topKElements = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            topKElements.add(minHeap.poll().getKey());
        }

        // Since we want the result in any order, we can return it directly
        return topKElements;
    }
}