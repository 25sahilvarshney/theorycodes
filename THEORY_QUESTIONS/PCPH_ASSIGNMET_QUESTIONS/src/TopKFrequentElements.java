import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> result = topKFrequent(arr, k);
        System.out.println("Top " + k + " frequent elements: " + result);
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<Integer> topKElements = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            topKElements.add(minHeap.poll().getKey());
        }
        return topKElements;
    }
}