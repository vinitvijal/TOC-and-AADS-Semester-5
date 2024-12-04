// Design a Finite Automata (FA) that accepts language L2, over S= {a, b} where L2= a(a+b)*b. Write
// a program to simulate this FA.

public class TOC4 {
    public static void main(String[] args) {
        String str = "baaababababaaabaaaab";
        State1(str, 0);
    }

    public static void State1(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'a'){
                State2(w, i+1);
            }else{
                System.out.println("String is Rejected");
            }
        }
    }

    public static void State2(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'b'){
                State3(w, i+1);
            }else {
                State2(w, i+1);
            }
        }
    }

    public static void State3(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Accepted");
        }else{
            if(w.charAt(i) == 'b'){
                State3(w, i+1);
            }else{
                State2(w, i+1);
            }
        }
    }
}
