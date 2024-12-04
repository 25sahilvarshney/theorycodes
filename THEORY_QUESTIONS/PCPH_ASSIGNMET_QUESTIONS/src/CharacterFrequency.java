import java.util.LinkedHashMap;  import java.util.Map;  import java.util.Scanner;
public class CharacterFrequency
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        Map<Character, Integer> charFrequencyMap = getCharacterFrequency(inputString);
        System.out.println("Character frequencies:");
        for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        scanner.close();
    }
    public static Map<Character, Integer> getCharacterFrequency(String input)
    {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
        for (char c : input.toCharArray())
        {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }
}