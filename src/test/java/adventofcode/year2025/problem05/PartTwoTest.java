package adventofcode.year2025.problem05;

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
    void shouldBe1for1and1() {
        IngredientsDatabase ingredientsDatabase = new IngredientsDatabase(
                List.of(new Range(1L, 1L)),
                Set.of()
        );
        long result = ingredientsDatabase.countAllPossibleFreshIngredients();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe0forEmptyFreshSet() {
        IngredientsDatabase ingredientsDatabase = new IngredientsDatabase(
                List.of(),
                Set.of()
        );
        long result = ingredientsDatabase.countAllPossibleFreshIngredients();
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe1for2and2() {
        IngredientsDatabase ingredientsDatabase = new IngredientsDatabase(
                List.of(new Range(2L, 2L)),
                Set.of()
        );
        long result = ingredientsDatabase.countAllPossibleFreshIngredients();
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2for1and2and1and2() {
        IngredientsDatabase ingredientsDatabase = new IngredientsDatabase(
                List.of(new Range(1L, 2L)),
                Set.of()
        );
        long result = ingredientsDatabase.countAllPossibleFreshIngredients();
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe14forAdventOfCodeExample() throws Exception {
        IngredientsDatabase ingredientsDatabase = testUtils.loadFromFile("adventofcode/year2025/problem05_example.txt");
        long result = ingredientsDatabase.countAllPossibleFreshIngredients();
        Assertions.assertEquals(14, result);
    }

    @Test
    void shouldBe345995423801866forAdventOfCodeInput() throws Exception {
        IngredientsDatabase ingredientsDatabase = testUtils.loadFromFile("adventofcode/year2025/problem05_input.txt");
        long result = ingredientsDatabase.countAllPossibleFreshIngredients();
        Assertions.assertEquals(345995423801866L, result);
    }
}