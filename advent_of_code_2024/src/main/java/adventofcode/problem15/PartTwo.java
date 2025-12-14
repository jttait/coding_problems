package adventofcode.problem15;

import adventofcode.problem15.Command;

import java.util.*;

public class PartTwo {
    private List<List<Character>> grid;
    private int robotX;
    private int robotY;

    public PartTwo(List<List<Character>> grid) {
        this.grid = grid;
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (grid.get(y).get(x) == '@') {
                    this.robotX = x;
                    this.robotY = y;
                }
            }
        }
    }

    public void simulate(List<Command> commands) {
        for (Command command : commands) {
            if (command == Command.LEFT) {
                if (grid.get(robotY).get(robotX - 1) == '.') {
                    this.grid.get(robotY).set(robotX, '.');
                    this.grid.get(robotY).set(robotX - 1, '@');
                    this.robotX -= 1;
                } else if (grid.get(robotY).get(robotX - 1) == ']') {
                    boolean result = tryToMoveBoxLeft(robotX - 1, robotY);
                    if (result) {
                        this.grid.get(robotY).set(robotX, '.');
                        this.grid.get(robotY).set(robotX - 1, '@');
                        this.robotX -= 1;
                    }
                }
            } else if (command == Command.RIGHT) {
                if (grid.get(robotY).get(robotX + 1) == '.') {
                    this.grid.get(robotY).set(robotX, '.');
                    this.grid.get(robotY).set(robotX + 1, '@');
                    this.robotX += 1;
                } else if (grid.get(robotY).get(robotX + 1) == '[') {
                    boolean result = tryToMoveBoxRight(robotX + 1, robotY);
                    if (result) {
                        this.grid.get(robotY).set(robotX, '.');
                        this.grid.get(robotY).set(robotX + 1, '@');
                        this.robotX += 1;
                    }
                }
            } else if (command == Command.UP) {
                if (grid.get(robotY - 1).get(robotX) == '.') {
                    this.grid.get(robotY).set(robotX, '.');
                    this.grid.get(robotY - 1).set(robotX, '@');
                    this.robotY -= 1;
                } else if (grid.get(robotY - 1).get(robotX) == '[' || grid.get(robotY - 1).get(robotX) == ']') {
                    tryToMoveBoxUp(robotX, robotY);
                }
            } else if (command == Command.DOWN) {
                if (grid.get(robotY + 1).get(robotX) == '.') {
                    this.grid.get(robotY).set(robotX, '.');
                    this.grid.get(robotY + 1).set(robotX, '@');
                    this.robotY += 1;
                } else if (grid.get(robotY + 1).get(robotX) == '[' || grid.get(robotY + 1).get(robotX) == ']') {
                    tryToMoveBoxDown(robotX, robotY);
                }
            }
        }
    }

    private boolean tryToMoveBoxLeft(int x, int y) {
        while (grid.get(y).get(x) == '[' || grid.get(y).get(x) == ']') {
            x--;
        }
        if (grid.get(y).get(x) == '#') {
            return false;
        }
        char c = '[';
        while (grid.get(y).get(x) != '@') {
            grid.get(y).set(x, c);
            c = (c == '[') ? ']' : '[';
            x++;
        }
        grid.get(y).set(x-1, '.');
        return true;
    }

    private boolean tryToMoveBoxRight(int x, int y) {
        while (grid.get(y).get(x) == '[' || grid.get(y).get(x) == ']') {
            x++;
        }
        if (grid.get(y).get(x) == '#') {
            return false;
        }
        char c = ']';
        while (grid.get(y).get(x) != '@') {
            grid.get(y).set(x, c);
            c = (c == '[') ? ']' : '[';
            x--;
        }
        grid.get(y).set(x + 1, '.');
        return true;
    }

    private void tryToMoveBoxUp(int x, int y) {
        Map<Integer, Set<Integer>> toBeMovedUp = new HashMap<>();
        toBeMovedUp.put(y, Set.of(x));
        while (!toBeMovedUp.get(y).isEmpty()) {
            y--;
            toBeMovedUp.put(y, new HashSet<>());
            for (int x1 : toBeMovedUp.get(y + 1)) {
                char c = grid.get(y).get(x1);
                if (c == '#') {
                    return;
                } else if (c == '[') {
                    toBeMovedUp.get(y).add(x1);
                    toBeMovedUp.get(y).add(x1 + 1);
                } else if (c == ']') {
                    toBeMovedUp.get(y).add(x1);
                    toBeMovedUp.get(y).add(x1 - 1);
                }
            }
        }
        y++;
        while (toBeMovedUp.containsKey(y)) {
            for (int x1 : toBeMovedUp.get(y)) {
                if (grid.get(y).get(x1) == '[') {
                    grid.get(y - 1).set(x1, '[');
                    grid.get(y).set(x1, '.');
                } else if (grid.get(y).get(x1) == ']') {
                    grid.get(y - 1).set(x1, ']');
                    grid.get(y).set(x1, '.');
                } else if (grid.get(y).get(x1) == '@') {
                    grid.get(y - 1).set(x1, '@');
                    grid.get(y).set(x1, '.');
                }
            }
            y++;
        }
        this.robotY -= 1;
    }

    private void tryToMoveBoxDown(int x, int y) {
        Map<Integer, Set<Integer>> toBeMovedDown = new HashMap<>();
        toBeMovedDown.put(y, Set.of(x));
        while (!toBeMovedDown.get(y).isEmpty()) {
            y++;
            toBeMovedDown.put(y, new HashSet<>());
            for (int x1 : toBeMovedDown.get(y - 1)) {
                char c = grid.get(y).get(x1);
                if (c == '#') {
                    return;
                } else if (c == '[') {
                    toBeMovedDown.get(y).add(x1);
                    toBeMovedDown.get(y).add(x1 + 1);
                } else if (c == ']') {
                    toBeMovedDown.get(y).add(x1);
                    toBeMovedDown.get(y).add(x1 - 1);
                }
            }
        }
        y--;
        while (toBeMovedDown.containsKey(y)) {
            for (int x1 : toBeMovedDown.get(y)) {
                if (grid.get(y).get(x1) == '[') {
                    grid.get(y + 1).set(x1, '[');
                    grid.get(y).set(x1, '.');
                } else if (grid.get(y).get(x1) == ']') {
                    grid.get(y + 1).set(x1, ']');
                    grid.get(y).set(x1, '.');
                } else if (grid.get(y).get(x1) == '@') {
                    grid.get(y + 1).set(x1, '@');
                    grid.get(y).set(x1, '.');
                }
            }
            y--;
        }
        this.robotY += 1;
    }

    public int sumBoxGpsCoordinates(List<List<Character>> grid) {
        int result = 0;
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (grid.get(y).get(x) == '[') {
                    result += 100 * y + x;
                }
            }
        }
        return result;
    }
}
