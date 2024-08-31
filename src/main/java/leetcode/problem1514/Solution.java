package leetcode.problem1514;

import java.util.*;

public class Solution {
    private Map<Integer, Set<Integer>> adjacencyList;
    private Map<Integer, Map<Integer, Double>> successProbabilities;
    private double result;

    public double maxProbability(int n, int[][] edges, double[] succProb, int startNode, int endNode) {
        this.adjacencyList = convertEdgesToAdjacencyList(edges);
        this.successProbabilities = convertSuccProbToMapOfMaps(edges, succProb);
        this.result = 0;
        djikstras(startNode, endNode, n);
        return this.result;
    }

    private void djikstras(int startNode, int endNode, int numNodes) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<Integer, Integer> prev = new HashMap<>();
        Map<Integer, Double> dist = new HashMap<>();
        dist.put(startNode, 1.0);
        pq.add(new Node(startNode, 1.0));
        for (int i = 0; i < numNodes; i++) {
            if (i != startNode) {
                prev.put(i, -1);
                dist.put(i, 0.0);
                pq.add(new Node(i, 0.0));
            }
        }
        while (!pq.isEmpty()) {
            int u = pq.poll().getIndex();
            if (adjacencyList.containsKey(u)) {
                for (int v : adjacencyList.get(u)) {
                    double alt = dist.get(u) * successProbabilities.get(u).get(v);
                    if (alt > dist.get(v)) {
                        prev.put(v, u);
                        dist.put(v, alt);
                        pq.add(new Node(v, alt));
                    }
                }
            }
        }
        this.result = dist.get(endNode);
    }

    private Map<Integer, Map<Integer, Double>> convertSuccProbToMapOfMaps(int[][] edges, double[] succProb) {
        Map<Integer, Map<Integer, Double>> result = new HashMap<>();
        for (int i = 0; i < succProb.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            double probability = succProb[i];
            result.putIfAbsent(node1, new HashMap<>());
            result.putIfAbsent(node2, new HashMap<>());
            result.get(node1).put(node2, probability);
            result.get(node2).put(node1, probability);
        }
        return result;
    }

    private Map<Integer, Set<Integer>> convertEdgesToAdjacencyList(int[][] edges) {
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int[] edge : edges) {
            result.putIfAbsent(edge[0], new HashSet<>());
            result.get(edge[0]).add(edge[1]);
            result.putIfAbsent(edge[1], new HashSet<>());
            result.get(edge[1]).add(edge[0]);
        }
        return result;
    }
}

class Node implements Comparable<Node> {
    private final int index;
    private final double probability;

    public Node(int index, double probability) {
        this.index = index;
        this.probability = probability;
    }

    public int getIndex() {
        return this.index;
    }

    public double getProbability() {
        return this.probability;
    }

    @Override
    public int compareTo(Node o) {
        if (o.getProbability() > this.probability) {
            return 1;
        } else if (o.getProbability() < this.probability) {
            return -1;
        }
        return 0;
    }
}
