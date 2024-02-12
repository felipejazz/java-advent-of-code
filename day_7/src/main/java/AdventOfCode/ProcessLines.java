package AdventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessLines {


    public List<Player> run(List<String> lines) {

        List<Player> playersList = new ArrayList<>();
        for (String line : lines) {
            Player player = new Player();
            processLine(line, player);
            playersList.add(player);

        }
        return playersList;

    }

    private void processLine(String line, Player player) {

        Pattern pattern = Pattern.compile("([A-Z0-9]+) (\\d+)");
        Matcher matcher = pattern.matcher(line);


        if (matcher.find()) {
            String hand = matcher.group(1);
            int bid = Integer.parseInt(matcher.group(2));
            player.setHand(hand.split(""));
            player.setBid(bid);
        }
    }
}

