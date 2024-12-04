// Design a PDA and write a program for simulating the machine which accepts the language {wXwr
//     | w
//     is any string over S={a, b} and wr
//      is reverse of that string and X is a special symbol }.
import java.util.Stack;

public class TOC8 {
    public static void main(String[] args) {
        String input = "abaXaba"; // Example input
        System.out.println("Input: " + input);
        if (accepts(input)) {
            System.out.println("The input is accepted!");
        } else {
            System.out.println("The input is rejected.");
        }
    }

    public static boolean accepts(String input) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int n = input.length();

        // Push Phase: Read w and push onto stack
        while (i < n && input.charAt(i) != 'X') {
            stack.push(input.charAt(i));
            i++;
        }

        // Ensure special symbol X is present
        if (i == n || input.charAt(i) != 'X') {
            return false; // Reject if X is missing
        }

        i++; // Move past X

        // Match Phase: Read w^r and match with stack
        while (i < n) {
            if (stack.isEmpty() || stack.pop() != input.charAt(i)) {
                return false; // Reject if mismatch or stack is empty
            }
            i++;
        }

        // Accept if stack is empty after matching
        return stack.isEmpty();
    }
}
