class BTree {
    // Node of the B-Tree
    static class Node {
        int[] keys;     // Array of keys
        int t;          // Minimum degree (defines the range for the number of keys)
        Node[] children; // Array of child pointers
        int n;          // Current number of keys
        boolean isLeaf; // True if the node is a leaf

        // Constructor
        Node(int t, boolean isLeaf) {
            this.t = t;
            this.isLeaf = isLeaf;
            this.keys = new int[2 * t - 1];
            this.children = new Node[2 * t];
            this.n = 0;
        }
    }

    private Node root; // Root node
    private int t;     // Minimum degree

    // Constructor
    public BTree(int t) {
        this.root = null;
        this.t = t;
    }

    // Function to search a key in the B-Tree
    public Node search(int key) {
        return root == null ? null : search(root, key);
    }

    private Node search(Node node, int key) {
        int i = 0;
        while (i < node.n && key > node.keys[i]) {
            i++;
        }

        if (i < node.n && node.keys[i] == key) {
            return node;
        }

        if (node.isLeaf) {
            return null;
        }

        return search(node.children[i], key);
    }

    // Function to insert a key into the B-Tree
    public void insert(int key) {
        if (root == null) {
            root = new Node(t, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                Node newRoot = new Node(t, false);
                newRoot.children[0] = root;
                splitChild(newRoot, 0, root);
                int i = (newRoot.keys[0] < key) ? 1 : 0;
                insertNonFull(newRoot.children[i], key);
                root = newRoot;
            } else {
                insertNonFull(root, key);
            }
        }
    }

    private void insertNonFull(Node node, int key) {
        int i = node.n - 1;
        if (node.isLeaf) {
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.n++;
        } else {
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }
            i++;
            if (node.children[i].n == 2 * t - 1) {
                splitChild(node, i, node.children[i]);
                if (node.keys[i] < key) {
                    i++;
                }
            }
            insertNonFull(node.children[i], key);
        }
    }

    private void splitChild(Node parent, int i, Node child) {
        Node newChild = new Node(t, child.isLeaf);
        newChild.n = t - 1;

        for (int j = 0; j < t - 1; j++) {
            newChild.keys[j] = child.keys[j + t];
        }

        if (!child.isLeaf) {
            for (int j = 0; j < t; j++) {
                newChild.children[j] = child.children[j + t];
            }
        }

        child.n = t - 1;

        for (int j = parent.n; j >= i + 1; j--) {
            parent.children[j + 1] = parent.children[j];
        }

        parent.children[i + 1] = newChild;

        for (int j = parent.n - 1; j >= i; j--) {
            parent.keys[j + 1] = parent.keys[j];
        }

        parent.keys[i] = child.keys[t - 1];
        parent.n++;
    }

    // Function to print the tree
    public void print() {
        if (root != null) {
            print(root);
        }
    }

    private void print(Node node) {
        int i;
        for (i = 0; i < node.n; i++) {
            if (!node.isLeaf) {
                print(node.children[i]);
            }
            System.out.print(node.keys[i] + " ");
        }
        if (!node.isLeaf) {
            print(node.children[i]);
        }
    }


    public static void main(String[] args) {
        BTree btree = new BTree(3); // Minimum degree = 3

        btree.insert(10);
        btree.insert(20);
        btree.insert(5);
        btree.insert(6);
        btree.insert(12);
        btree.insert(30);
        btree.insert(7);
        btree.insert(17);

        System.out.println("Traversal of B-Tree:");
        btree.print();

        int key = 6;
        System.out.println("\n\nSearch for key " + key + ":");
        System.out.println(btree.search(key) != null ? "Key found!" : "Key not found.");
    }
}
