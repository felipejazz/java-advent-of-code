package AdventOfCode;

import java.util.Map;

public class Player {

    private  String[] hand;
    private int bid;
    private final HandManager HandManager= new HandManager();

    private int handValue;

    public void setHand( String[] hand ) {
        this.hand = hand;
    }
    public String[] getHand () {
        return this.hand;
    }

    public void setBid (int bid ) {
        this.bid = bid;
    }

    public int getBid () {
        return this.bid;
    }

    public int getHandValue() {
        return this.handValue;
    }

    public Map<String, Integer> playHand() {
        String[] playerHand = getHand();
        HandManager.setHand(playerHand);
        Map <String, Integer> result = HandManager.matchHand();
        String key = result.keySet().stream().findFirst().orElse(null);
        this.handValue = result.get(key);

        return result;

    }


}

