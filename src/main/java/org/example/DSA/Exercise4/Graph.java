package org.example.DSA.Exercise4;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Graph {
    private final int vertices;
    private final List<List<Integer>> adjacencyList;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList<>();
        for (int i = 0; i < vertices; i++)
            adjacencyList.add(new LinkedList<>());
    }

    void addEdge(int v, int w) {
        adjacencyList.get(v).add(w);
    }

    void DFS(int v) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(v);

        while (!stack.isEmpty()) {
            v = stack.pop();

            if (!visited[v]) {
                System.out.print(v + " ");
                visited[v] = true;
            }

            for (int n : adjacencyList.get(v)) {
                if (!visited[n])
                    stack.push(n);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Traversal starting from vertex 2:");

        g.DFS(2);
    }
}
