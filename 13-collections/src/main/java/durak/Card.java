package durak;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) {

    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        public char getImage() {
            return (new char[]{9827, 9830, 9829, 9824})[ordinal()];
        }
    }

    @Override
    public String toString() {

        int index = face.equals("10") ? 2 : 1;
        String faceString = face.substring(0, index);
        return String.format("%s%s(%d)", faceString, suit.getImage(), rank);
    }

    public static Card getNumericCard(Suit suit, int cardNumber) {

        if (cardNumber > 1 && cardNumber < 11) {
            return new Card(suit, String.valueOf(cardNumber), cardNumber - 2);
        }

        System.out.println("Invalid numeric card selected");
        return null;
    }

    public static Card getFaceCard(Suit suit, char abbrev) {

        int charIndex = "JQKA".indexOf(abbrev);
        if (charIndex > -1) {
            return new Card(suit, String.valueOf(abbrev), charIndex + 9);
        }
        System.out.println("Invalid face card selected");
        return null;
    }

    public static List<Card> getStandardDeck() {
        return getDeck(2);
    }

    public static List<Card> getDurakDeck() {
        return getDeck(6);
    }

    public static void printDeck(List<Card> deck) {
        printDeck(deck, "Current Deck", 4);
    }

    public static void printDeck(List<Card> deck, String description, int rows) {
        System.out.println("_".repeat(20));
        if (description != null) {
            System.out.println(description);
        }
        int cardsInRow = deck.size() / rows;
        for (int i = 0; i < rows; i++) {
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }

    private static List<Card> getDeck(int minNumberCard) {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int i = minNumberCard; i < 11; i++) {
                deck.add(getNumericCard(suit, i));
            }
            for (char c : "JQKA".toCharArray()) {
                deck.add(getFaceCard(suit, c));
            }
        }

        return deck;
    }
}
