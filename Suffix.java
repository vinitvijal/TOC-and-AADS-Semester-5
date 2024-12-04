import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node {
    Map<Character, Node> children;
    boolean isWord;

    public Node() {
        children = new HashMap<>();
        isWord = false;
    }
}


class SuffixTree {
    private Node root;

    public SuffixTree() {
        this.root = new Node();
    }

    
    public void insert(String word) {
        for (int i = 0; i < word.length(); i++) {
            addSuffix(word.substring(i));
        }
    }

    private void addSuffix(String suffix) {
        Node currNode = root;
        for (int i = 0; i < suffix.length(); i++) {
            char c = suffix.charAt(i);
            currNode.children.putIfAbsent(c, new Node());
            currNode = currNode.children.get(c);
        }
        currNode.isWord = true;
    }

    public boolean isSuffix(String word) {
        Node currNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!currNode.children.containsKey(c)) {
                return false;
            }
            currNode = currNode.children.get(c);
        }
        return currNode.isWord;
    }


}

public class Suffix {
    public static void main(String[] args) {
       SuffixTree tree = new SuffixTree();
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter word to insert in suffix tree: ");
       String word = sc.next();
       tree.insert(word);
       while (true) {
              System.out.print("Enter a word to search: ");
              word = sc.next();
              if (word.equals("exit")) {
                break;
              }
              if (tree.isSuffix(word)) {
                System.out.println("Word found");
              } else {
                System.out.println("Word not found");
              }
       }
       sc.close();
    }
}