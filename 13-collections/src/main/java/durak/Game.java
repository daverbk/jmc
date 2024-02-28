package durak;

import java.util.*;

public class Game {
    private final int MAX_CARDS_IN_HAND = 6;

    private final Queue<Player> turnQueue;
    private final List<Card> deck;

    public Game() {
        turnQueue = new LinkedList<>();
        deck = Card.getDurakDeck();
    }

    /**
     * Add a player to the game
     *
     * @param player to add to the game
     */
    public void addPlayer(Player player) {
        turnQueue.offer(player);
    }

    /**
     * Start a Durak game
     *
     */
    public void start() {

        // Create a deck of cards
        Card.printDeck(deck);

        // Shuffle the deck
        Collections.shuffle(deck);

        // Pick a trump card
        Card trumpCard = deck.remove(0);

        // Deal players their hands
        for (int i = 0; i < MAX_CARDS_IN_HAND; i++) {
            for (Player player : turnQueue) {
                player.cards().add(deck.remove(0));
            }
        }

        // Create a discard pile
        List<Card> discardPile = new ArrayList<>();

        Player firstPlayer = turnQueue.peek();
        Player currentPlayer;
        Player nextPlayer;

        System.out.println("Starting the game with " + turnQueue.size() + " players");

        while (turnQueue.size() > 1) {
            boolean nextPlayerSkipsTurn = false;

            currentPlayer = turnQueue.poll();
            nextPlayer = turnQueue.peek();

            // Last player attacks the first player
            if (nextPlayer == null) {
                nextPlayer = firstPlayer;
            }

            Card attacker = currentPlayer.attack(nextPlayer);
            Card defender = nextPlayer.defend();
            Turn currentTurn = new Turn(attacker, defender);

            if (currentTurn.isValid(trumpCard.suit())) {
                // If the turn is valid, the next player defends
                System.out.println(nextPlayer.name() + " successfully defends");
                discardPile.addAll(List.of(currentTurn.getAttacker(), currentTurn.getDefender()));
            } else {
                // If not, the defending player abandons defence
                // PS Strict, but will do for a demo
                System.out.println("Invalid turn");
                currentPlayer.abandonDefence(List.of(currentTurn.getAttacker()));
                nextPlayerSkipsTurn = true;
            }

            // Add cards to current turn players' hands if they have less than 6 cards
            refillHands(List.of(currentPlayer, nextPlayer));

            // Re-add the player to the end of the queue if one still got cards
            if (currentPlayer.hasCards()) {
                turnQueue.offer(currentPlayer);
            }

            if (nextPlayerSkipsTurn) {
                nextPlayer = turnQueue.poll();
                turnQueue.offer(nextPlayer);
            }

            System.out.println("_".repeat(30));
        }

        // Game over
        Player durak = Objects.requireNonNull(turnQueue.poll());

        System.out.println("Game over! " + durak.name() + " is the Durak!");
        System.out.println("Durak's hand: " + durak.cards());
        System.out.println("Trump card: " + trumpCard);
        System.out.println("Discard pile: " + discardPile);
    }


    private void refillHands(List<Player> players) {
        players.forEach(player -> {
            while (player.cards().size() < MAX_CARDS_IN_HAND) {
                if (deck.isEmpty()) {
                    return;
                }

                player.cards().add(deck.remove(0));
            }
        });
    }
}
