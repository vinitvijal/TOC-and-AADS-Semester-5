import java.util.*;

class Edge {
    int src, dest, weight;

    // Constructor
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class BellmanFord {

    // Bellman-Ford algorithm
    public static void bellmanFord(int vertices, List<Edge> edges, int source) {
        // Step 1: Initialize distances from the source to all other vertices as infinity
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Step 2: Relax all edges |V| - 1 times
        for (int i = 0; i < vertices - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.src] != Integer.MAX_VALUE && distance[edge.src] + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = distance[edge.src] + edge.weight;
                }
            }
        }

        // Step 3: Check for negative-weight cycles
        for (Edge edge : edges) {
            if (distance[edge.src] != Integer.MAX_VALUE && distance[edge.src] + edge.weight < distance[edge.dest]) {
                System.out.println("Graph contains a negative-weight cycle.");
                return;
            }
        }

        // Print the result
        System.out.println("Vertex distances from source " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + (distance[i] == Integer.MAX_VALUE ? "Infinity" : distance[i]));
        }
    }

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices
        List<Edge> edges = new ArrayList<>();

        // Define the edges of the graph (src, dest, weight)
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        // Source vertex
        int source = 0;

        // Run Bellman-Ford
        bellmanFord(vertices, edges, source);
    }
}
