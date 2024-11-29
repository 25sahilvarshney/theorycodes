import java.util.*;

public class Student_Roll_Call {
    private List<String> students;

    public Student_Roll_Call() {
        students = new LinkedList<>();
    }

    public void addStudent(String student) {
        students.add(student);
    }

    public String getStudent(int index) {
        return students.get(index);
    }

    public void removeStudent(String student) {
        students.remove(student);
    }

    public void displayRollCall() {
        for (String student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        Student_Roll_Call rollCall = new Student_Roll_Call();
        rollCall.addStudent("Student A");
        rollCall.addStudent("Student B");
        rollCall.addStudent("Student C");
        System.out.println("Student at index 1: " + rollCall.getStudent(1));
        rollCall.removeStudent("Student B");
        rollCall.displayRollCall();
    }
}

