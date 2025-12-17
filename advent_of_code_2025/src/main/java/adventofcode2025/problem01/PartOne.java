package adventofcode2025.problem01;

import java.util.List;

public class PartOne {
    public int updateDial(int current, String command) {
        char direction = command.charAt(0);
        int magnitude = Integer.parseInt(command.substring(1));
        if (direction == 'L') {
            current -= magnitude;
        } else {
            current += magnitude;
        }
        if (current >= 100) {
            current %= 100;
        } else if (current < 0) {
            current = (Math.abs(current % 100) == 0) ? 0 : 100 - Math.abs(current % 100);
        }
        return current;
    }

    public int countZeroes(List<String> commands) {
        int current = 50;
        int result = 0;
        for (String command : commands) {
            current = updateDial(current, command);
            if (current == 0) {
                result++;
            }
        }
        return result;
    }
}
