package adventofcode.problem24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class PartOneTest {
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe4forFirstAdventOfCodeExample() throws Exception {
        Map<String, Wire> wires = testUtils.loadWiresFromFile("problem24_part1_example1.txt");
        List<Gate> gates = testUtils.loadGatesFromFile("problem24_part1_example1.txt", wires);
        PartOne partOne = new PartOne(gates);
        partOne.simulate();
        String s = testUtils.convertWiresToBinaryString(wires);
        long result = testUtils.convertBinaryStringToDecimalNumber(s);
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe2024forSecondAdventOfCodeExample() throws Exception {
        Map<String, Wire> wires = testUtils.loadWiresFromFile("problem24_part1_example2.txt");
        List<Gate> gates = testUtils.loadGatesFromFile("problem24_part1_example2.txt", wires);
        PartOne partOne = new PartOne(gates);
        partOne.simulate();
        String s = testUtils.convertWiresToBinaryString(wires);
        long result = testUtils.convertBinaryStringToDecimalNumber(s);
        Assertions.assertEquals(2024, result);
    }

    @Test
    void shouldBe58740594706150forAdventOfCodeInput() throws Exception {
        Map<String, Wire> wires = testUtils.loadWiresFromFile("problem24_input.txt");
        List<Gate> gates = testUtils.loadGatesFromFile("problem24_input.txt", wires);
        PartOne partOne = new PartOne(gates);
        partOne.simulate();
        String s = testUtils.convertWiresToBinaryString(wires);
        long result = testUtils.convertBinaryStringToDecimalNumber(s);
        Assertions.assertEquals(58740594706150L, result);
    }
}