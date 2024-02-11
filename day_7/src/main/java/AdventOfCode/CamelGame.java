package AdventOfCode;

import java.util.*;

class CamelGame {

    private List<Player> playersList = new ArrayList<>();
    private List<Player> playersRanked;
    private static final Map<String, Integer> cardValues = createCardValuesMap();

    private static Map<String, Integer> createCardValuesMap() {

        return Map.ofEntries(Map.entry("A", 14),
                Map.entry("K", 13), Map.entry("Q", 12), Map.entry("J", 11), Map.entry("T", 10), Map.entry("9", 9), Map.entry("8", 8), Map.entry("7", 7), Map.entry("6", 6), Map.entry("5", 5), Map.entry("4", 4), Map.entry("3", 3), Map.entry("2", 2));
    }
    public void setPlayers(List<Player> playersList) {
        this.playersList = playersList;
    }

    public void addPlayer(Player player) {
        this.playersList.add(player);
    }

    public List<Player> getPlayers() {
        return this.playersList;
    }

    public List<Player> getRankedPlayer() {
        return this.playersRanked;
    }

    public void rankHands() {
        List<Player> playersList = getPlayers();

        Collections.sort(playersList, (player1, player2) -> {

            int scoreComparison = Integer.compare(player1.getHandValue(), player2.getHandValue());
            if (scoreComparison == 0) {
                String[] hand1 = player1.getHand();
                String[] hand2 = player2.getHand();

                for (int i = 0; i < hand1.length; i++) {
                    int rank1 = cardValues.get(hand1[i]);
                    int rank2 = cardValues.get(hand2[i]);
                    if (rank1 != rank2) {

                        return rank1 - rank2;
                    }
                }
            }
            return scoreComparison;
        });

        this.playersRanked = playersList;

    }

    public int totalWinnings() {
        int result = 0;
        for (int i = 0; i < this.playersRanked.size(); i++) {
            Player currentPlayer = this.playersRanked.get(i);
            System.out.println("Position i " + "Bid: " + currentPlayer.getBid() + "    HandValue: " + currentPlayer.getHandValue() + " PlayerHand: " + Arrays.toString(currentPlayer.getHand()));

            result += currentPlayer.getBid() * (i + 1);
        }
        return result;
    }
}
