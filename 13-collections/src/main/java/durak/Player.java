package durak;

import java.util.ArrayList;
import java.util.List;

public record Player(String name, List<Card> cards) {
    public Player(String name) {
        this(name, new ArrayList<>());
    }

    /**
     * Attack another player
     *
     * @param player to attack
     */
    public Card attack(Player player) {
        // Hardcoded attack with the first card
        Card attacker = cards.remove(0);

        System.out.printf("%s attacks %s with %s%n",
                name, player.name(), attacker);

        return attacker;
    }

    public Card defend() {
        // Hardcoded defence with the first card
        Card defender = cards.remove(0);

        System.out.printf("%s defends with %s%n",
                name, defender);

        return defender;
    }

    /**
     * Check if the player has cards
     *
     * @return true if the player has cards
     */
    public boolean hasCards() {
        return !cards.isEmpty();
    }

    /**
     * Abandon defence
     *
     * @param cards to pick up after abandoning defence
     */
    public void abandonDefence(List<Card> cards) {
        this.cards.addAll(cards);
    }
}
