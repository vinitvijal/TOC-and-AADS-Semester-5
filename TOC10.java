// Design and simulate a Turing Machine which will increment the given binary number by 1

public class TOC10 {
    public static void main(String[] args) {
        // Example binary number as input
        char[] tape = "1011".toCharArray();
        System.out.println("Input Binary: " + new String(tape));
        
        tape = incrementBinary(tape);
        
        System.out.println("Incremented Binary: " + new String(tape));
    }

    public static char[] incrementBinary(char[] tape) {
        int head = tape.length - 1; // Start at the least significant bit (rightmost)

        // Loop to handle carry propagation
        while (head >= 0) {
            if (tape[head] == '0') {
                tape[head] = '1'; // Increment without carry
                return tape;      // Done, return updated tape
            } else {
                tape[head] = '0'; // Carry propagated, move left
                head--;
            }
        }

        // If the carry reaches the left end, prepend a '1'
        char[] newTape = new char[tape.length + 1];
        newTape[0] = '1'; // Add the carry
        System.arraycopy(tape, 0, newTape, 1, tape.length);
        return newTape;
    }
}
