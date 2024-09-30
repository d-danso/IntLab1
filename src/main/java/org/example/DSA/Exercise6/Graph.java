package org.example.DSA.Exercise6;

import java.util.*;

class Graph {
    private final int vertices;
    private final List<List<Node>> adj;

    Graph(int vertices) {
        this.vertices = vertices;
        adj = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++)
            adj.add(new LinkedList<>());
    }

    static class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node() {
        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.cost, node2.cost);
        }
    }

    void addEdge(int u, int v, int cost) {
        adj.get(u).add(new Node(v, cost));
        adj.get(v).add(new Node(u, cost));
    }

    void primMST() {
        boolean[] inMST = new boolean[vertices];
        PriorityQueue<Node> pq = new PriorityQueue<>(vertices, new Node());
        int[] key = new int[vertices];
        int[] parent = new int[vertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        pq.add(new Node(0, 0));
        key[0] = 0;
        parent[0] = -1;

        while (!pq.isEmpty()) {
            int u = pq.poll().node;
            inMST[u] = true;

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.cost;
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Node(v, key[v]));
                    parent[v] = u;
                }
            }
        }

        System.out.println("Minimum Spanning Tree:");
        for (int i = 1; i < vertices; i++)
            System.out.println(parent[i] + " - " + i);
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);

        g.primMST();
    }
}

