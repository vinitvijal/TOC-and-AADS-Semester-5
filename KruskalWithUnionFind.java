import java.util.*;

// Class to represent an edge in the graph
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    // Constructor
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Compare edges based on their weights
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

// Main class
public class KruskalWithUnionFind {
    private int[] parent;
    private int[] size;

    // Initialize Union-Find with size array
    public KruskalWithUnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Find the root of a set with path compression
    public int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    // Union two sets based on size
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            // Attach the smaller set under the larger set
            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            } else {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }
    }

    // Kruskal's Algorithm
    public static void kruskalMST(int n, List<Edge> edges) {
        // Sort edges by weight
        Collections.sort(edges);

        // Initialize Union-Find
        KruskalWithUnionFind uf = new KruskalWithUnionFind(n);

        // List to store the edges of the MST
        List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;

        // Iterate through the sorted edges
        for (Edge edge : edges) {
            // Check if adding the edge forms a cycle
            if (uf.find(edge.src) != uf.find(edge.dest)) {
                uf.union(edge.src, edge.dest);
                mst.add(edge);
                mstWeight += edge.weight;
            }
        }

        // Output the MST
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }

    // Main method
    public static void main(String[] args) {
        int n = 6; // Number of vertices

        // List of edges (src, dest, weight)
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 3, 6));
        edges.add(new Edge(2, 3, 8));
        edges.add(new Edge(3, 4, 9));
        edges.add(new Edge(4, 5, 10));
        edges.add(new Edge(3, 5, 7));

        // Compute MST
        kruskalMST(n, edges);
    }
}
