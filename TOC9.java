// Design and simulate a Turing Machine that accepts the language an
// bn
// cn
//  where n >0
public class TOC9 {
    public static void main(String[] args) {
        // Example input tape
        char[] tape = "aaabbbccc".toCharArray();
        System.out.println("Input: " + new String(tape));
        
        if (isAccepted(tape)) {
            System.out.println("The input is accepted!");
        } else {
            System.out.println("The input is rejected.");
        }
    }

    public static boolean isAccepted(char[] tape) {
        int head = 0; // Tape head pointer

        while (true) {
            // Find and mark 'a'
            head = findAndReplace(tape, head, 'a', 'X');
            if (head == -1) break;

            // Find and mark 'b'
            head = findAndReplace(tape, head, 'b', 'Y');
            if (head == -1) return false;

            // Find and mark 'c'
            head = findAndReplace(tape, head, 'c', 'Z');
            if (head == -1) return false;

            // Return to start
            head = returnToStart(tape);
        }

        // Check if the tape contains only marked characters
        for (char ch : tape) {
            if (ch != 'X' && ch != 'Y' && ch != 'Z' && ch != '_') {
                return false; // Invalid character
            }
        }
        return true;
    }

    // Helper method to find and replace the target character
    private static int findAndReplace(char[] tape, int head, char target, char replacement) {
        while (head < tape.length) {
            if (tape[head] == target) {
                tape[head] = replacement;
                return head + 1;
            }
            head++;
        }
        return -1; // Target not found
    }

    // Helper method to return the tape head to the start
    private static int returnToStart(char[] tape) {
        int head = 0;
        while (head < tape.length && tape[head] != 'a' && tape[head] != 'b' && tape[head] != 'c') {
            head++;
        }
        return 0;
    }
}
