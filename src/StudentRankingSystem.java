import java.util.*;
public class StudentRankingSystem {
    private HashMap<String, Integer> studentScores;

    public StudentRankingSystem() {
        studentScores = new HashMap<>();
    }

    // Method to add a student and their score
    public void addStudent(String name, int score) {
        studentScores.put(name, score);
    }

    // Method to get the rank of a student
    public String getRank(String name) {
        if (!studentScores.containsKey(name)) {
            return "Student not found.";
        }

        // Create a list of scores and sort it in descending order
        List<Integer> scores = new ArrayList<>(studentScores.values());
        Collections.sort(scores, Collections.reverseOrder());

        // Find the rank of the student
        int studentScore = studentScores.get(name);
        int rank = 1; // Start ranking from 1

        for (int score : scores) {
            if (score > studentScore) {
                rank++;
            } else {
                break; // Stop when we reach the student's score
            }
        }

        return "Rank of " + name + ": " + rank + (rank == 1 ? "st" : rank == 2 ? "nd" : rank == 3 ? "rd" : "th");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRankingSystem rankingSystem = new StudentRankingSystem();

        // Input loop for adding students
        System.out.println("Enter student names and scores. Type 'exit' to stop.");
        while (true) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter score for " + name + ": ");
            int score;
            try {
                score = Integer.parseInt(scanner.nextLine());
                rankingSystem.addStudent(name, score);
            } catch (NumberFormatException e) {
                System.out.println("Invalid score. Please enter a valid integer.");
                continue;
            }
        }

        // Input loop for getting ranks
        while (true) {
            System.out.print("Enter a student name to get their rank (or type 'exit' to quit): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println(rankingSystem.getRank(name));
        }

        scanner.close();
    }
}