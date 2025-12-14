package adventofcode.problem14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartOneTest {
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBe1forImmobileRobotsInEachQuadrant() {
        List<Robot> robots = List.of(
                new Robot(0, 0, 0, 0),
                new Robot(10, 0, 0, 0),
                new Robot(0, 6, 0, 0),
                new Robot(10, 6, 0, 0)
        );
        PartOne partOne = new PartOne(robots, 11, 7);
        int result = partOne.calculateSafetyFactor(100);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forImmobileRobotsInEachQuadrant() {
        List<Robot> robots = List.of(
                new Robot(0, 0, 0, 0),
                new Robot(0, 0, 0, 0),
                new Robot(10, 0, 0, 0),
                new Robot(0, 6, 0, 0),
                new Robot(10, 6, 0, 0)
        );
        PartOne partOne = new PartOne(robots, 11, 7);
        int result = partOne.calculateSafetyFactor(100);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldMoveRobotsOneTick() {
        List<Robot> robots = List.of(
                new Robot(5, 3, 1, 1),
                new Robot(5, 3, -1, 1),
                new Robot(5, 3, -1, -1),
                new Robot(5, 3, 1, -1)
        );
        PartOne partOne = new PartOne(robots, 11, 7);
        int result = partOne.calculateSafetyFactor(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldWrapRobot() {
        List<Robot> robots = List.of(
                new Robot(0, 0, 0, 0),
                new Robot(10, 0, 0, 0),
                new Robot(0, 6, 0, 0),
                new Robot(0, 6, -1, 0)
        );
        PartOne partOne = new PartOne(robots, 11, 7);
        int result = partOne.calculateSafetyFactor(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe12forAdventOfCodeExample() {
        List<Robot> robots = List.of(
            new Robot(0, 4, 3, -3),
            new Robot(6, 3, -1, -3),
            new Robot(10,3, -1,2),
            new Robot(2,0, 2,-1),
            new Robot(0,0, 1,3),
            new Robot(3,0, -2,-2),
            new Robot(7,6, -1,-3),
            new Robot(3,0, -1,-2),
            new Robot(9,3, 2,3),
            new Robot(7,3, -1,2),
            new Robot(2,4, 2,-3),
            new Robot(9,5,-3,-3)
        );
        PartOne partOne = new PartOne(robots, 11, 7);
        int safetyFactor = partOne.calculateSafetyFactor(100);
        Assertions.assertEquals(12, safetyFactor);
    }

    @Test
    void shouldBe229839456forAdventOfCodeInput() throws Exception {
        List<Robot> robots = testUtils.loadFile("problem14_input.txt");
        PartOne partOne = new PartOne(robots, 101, 103);
        int safetyFactor = partOne.calculateSafetyFactor(100);
        Assertions.assertEquals(229839456, safetyFactor);
    }
}