import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Camel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Camel Case string:");
        String s = scanner.nextLine();
        scanner.close();

        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        currentWord.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                words.add(currentWord.toString());
                currentWord = new StringBuilder();
            }
            currentWord.append(c);
        }

        words.add(currentWord.toString());

        for (String word : words) {
            System.out.println(word);
        }
    }
}
