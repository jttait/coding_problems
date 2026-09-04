package problem02;

import java.util.List;

public class Solution {
    public boolean isGamePossible(int reds, int greens, int blues, Game game) {
        for (Reveal reveal : game.reveals()) {
            if (reveal.reds() > reds) {
                return false;
            }
            if (reveal.greens() > greens) {
                return false;
            }
            if (reveal.blues() > blues) {
                return false;
            }
        }
        return true;
    }

    public int sumIdsOfPossibleGames(int reds, int greens, int blues, List<Game> games) {
        int result = 0;
        for (Game game : games) {
            if (isGamePossible(reds, greens, blues, game)) {
                result += game.id();
            }
        }
        return result;
    }

    public int calculateMinimumPowerOfGame(Game game) {
        int maxRed = Integer.MIN_VALUE;
        int maxGreen = Integer.MIN_VALUE;
        int maxBlue = Integer.MIN_VALUE;
        for (Reveal reveal : game.reveals()) {
            maxRed = Math.max(maxRed, reveal.reds());
            maxGreen = Math.max(maxGreen, reveal.greens());
            maxBlue = Math.max(maxBlue, reveal.blues());
        }
        return maxRed * maxGreen * maxBlue;
    }

    public int sumMinimumPowersOfGames(List<Game> games) {
        int result = 0;
        for (Game game : games) {
            result += calculateMinimumPowerOfGame(game);
        }
        return result;
    }
}
