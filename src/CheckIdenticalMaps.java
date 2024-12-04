import java.util.HashMap;
public class CheckIdenticalMaps {
    public static void main(String[] args) {
        // Sample input
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("Alice", 85);
        map1.put("Bob", 90);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("Alice", 85);
        map2.put("Bob", 90);
        boolean areIdentical = areMapsIdentical(map1, map2);
        System.out.println("Are the two maps identical? " + areIdentical);
        HashMap<String, Integer> map3 = new HashMap<>();
        map3.put("Alice", 85);
        map3.put("Charlie", 90);
        boolean areIdentical2 = areMapsIdentical(map1, map3);
        System.out.println("Are the two maps identical? " + areIdentical2);
    }
    public static boolean areMapsIdentical(HashMap<String, Integer> map1, HashMap<String, Integer> map2)
    {
        return map1.equals(map2);
    }
}
