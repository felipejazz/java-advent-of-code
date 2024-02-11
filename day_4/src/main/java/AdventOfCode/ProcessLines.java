package AdventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProcessLines {

    private List<GameDetails> mapLine(String line) {
        List<GameDetails> numberDetailsList = new ArrayList<>();
        Pattern gameNumberPattern = Pattern.compile("Card\\s+(\\d{1,5}):");
        Pattern numbersPattern = Pattern.compile("((?:\\d+\\s*)+)\\|\\s*((?:\\d+\\s*)+)");
        Matcher gameNumberMatcher = gameNumberPattern.matcher(line);

        if (gameNumberMatcher.find()) {
            
            GameDetails gameDetails = new GameDetails();

            gameDetails.setGame(Integer.parseInt(gameNumberMatcher.group(1)));

            String numbersPart = line.substring(gameNumberMatcher.end()).trim();
            Matcher numbersMatcher = numbersPattern.matcher(numbersPart);
            if (numbersMatcher.find()) {
                List<Integer> gameNumbers = Arrays.stream(numbersMatcher.group(1).trim().split("\\s+"))
                                                  .map(Integer::parseInt)
                                                  .collect(Collectors.toList());
                gameDetails.setGameNumbers(gameNumbers);
                

                List<Integer> winningNumbers = Arrays.stream(numbersMatcher.group(2).trim().split("\\s+"))
                                                     .map(Integer::parseInt)
                                                     .collect(Collectors.toList());
                gameDetails.setWinningGames(winningNumbers); 
            }
            
            
            numberDetailsList.add(gameDetails);
        }
        return numberDetailsList;
    }

    public int run(List<String> lines) {

        int result = 0;
        for (String line : lines) {
            System.out.println(line);
            List<GameDetails> games = mapLine(line);

            for (GameDetails game : games){
                result += game.matchGame();
                System.err.println("CardNums: " + game.getGameNumbers());
                System.err.println("WinningNums: " + game.getWinningGame());
                System.err.println("MatchedNums: " + game.getGameMatches());
                System.err.println("GameResult: " + game.matchGame());
            }
            
        }
        return result;
    }
}
