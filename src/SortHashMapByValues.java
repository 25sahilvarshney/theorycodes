import java.util.*;

public class SortHashMapByValues {
    public static void main(String[] args) {
        // Sample input
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 85);
        map.put("Bob", 90);
        map.put("Charlie", 75);

        // Sort the HashMap by values
        Map<String, Integer> sortedMap = sortByValue(map);

        // Print the sorted map
        System.out.println("Sorted HashMap by values: " + sortedMap);
    }

    public static Map<String, Integer> sortByValue(HashMap<String, Integer> map) {
        // Create a list from the entries of the HashMap
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Sort the list using a custom comparator
        entryList.sort(Map.Entry.comparingByValue());

        // Create a LinkedHashMap to maintain the order of the sorted entries
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
