import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string (S): ");
        String S = scanner.nextLine();
        System.out.print("Enter the second string (S1): ");
        String S1 = scanner.nextLine();
        boolean isAnagram = areAnagrams(S, S1);
        if (isAnagram) {
            System.out.println("The strings \"" + S + "\" and \"" + S1 + "\" are anagrams.");
        } else {
            System.out.println("The strings \"" + S + "\" and \"" + S1 + "\" are not anagrams.");
        }
        scanner.close();
    }
    public static boolean areAnagrams(String S, String S1) {
        if (S.length() != S1.length()) {
            return false;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : S.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : S1.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) < 0) {
                return false;
            }
        }

        return true;
    }
}