package adventofcode.problem23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class PartOneTest {
    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        this.testUtils = new TestUtils();
    }

    @Test
    void shouldBePartyWithThreeInterconnectedComputers() {
        Set<Connection> connections = Set.of(
                new Connection("a", "b"),
                new Connection("b", "c"),
                new Connection("a", "c")
        );
        PartOne partOne = new PartOne(connections);
        Set<Set<String>> parties = partOne.getParties();
        Assertions.assertEquals(1, parties.size());
    }

    @Test
    void shouldBe12partiesForAdventOfCodeExample() throws Exception {
        Set<Connection> connections = testUtils.loadFromFile("problem23_example.txt");
        PartOne partOne = new PartOne(connections);
        Set<Set<String>> parties = partOne.getParties();
        Assertions.assertEquals(12, parties.size());
    }

    @Test
    void shouldBe7partiesContainingComputerStartingWithTforAdventOfCodeExample() throws Exception {
        Set<Connection> connections = testUtils.loadFromFile("problem23_example.txt");
        PartOne partOne = new PartOne(connections);
        Set<Set<String>> parties = partOne.getParties();
        int countOfPartiesContainingComputerStartingWithT = 0;
        for (Set<String> party : parties) {
            if (party.stream().anyMatch(s -> s.startsWith("t"))) {
                countOfPartiesContainingComputerStartingWithT++;
            }
        }
        Assertions.assertEquals(7, countOfPartiesContainingComputerStartingWithT);
    }

    @Test
    void shouldBe1156partiesContainingComputerStartingWithTforAdventOfCodeInput() throws Exception {
        Set<Connection> connections = testUtils.loadFromFile("problem23_input.txt");
        PartOne partOne = new PartOne(connections);
        Set<Set<String>> parties = partOne.getParties();
        int countOfPartiesContainingComputerStartingWithT = 0;
        for (Set<String> party : parties) {
            if (party.stream().anyMatch(s -> s.startsWith("t"))) {
                countOfPartiesContainingComputerStartingWithT++;
            }
        }
        Assertions.assertEquals(1156, countOfPartiesContainingComputerStartingWithT);
    }
}