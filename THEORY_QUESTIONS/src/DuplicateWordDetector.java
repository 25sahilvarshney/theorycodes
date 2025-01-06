import java.util.HashSet;
import java.util.Set;

public class DuplicateWordDetector {

    public static void findDuplicateWords(String paragraph) {
        String[] words = paragraph.split("\\W+");
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (String word : words) {
            String normalizedWord = word.toLowerCase();
            if (seen.contains(normalizedWord)) {
                duplicates.add(normalizedWord);
            } else {
                seen.add(normalizedWord);
            }
        }
        System.out.println("Duplicate words: " + duplicates);
    }
    public static void main(String[] args) {
        String paragraph = "This is a test. This test is only a test.";
        findDuplicateWords(paragraph);
    }
}
