// Design a PDA and write a program for simulating the machine which accepts the language
//  {anbn where n>0, S= {a, b}}. 

import java.util.Stack;

public class TOC7 {
    public static void main(String[] args) {
        String input = "aaabbb"; // Example input
        System.out.println("Input: " + input);
        if (accepts(input)) {
            System.out.println("The input is accepted!");
        } else {
            System.out.println("The input is rejected.");
        }
    }

    public static boolean accepts(String input) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : input.toCharArray()) {
            if (c == 'a') {
                stack.push(c); // Push 'a' onto the stack
            } else if (c == 'b') {
                if (stack.isEmpty() || stack.pop() != 'a') {
                    return false; // Mismatch or no 'a' to pop
                }
            } else {
                return false; // Invalid character
            }
        }

        // Accept if the stack is empty after processing
        return stack.isEmpty();
    }
}
