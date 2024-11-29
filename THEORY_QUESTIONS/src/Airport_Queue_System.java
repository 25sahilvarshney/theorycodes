import java.util.*;

public class Airport_Queue_System {
    private List<String> queue;

    public Airport_Queue_System() {
        queue = new LinkedList<>();
    }

    public void checkIn(String passenger) {
        queue.add(passenger);
    }

    public void cancelTicket(String passenger) {
        queue.remove(passenger);
    }

    public void displayQueue() {
        for (String passenger : queue) {
            System.out.println(passenger);
        }
    }

    public static void main(String[] args) {
        Airport_Queue_System queue = new Airport_Queue_System();
        queue.checkIn("Passenger A");
        queue.checkIn("Passenger B");
        queue.checkIn("Passenger C");
        queue.cancelTicket("Passenger B");
        queue.displayQueue();
    }
}

