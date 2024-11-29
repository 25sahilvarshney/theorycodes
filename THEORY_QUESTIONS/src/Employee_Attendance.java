import java.util.*;
public class Employee_Attendance {
        public static void main(String[] args) {
            List<String> attendanceList = new ArrayList<>(Arrays.asList("E001", "E002", "E003", "E001", "E004"));
            Set<String> uniqueAttendance = new LinkedHashSet<>(attendanceList);
            attendanceList.clear();
            attendanceList.addAll(uniqueAttendance);
            System.out.println(attendanceList);
        }
    }

