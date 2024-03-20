package setsmaps.treesetchallenge;

public class BookingAgent {
    public static void main(String[] args) {
        int rows = 10;
        int totalSeats = 100;
        Theater rogersNYC = new Theater("Richard Rogers", rows, totalSeats);
        rogersNYC.printSeatMap();

        reserveSeat(rogersNYC, 'A', 3);
        reserveSeat(rogersNYC, 'A', 3);

        reserveSeat(rogersNYC, 'B', 1);
        reserveSeat(rogersNYC, 'B', 11);
        reserveSeat(rogersNYC, 'M', 11);
    }

    private static void reserveSeat(Theater theater, char row, int seatNumber) {
        String seat = theater.reserveSeat(row, seatNumber);
        if (seat != null) {
            System.out.println("Congratulations! You have reserved seat " + seat);
            theater.printSeatMap();
        } else {
            System.out.println("Sorry! Unable to reserve " + row + seatNumber);
        }
    }
}
