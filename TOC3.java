// Design a Finite Automata (FA) that accepts language L1, over S={a, b}, comprising of all strings (of
// length 4 or more) having first two characters same as the last two. Write a program to simulate this
// FA.

public class TOC3 {
    public static void main(String[] args) {
        String str = "bbaabababb";
        State1(str, 0);
    }

    public static void State1(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'a'){
                State2(w, i+1);
            }else{
                State9(w, i+1);
            }
        }
    }

    public static void State2(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'a'){
                State3(w, i+1);
            }else{
                State6(w, i+1);
            }
        }
    }

    public static void State3(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'a'){
                State4(w, i+1);
            }else{
                State3(w, i+1);
            }
        }
    }

    public static void State4(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'b'){
                State3(w, i+1);
            }else{
                State5(w, i+1);
            }
        }
    }

    public static void State5(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Accepted");
        }else{
            if(w.charAt(i) == 'a'){
                State5(w, i+1);
            }else{
                State3(w, i+1);
            }
        }
    }

    public static void State6(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'a'){
                State7(w, i+1);
            }else{
                State6(w, i+1);
            }
        }
    }

    public static void State7(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'b'){
                State8(w, i+1);
            }else{
                State7(w, i+1);
            }
        }
    }

    public static void State8(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Accepted");
        }else{
            if(w.charAt(i) == 'a'){
                State7(w, i+1);
            }else{
                State6(w, i+1);
            }
        }
    }

    public static void State9(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'a'){
                State10(w, i+1);
            }else{
                State13(w, i+1);
            }
        }
    }

    public static void State10(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'a'){
                State10(w, i+1);
            }else{
                State11(w, i+1);
            }
        }
    }

    public static void State11(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'b'){
                State11(w, i+1);
            }else{
                State12(w, i+1);
            }
        }
    }

    public static void State12(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Accepted");
        }else{
            if(w.charAt(i) == 'a'){
                State10(w, i+1);
            }else{
                State11(w, i+1);
            }
        }
    }

    public static void State13(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'b'){
                State14(w, i+1);
            }else{
                State13(w, i+1);
            }
        }
    }

    public static void State14(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'b'){
                State15(w, i+1);
            }else{
                State13(w, i+1);
            }
        }
    }

    public static void State15(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Accepted");
        }else{
            if(w.charAt(i) == 'b'){
                State15(w, i+1);
            }else{
                State13(w, i+1);
            }
        }
    }
}
