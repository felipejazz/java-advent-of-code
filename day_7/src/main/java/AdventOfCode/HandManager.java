package AdventOfCode;

import java.util.HashMap;
import java.util.Map;

public class HandManager {

    private String[] hand;

    public void setHand( String[] hand) {
        this.hand = hand;
    }
    public String[] getHand() {
        return this.hand;
    }
    public static boolean isHighCard(String[] hand) {
        Map<String, Integer> cardFrequency = new HashMap<>();

        for (String card : hand) {
            cardFrequency.put(card, cardFrequency.getOrDefault(card, 0) + 1);
        }

        for (int freq : cardFrequency.values()) {
            if (freq != 1) {

                return false;
            }
        }

        return true;
    }

    public static boolean isOnePair(String[] hand) {
        Map<String, Integer> cardFrequency = new HashMap<>();

        for (String card : hand) {
            cardFrequency.put(card, cardFrequency.getOrDefault(card, 0) + 1);
        }

        boolean hasOnePair = false;
        int singleCardsCount = 0;

        for (int freq : cardFrequency.values()) {
            if (freq == 2) {
                if (hasOnePair) {

                    return false;
                }
                hasOnePair = true;
            } else if (freq == 1) {
                singleCardsCount += 1;
            }
        }

        return hasOnePair && singleCardsCount == 3;
    }

    public static boolean isTwoPair(String[] hand) {
        Map<String, Integer> cardFrequency = new HashMap<>();

        for (String card : hand) {
            cardFrequency.put(card, cardFrequency.getOrDefault(card, 0) + 1);
        }

        int pairCount = 0;
        boolean hasSingleCard = false;

        for (int freq : cardFrequency.values()) {
            if (freq == 2) {
                pairCount++;
            } else if (freq == 1) {
                hasSingleCard = true;
            }
        }

        return pairCount == 2 && hasSingleCard;
    }

    public static boolean isThreeOfAKind(String[] hand) {
        Map<String, Integer> cardFrequency = new HashMap<>();

        for (String card : hand) {
            cardFrequency.put(card, cardFrequency.getOrDefault(card, 0) + 1);
        }

        boolean hasThreeOfAKind = false;
        int singleCardsCount = 0;

        for (int freq : cardFrequency.values()) {
            if (freq == 3) {
                hasThreeOfAKind = true;
            } else if (freq == 1) {
                singleCardsCount += 1;
            }
        }

        return hasThreeOfAKind && singleCardsCount == 2;
    }

    public static boolean isFullHouse(String[] hand) {
        Map<String, Integer> cardFrequency = new HashMap<>();

        for (String card : hand) {
            cardFrequency.put(card, cardFrequency.getOrDefault(card, 0) + 1);
        }

        boolean hasThreeOfAKind = false;
        boolean hasPair = false;

        for (int freq : cardFrequency.values()) {
            if (freq == 3) {
                hasThreeOfAKind = true;
            } else if (freq == 2) {
                hasPair = true;
            }
        }

        return hasThreeOfAKind && hasPair;
    }

    public static boolean isFourOfAKind(String[] hand) {
        Map<String, Integer> cardFrequency = new HashMap<>();

        for (String card : hand) {
            cardFrequency.put(card, cardFrequency.getOrDefault(card, 0) + 1);
        }

        for (int freq : cardFrequency.values()) {
            if (freq == 4) {
                return true;
            }
        }

        return false;
    }

    public static boolean isFiveOfAKind(String[] hand) {
        Map<String, Integer> cardFrequency = new HashMap<>();

        for (String card : hand) {
            cardFrequency.put(card, cardFrequency.getOrDefault(card, 0) + 1);
        }

        for (int freq : cardFrequency.values()) {
            if (freq == 5) {
                return true;
            }
        }

        return false;
    }

    public Map<String, Integer> matchHand() {

        String[] hand = getHand();
        Map<String, Integer> result = new HashMap<>();

        if (isHighCard(hand)) {
            result.put("Higher Card", 1);
            return result;
        }

        if (isOnePair(hand)) {
            result.put("One Pair", 2);
            return result;        }

        if (isTwoPair(hand)) {
            result.put("Two Pair", 3);
            return result;
        }

        if (isThreeOfAKind(hand)) {
            result.put("Three of a Kind", 4);
            return result;
        }

        if (isFullHouse(hand)) {
            result.put("Full House", 5);
            return result;
        }
        if (isFourOfAKind(hand)) {
            result.put("Four of a Kind", 6);
            return result;
        }

        if (isFiveOfAKind(hand)) {
            result.put("Five of a Kind", 7);
            return result;
        } else {
            result.put("Cannot classify", -1);
            return result;
        }
    }
}
