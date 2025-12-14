package adventofcode.problem03;

public class Utils {
    public boolean checkCharAtIndex(char c, int index, char[] array) {
        return index < array.length && array[index] == c;
    }
}
