package adventofcode.year2024.problem03;

public class PartTwo {
    private int index;
    private  char[] array;
    private Utils utils;
    private boolean enabled;

    public int parseSection(String s) {
        this.index = 0;
        this.array = s.toCharArray();
        this.utils = new Utils();
        this.enabled = true;
        int result = 0;
        while (this.index < this.array.length) {
            if (enabled && this.array[this.index] == 'm') {
                result += tryMul();
            } else if (this.array[this.index] == 'd') {
                tryDoDont();
            } else {
                this.index++;
            }
        }
        return result;
    }

    private void tryDoDont() {
        if (!utils.checkCharAtIndex('d', this.index, this.array)) {
            return;
        }
        this.index++;
        if (!utils.checkCharAtIndex('o', this.index, this.array)) {
            return;
        }
        this.index++;
        if (utils.checkCharAtIndex('(', this.index, this.array)) {
            this.index++;
            if (utils.checkCharAtIndex(')', this.index, this.array)) {
                this.index++;
                this.enabled = true;
            }
            return;
        }
        if (!utils.checkCharAtIndex('n', this.index, this.array)) {
            return;
        }
        this.index++;
        if (!utils.checkCharAtIndex('\'', this.index, this.array)) {
            return;
        }
        this.index++;
        if (!utils.checkCharAtIndex('t', this.index, this.array)) {
            return;
        }
        this.index++;
        if (!utils.checkCharAtIndex('(', this.index, this.array)) {
            return;
        }
        this.index++;
        if (!utils.checkCharAtIndex(')', this.index, this.array)) {
            return;
        }
        this.index++;
        this.enabled = false;
    }

    private int tryMul() {
        if (!utils.checkCharAtIndex('m', this.index, this.array)) {
            return 0;
        }
        this.index++;
        if (!utils.checkCharAtIndex('u', this.index, this.array)) {
            return 0;
        }
        this.index++;
        if (!utils.checkCharAtIndex('l', this.index, this.array)) {
            return 0;
        }
        this.index++;
        if (!utils.checkCharAtIndex('(', this.index, this.array)) {
            return 0;
        }
        this.index++;
        StringBuilder firstNumberStringBuilder = new StringBuilder();
        while (Character.isDigit(this.array[this.index])) {
            firstNumberStringBuilder.append(this.array[this.index]);
            this.index++;
        }
        int firstNumber = Integer.parseInt(firstNumberStringBuilder.toString());
        if (!utils.checkCharAtIndex(',', this.index, this.array)) {
            return 0;
        }
        this.index++;
        StringBuilder secondNumberStringBuilder = new StringBuilder();
        while (this.index < this.array.length && Character.isDigit(this.array[this.index])) {
            secondNumberStringBuilder.append(this.array[this.index]);
            this.index++;
        }
        int secondNumber = Integer.parseInt(secondNumberStringBuilder.toString());
        if (!utils.checkCharAtIndex(')', this.index, this.array)) {
            return 0;
        }
        this.index++;
        return firstNumber * secondNumber;
    }
}
