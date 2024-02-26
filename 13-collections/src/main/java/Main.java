import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cards = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEARTS, 'A');
        Arrays.fill(cards, aceOfHearts);
        Card.printDeck(Arrays.asList(cards), "Ace of Hearts", 1);

        List<Card> deck2 = new ArrayList<>(52);
        Collections.fill(deck2, aceOfHearts);
        System.out.println(deck2);
        System.out.println("size:" + deck2.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUBS, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

        Collections.addAll(deck2, cards);
        Collections.addAll(deck2, cards);
        Card.printDeck(deck2, "Card Collection with Aces added", 2);

        Collections.copy(deck2, kingsOfClubs);
        Card.printDeck(deck2, "Card Collection with Kings copied", 2);

        List<Card> deck3 = List.copyOf(kingsOfClubs);
        Card.printDeck(deck3, "List Copy of Kings", 1);
    }
}
