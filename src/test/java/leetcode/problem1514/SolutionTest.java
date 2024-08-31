package leetcode.problem1514;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void shouldBe1forOneEdgeOfProbability1() {
        int n = 2;
        int[][] edges = new int[][]{
                new int[]{0, 1}
        };
        double[] succProb = new double[]{1.0};
        int startNode = 0;
        int endNode = 1;
        double result = solution.maxProbability(n, edges, succProb, startNode, endNode);
        Assertions.assertEquals(1.0, result, 0.00001);
    }

    @Test
    void shouldBe0p5forOneEdgeOfProbability0p5() {
        int n = 2;
        int[][] edges = new int[][]{
                new int[]{0, 1}
        };
        double[] succProb = new double[]{0.5};
        int startNode = 0;
        int endNode = 1;
        double result = solution.maxProbability(n, edges, succProb, startNode, endNode);
        Assertions.assertEquals(0.5, result, 0.00001);
    }

    @Test
    void shouldBe0p25forTwoEdgesOfProbability0p5() {
        int n = 3;
        int[][] edges = new int[][]{
                new int[]{0, 1},
                new int[]{1, 2}
        };
        double[] succProb = new double[]{0.5, 0.5};
        int startNode = 0;
        int endNode = 2;
        double result = solution.maxProbability(n, edges, succProb, startNode, endNode);
        Assertions.assertEquals(0.25, result, 0.00001);
    }

    @Test
    void shouldAvoidCycles() {
        int n = 3;
        int[][] edges = new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{0, 2}
        };
        double[] succProb = new double[]{0.5, 0.5, 0.5};
        int startNode = 0;
        int endNode = 2;
        double result = solution.maxProbability(n, edges, succProb, startNode, endNode);
        Assertions.assertEquals(0.5, result, 0.00001);
    }

    @Test
    void shouldBe0ifNoPath() {
        int n = 2;
        int[][] edges = new int[][]{};
        double[] succProb = new double[]{};
        int startNode = 0;
        int endNode = 1;
        double result = solution.maxProbability(n, edges, succProb, startNode, endNode);
        Assertions.assertEquals(0.0, result, 0.00001);
    }
}