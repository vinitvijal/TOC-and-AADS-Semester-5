// Design a Finite Automata (FA) that accepts all strings over S={0, 1} having three consecutive 1's as
// a substring. Write a program to simulate this FA.

public class TOC1 {
   
    public static void main(String[] args) {
        String str = "1010010110010";
        State1(str, 0);
    }

    public static void State1(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == '1'){
                State2(w, i+1);
            }else{
                State1(w, i+1);
            }
        }
    }

    public static void State2(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == '1'){
                State3(w, i+1);
            }else{
                State1(w, i+1);
            }
        }
    }

    public static void State3(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == '1'){
                State4(w, i+1);
            }else{
                State1(w, i+1);
            }
        }
    }

    public static void State4(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Accepted");
        }else{
            if(w.charAt(i) == '1'){
                State4(w, i+1);
            }else{
                State4(w, i+1);
            }
        }
    }

}
