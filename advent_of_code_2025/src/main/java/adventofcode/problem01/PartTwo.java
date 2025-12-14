package adventofcode.problem01;

import java.util.List;

public class PartTwo {
    public int updateDial(int current, String command) {
        char direction = command.charAt(0);
        int magnitude = Integer.parseInt(command.substring(1));
        if (direction == 'L') {
            current -= magnitude;
        } else {
            current += magnitude;
        }
        return current;
    }

    public int countAllZeroes(List<String> commands) {
        int current = 50;
        int result = 0;
        for (String command : commands) {
            int updated = updateDial(current, command);
            if (current > 0 && updated < 0) {
                result++;
                result += (current / 100) - (updated / 100);
            } else if (current < 0 && updated > 0) {
                result++;
                result += (updated / 100) - (current / 100);
            } else {
                result += Math.abs((updated/100) + (current/100));
            }
            if (updated == 0) {
                result++;
            }

            if (updated >= 100) {
                updated %= 100;
            } else if (updated < 0) {
                updated = (Math.abs(updated % 100) == 0) ? 0 : 100 - Math.abs(updated % 100);
            }
            current = updated;
        }
        return result;
    }
}
