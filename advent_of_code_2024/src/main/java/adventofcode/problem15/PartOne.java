package adventofcode.problem15;

import java.util.List;

public class PartOne {
    private List<List<Character>> grid;
    private int robotX;
    private int robotY;

    public PartOne(List<List<Character>> grid) {
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
                if (grid.get(robotY).get(robotX-1) == '.') {
                    this.grid.get(robotY).set(robotX, '.');
                    this.grid.get(robotY).set(robotX-1, '@');
                    this.robotX -= 1;
                } else if (grid.get(robotY).get(robotX-1) == 'O') {
                    boolean result = tryToMoveBoxLeft(robotX-1, robotY);
                    if (result) {
                        this.grid.get(robotY).set(robotX, '.');
                        this.grid.get(robotY).set(robotX-1, '@');
                        this.robotX -= 1;
                    }
                }
            } else if (command == Command.RIGHT) {
                if (grid.get(robotY).get(robotX+1) == '.') {
                    this.grid.get(robotY).set(robotX, '.');
                    this.grid.get(robotY).set(robotX+1, '@');
                    this.robotX += 1;
                } else if (grid.get(robotY).get(robotX+1) == 'O') {
                    boolean result = tryToMoveBoxRight(robotX+1, robotY);
                    if (result) {
                        this.grid.get(robotY).set(robotX, '.');
                        this.grid.get(robotY).set(robotX+1, '@');
                        this.robotX += 1;
                    }
                }
            } else if (command == Command.UP) {
                if (grid.get(robotY-1).get(robotX) == '.') {
                    this.grid.get(robotY).set(robotX, '.');
                    this.grid.get(robotY-1).set(robotX, '@');
                    this.robotY -= 1;
                } else if (grid.get(robotY-1).get(robotX) == 'O') {
                    boolean result = tryToMoveBoxUp(robotX, robotY-1);
                    if (result) {
                        this.grid.get(robotY).set(robotX, '.');
                        this.grid.get(robotY-1).set(robotX, '@');
                        this.robotY -= 1;
                    }
                }
            } else if (command == Command.DOWN) {
                if (grid.get(robotY+1).get(robotX) == '.') {
                    this.grid.get(robotY).set(robotX, '.');
                    this.grid.get(robotY+1).set(robotX, '@');
                    this.robotY += 1;
                } else if (grid.get(robotY+1).get(robotX) == 'O') {
                    boolean result = tryToMoveBoxDown(robotX, robotY+1);
                    if (result) {
                        this.grid.get(robotY).set(robotX, '.');
                        this.grid.get(robotY+1).set(robotX, '@');
                        this.robotY += 1;
                    }
                }
            }
        }
    }

    private boolean tryToMoveBoxLeft(int x, int y) {
        while (grid.get(y).get(x) == 'O') {
            x--;
        }
        if (grid.get(y).get(x) == '#') {
            return false;
        }
        while (grid.get(y).get(x) != '@') {
            grid.get(y).set(x, 'O');
            x++;
        }
        grid.get(y).set(x-1, '.');
        return true;
    }

    private boolean tryToMoveBoxRight(int x, int y) {
        while (grid.get(y).get(x) == 'O') {
            x++;
        }
        if (grid.get(y).get(x) == '#') {
            return false;
        }
        while (grid.get(y).get(x) != '@') {
            grid.get(y).set(x, 'O');
            x--;
        }
        grid.get(y).set(x+1, '.');
        return true;
    }

    private boolean tryToMoveBoxUp(int x, int y) {
        while (grid.get(y).get(x) == 'O') {
            y--;
        }
        if (grid.get(y).get(x) == '#') {
            return false;
        }
        while (grid.get(y).get(x) != '@') {
            grid.get(y).set(x, 'O');
            y++;
        }
        grid.get(y-1).set(x, '.');
        return true;
    }

    private boolean tryToMoveBoxDown(int x, int y) {
        while (grid.get(y).get(x) == 'O') {
            y++;
        }
        if (grid.get(y).get(x) == '#') {
            return false;
        }
        while (grid.get(y).get(x) != '@') {
            grid.get(y).set(x, 'O');
            y--;
        }
        grid.get(y+1).set(x, '.');
        return true;
    }

    public int sumBoxGpsCoordinates(List<List<Character>> grid) {
        int result = 0;
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (grid.get(y).get(x) == 'O') {
                    result += 100 * y + x;
                }
            }
        }
        return result;
    }
}
