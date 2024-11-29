import java.util.*;

public class Movie_Theater_Seat_Booking {
    private List<Integer> seats;

    public Movie_Theater_Seat_Booking() {
        seats = new LinkedList<>();
    }

    public void bookSeat(int seatNumber) {
        seats.add(seatNumber);
    }

    public void cancelSeat(int seatNumber) {
        seats.remove(Integer.valueOf(seatNumber));
    }

    public void displaySeats() {
        for (int seat : seats) {
            System.out.println("Seat: " + seat);
        }
    }

    public static void main(String[] args) {
        Movie_Theater_Seat_Booking booking = new Movie_Theater_Seat_Booking();
        booking.bookSeat(1);
        booking.bookSeat(2);
        booking.bookSeat(3);
        booking.cancelSeat(2);
        booking.displaySeats();
    }
}

