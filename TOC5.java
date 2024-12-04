// Design a Finite Automata (FA) that accepts language EVEN-EVEN over S={a, b}. Write a program
// to simulate this FA

public class TOC5 {
    public static void main(String[] args) {
        String str = "ababaaaabb";
        State1(str, 0);
    }

    public static void State1(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Accepted");
        }else{
            if(w.charAt(i) == 'a'){
                State2(w, i+1);
            }else{
                State4(w, i+1);
            }
        }
    }

    public static void State2(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'b'){
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
            if(w.charAt(i) == 'b'){
                State2(w, i+1);
            }else{
                State4(w, i+1);
            }
        }
    }

    public static void State4(String w, int i) {
        if(i == w.length()){
            System.out.println("String is Rejected");
        }else{
            if(w.charAt(i) == 'a'){
                State3(w, i+1);
            }else{
                State1(w, i+1);
            }
        }
    }
}
