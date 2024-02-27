import java.util.*;

public class Main {
    public static void main(String[] args) {
        Card[] cards = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cards, aceOfHearts);
        Card.printDeck(Arrays.asList(cards), "Ace of Hearts", 1);

        List<Card> deck2 = new ArrayList<>(52);
        Collections.fill(deck2, aceOfHearts);
        System.out.println(deck2);
        System.out.println("size:" + deck2.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

        Collections.addAll(deck2, cards);
        Collections.addAll(deck2, cards);
        Card.printDeck(deck2, "Card Collection with Aces added", 2);

        Collections.copy(deck2, kingsOfClubs);
        Card.printDeck(deck2, "Card Collection with Kings copied", 2);

        List<Card> deck3 = List.copyOf(kingsOfClubs);
        Card.printDeck(deck3, "List Copy of Kings", 1);

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck", 4);

        var sortingAlgorithm = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        deck.sort(sortingAlgorithm);
        Card.printDeck(deck, "Sorted Deck", 10);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Sorted Deck", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in deck", 1);

        int indexOfSublist = Collections.indexOfSubList(deck, tens);
        System.out.println("Index of Tens in deck: " + indexOfSublist);
        System.out.println("Contains equals " + deck.containsAll(tens));

        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("Disjoint: " + disjoint);

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("Disjoint: " + disjoint2);

        deck.sort(sortingAlgorithm);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 9);
        int indexOf = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("Index of Ten of Hearts: " + indexOf);
        System.out.println("Index of Ten of Hearts: " + deck.indexOf(tenOfHearts));
        System.out.println(deck.get(indexOf));

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 9);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32, 36), "Replaced Tens with Hearts", 1);

        if(Collections.replaceAll(deck, tenOfClubs, tenOfHearts)) {
            System.out.println("Replaced Tens with Hearts");
        } else {
            System.out.println("No Tens found");
        }

        System.out.println("Frequency of Ten of Hearts: " + Collections.frequency(deck, tenOfHearts));

        System.out.println("Max: " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Min: " + Collections.min(deck, sortingAlgorithm));

        var sortBySuit = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by Suit", 4);

        List<Card> deck4 = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(deck4, 2);
        System.out.println("Unrotaded" + deck.subList(0, 13));
        Card.printDeck(deck4, "Rotated Deck", 4);

        List<Card> deck5 = new ArrayList<>(deck.subList(0, 13));
        for (int i = 0; i < deck5.size() / 2; i++) {
            Collections.swap(deck5, i, deck5.size() - i - 1);
        }
        System.out.println("Manual reversed" + deck5);
    }
}
