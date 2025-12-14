package adventofcode.problem23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class PartTwoTest {
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
        PartTwo partTwo = new PartTwo(connections);
        Set<String> largestParty = partTwo.findLargestFullyInterconnectedParty();
        Assertions.assertEquals(3, largestParty.size());
    }

    @Test
    void shouldBePartyWith4interconnectedComputersForAdventOfCodeExample() throws Exception {
        Set<Connection> connections = testUtils.loadFromFile("problem23_example.txt");
        PartTwo partTwo = new PartTwo(connections);
        Set<String> largestParty = partTwo.findLargestFullyInterconnectedParty();
        List<String> sorted = sortComputerNamesAlphabetically(largestParty);
        String result = convertToCommaSeparatedString(sorted);
        Assertions.assertEquals("co,de,ka,ta", result);
    }

    @Test
    void shouldBePartyWith4interconnectedComputersForAdventOfCodeInput() throws Exception {
        Set<Connection> connections = testUtils.loadFromFile("problem23_input.txt");
        PartTwo partTwo = new PartTwo(connections);
        Set<String> largestParty = partTwo.findLargestFullyInterconnectedParty();
        List<String> sorted = sortComputerNamesAlphabetically(largestParty);
        String result = convertToCommaSeparatedString(sorted);
        Assertions.assertEquals("bx,cx,dr,dx,is,jg,km,kt,li,lt,nh,uf,um", result);
    }

    private List<String> sortComputerNamesAlphabetically(Set<String> computers) {
        return computers.stream().sorted().toList();
    }

    private String convertToCommaSeparatedString(List<String> computers) {
        StringBuilder result = new StringBuilder();
        for (String computer : computers) {
            result.append(computer);
            result.append(",");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}