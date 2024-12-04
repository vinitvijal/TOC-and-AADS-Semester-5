import java.util.Scanner;

public class Q7 {

    public static boolean verifyPDA(String input) {
        char[] stack = new char[input.length()];
        int top = -1;
        int i = 0;
        while (i < input.length() && input.charAt(i) == 'a') {
            stack[++top] = 'a';
            i++;
        }
        while (i < input.length() && input.charAt(i) == 'b') {
            if (top == -1) {
                return false;
            }
            top--;
            i++;
        }

        if (i == input.length() && top == -1) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String input = sc.nextLine();
        if (verifyPDA(input)) {
            System.out.println("String is accepted by PDA");
        } else {
            System.out.println("String is not accepted by PDA");
        }
        sc.close();
    }
}