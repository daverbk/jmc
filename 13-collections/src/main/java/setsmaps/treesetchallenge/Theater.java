package setsmaps.treesetchallenge;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Theater {

    static class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved;

        public Seat(char row, int number) {
            this.seatNumber = "%c%03d".formatted(row, number).toUpperCase();
        }

        @Override
        public String toString() {
            return seatNumber;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNumber.compareTo(o.seatNumber);
        }
    }

    private final String name;
    private final int seatsPerRow;
    private final NavigableSet<Seat> seats;

    public Theater(String name, int rows, int totalSeats) {
        this.name = name;
        this.seatsPerRow = totalSeats / rows;

        seats = new TreeSet<>();
        for (int i = 0; i < totalSeats; i++) {
            char rowChar = (char) (i / seatsPerRow + (int) 'A');
            int seatsInRow = i % seatsPerRow + 1;
            seats.add(new Seat(rowChar, seatsInRow));
        }
    }

    public void printSeatMap() {
        String separatorLine = "-".repeat(90);
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", separatorLine, name);

        int index = 0;
        for (Seat seat : seats) {
            System.out.printf("%-8s%s",
                    seat.seatNumber + ((seat.reserved) ? "(●)" : ""),
                    ((index++ + 1) % seatsPerRow == 0) ? "\n" : "");
        }

        System.out.println(separatorLine);
    }

    public String reserveSeat(char row, int seat) {
        Seat requestedSeat = new Seat(row, seat);
        Seat requested = seats.ceiling(requestedSeat);

        if (requested == null || !requested.seatNumber.equals(requestedSeat.seatNumber)) {
            System.out.print("--> No such seat: " + requestedSeat);
            System.out.printf(": Seat must be between %s and %s%n",
                    seats.first(), seats.last());
        } else {
            if (!requested.reserved) {
                requested.reserved = true;
                return requested.seatNumber;
            }
            else System.out.println("Seat's already reserved.");
        }

        return null;
    }
}
