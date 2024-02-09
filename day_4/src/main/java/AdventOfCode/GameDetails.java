package AdventOfCode;

import java.util.List;
import java.util.ArrayList;


class GameDetails {
    private Integer game;
    private List<Integer> gameNumbers = new ArrayList<>();
    private List<Integer> winningGame = new ArrayList<>();
    private List<Integer> gameMatches = new ArrayList<>();

    
    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

    public void setGameMatches(List<Integer> gameMatches) {
        this.gameMatches = gameMatches;
    }

    public List<Integer> getGameNumbers() {
        return this.gameNumbers;
    }

    public List<Integer> getGameMatches() {
        return gameMatches;
    }


    public void setGameNumbers(List<Integer> gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public List<Integer> getWinningGame() {
        return winningGame;
    }

    public void setWinningGames(List<Integer> winningGame) {
        this.winningGame = winningGame;
    }

    public int matchGame() {
        List<Integer> gameNumbers = getGameNumbers();
        List<Integer> winningNumbers = getWinningGame();
        int score = 0; 
        int matches = 0; 
    
        
        for (int number : gameNumbers) {
            if (winningNumbers.contains(number)) {
                matches++;
                gameMatches.add(number);
            }
        }
        setGameMatches(gameMatches);
        if (matches > 0) {    
            score = 1 << (matches - 1);
        }
    
        return score;
    }
    
    @Override
    public String toString() {
        return "GameDetails: " +
                "game=" + game +
                ", gameNumbers=" + gameNumbers +
                ", winnnigGame=" + winningGame;
    }
}