package adventofcode.year2024.problem03;

public class PartOne {
    private int index;
    private char[] array;
    private Utils utils;

    public int parseSection(String s) {
        this.index = 0;
        this.array = s.toCharArray();
        this.utils = new Utils();
        int result = 0;
        while (this.index < this.array.length) {
            if (this.array[this.index] != 'm') {
                this.index++;
            } else {
                result += tryMul();
            }
        }
        return result;
    }

    public int tryMul() {
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
