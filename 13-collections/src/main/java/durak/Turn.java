package durak;

public class Turn {
    private final Card attacker;
    private Card defender;

    public Turn(Card attacker) {
        this(attacker, null);
    }

    public Turn(Card attacker, Card defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public void setDefender(Card defender) {
        this.defender = defender;
    }

    public Card getAttacker() {
        return attacker;
    }

    public Card getDefender() {
        return defender;
    }

    /**
     * Check if the turn is valid (ranks of the cards and suits)
     *
     * @return true if the turn is valid
     */
    public boolean isValid(Card.Suit trump) {
        return (attacker.rank() < defender.rank() && attacker.suit() == defender.suit())
                || (defender.suit() == trump && attacker.suit() != trump);
    }

    /**
     * Add a card to the turn (adding a card of the same rank as the attacker is allowed)
     *
     * @param card to add to the turn
     * @return the turn with the added card
     */
    public Turn addCard(Card card) {
        if (attacker.rank() == card.rank()) {
            return new Turn(card);
        }

        System.out.println("Invalid card addition");
        return null;
    }
}
