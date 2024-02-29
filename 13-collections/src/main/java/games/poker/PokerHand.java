package games.poker;

import games.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokerHand {

    private final List<Card> hand;
    private final List<Card> keepers;
    private final List<Card> discards;
    private Ranking score = Ranking.NONE;
    private int playerNumber;

    public PokerHand(int playerNumber, List<Card> hand) {
        hand.sort(Card.sortRankReversedSuit());
        this.playerNumber = playerNumber;
        this.hand = hand;
        keepers = new ArrayList<>(hand.size());
        discards = new ArrayList<>(hand.size());
    }

    @Override
    public String toString() {
        return "%d. %-16s Rank:%d %-40s Best:%-7s Worst:%-6s %s"
                .formatted(playerNumber, score, score.ordinal(), hand,
                        Collections.max(hand, Comparator.comparing(Card::rank)),
                        Collections.min(hand, Comparator.comparing(Card::rank)),
                        !discards.isEmpty() ? "Discards: " + discards : "");
    }

    private void setRank(int faceCount) {

        switch (faceCount) {
            case 4 -> score = Ranking.FOUR_OF_A_KIND;
            case 3 -> {
                if (score == Ranking.NONE) score = Ranking.THREE_OF_A_KIND;
                else score = Ranking.FULL_HOUSE;
            }
            case 2 -> {
                if (score == Ranking.NONE) score = Ranking.ONE_PAIR;
                else if (score == Ranking.THREE_OF_A_KIND) score = Ranking.FULL_HOUSE;
                else score = Ranking.TWO_PAIR;
            }
        }
    }

    public void evalHand() {

        List<String> faceList = new ArrayList<>(hand.size());
        hand.forEach(card -> faceList.add(card.face()));

        List<String> duplicateFaceCards = new ArrayList<>();
        faceList.forEach(face -> {
            if (!duplicateFaceCards.contains(face) &&
                    Collections.frequency(faceList, face) > 1) {
                duplicateFaceCards.add(face);
            }
        });

        for (String duplicateFaceCard : duplicateFaceCards) {
            int start = faceList.indexOf(duplicateFaceCard);
            int last = faceList.lastIndexOf(duplicateFaceCard);
            setRank(last - start + 1);
            List<Card> sub = hand.subList(start, last + 1);
            keepers.addAll(sub);
        }

        pickDiscards();
    }

    private void pickDiscards() {

        List<Card> temp = new ArrayList<>(hand);
        temp.removeAll(keepers);
        int rankedCards = keepers.size();
        Collections.reverse(temp);
        int index = 0;
        for (Card card : temp) {
            if (index++ < 3 && (rankedCards > 2 || card.rank() < 9)) discards.add(card);
            else keepers.add(card);
        }
    }
}
