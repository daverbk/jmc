package setsmaps.treesetchallenge;

public class BookingAgent {
    public static void main(String[] args) {
        int rows = 10;
        int totalSeats = 100;
        Theater rogersNYC = new Theater("Richard Rogers", rows, totalSeats);
        rogersNYC.printSeatMap();

        bookSeat(rogersNYC, 'A', 3);
        bookSeat(rogersNYC, 'A', 3);

        bookSeat(rogersNYC, 'B', 1);
        bookSeat(rogersNYC, 'B', 11);
        bookSeat(rogersNYC, 'M', 11);

        bookSeats(rogersNYC, 4, 'B', 3, 10);
        bookSeats(rogersNYC, 6, 'B', 'C', 3, 10);
        bookSeats(rogersNYC, 4, 'B', 1, 10);
        bookSeats(rogersNYC, 4, 'B', 'C', 1, 10);
        bookSeats(rogersNYC, 1, 'B', 'C', 1, 10);
        bookSeats(rogersNYC, 4, 'M', 'Z', 1, 10);
        bookSeats(rogersNYC, 10, 'A', 'E', 1, 10);
    }

    private static void bookSeat(Theater theater, char row, int seatNumber) {
        String seat = theater.bookSeat(row, seatNumber);
        if (seat != null) {
            System.out.println("Congratulations! You have reserved seat " + seat);
            theater.printSeatMap();
        } else {
            System.out.println("Sorry! Unable to reserve " + row + seatNumber);
        }
    }

    private static void bookSeats(Theater theater, int tickets, char minRow,
                                  int minSeat, int maxSeat) {

        bookSeats(theater, tickets, minRow, minRow, minSeat, maxSeat);
    }

    private static void bookSeats(Theater theater, int tickets,
                                  char minRow, char maxRow,
                                  int minSeat, int maxSeat) {

        var seats = theater.reserveSeats(tickets, minRow, maxRow, minSeat, maxSeat);
        if (seats != null) {
            System.out.println("Congratulations! You have reserved seats " + seats);
            theater.printSeatMap();
        } else {
            System.out.println("Sorry! No matching contiguous seats in rows: "
                    + minRow + " - " + maxRow);
        }
    }
}
