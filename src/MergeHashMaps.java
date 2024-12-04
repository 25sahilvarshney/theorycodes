import java.util.HashMap;
import java.util.Map;

public class MergeHashMaps {
    public static void main(String[] args) {
        // Sample input
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("Alice", 85);
        map1.put("Bob", 90);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("Bob", 10);
        map2.put("Charlie", 75);

        // Merge the two HashMaps
        Map<String, Integer> mergedMap = mergeHashMaps(map1, map2);

        // Print the merged result
        System.out.println("Merged HashMap: " + mergedMap);
    }

    public static Map<String, Integer> mergeHashMaps(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        // Create a new HashMap to store the merged results
        HashMap<String, Integer> mergedMap = new HashMap<>(map1);

        // Iterate through the second map and merge values
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return mergedMap;
    }
}
