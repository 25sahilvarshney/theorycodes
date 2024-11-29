import java.util.*;

public class Exam_Results_Announcement {
    private List<String> students;

    public Exam_Results_Announcement() {
        students = new ArrayList<>();
    }

    public void addStudent(String student) {
        students.add(student);
    }

    public void sortStudents() {
        Collections.sort(students);
    }

    public int getStudentPosition(String student) {
        return students.indexOf(student);
    }

    public void displayResults() {
        for (String student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        Exam_Results_Announcement results = new Exam_Results_Announcement();
        results.addStudent("Alice");
        results.addStudent("Bob");
        results.addStudent("Charlie");
        results.sortStudents();
        System.out.println("Position of Bob: " + results.getStudentPosition("Bob"));
        results.displayResults();
    }
}

