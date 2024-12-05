public class KMP {
    public static void main(String[] args) {
        String str = "abcacbabcbabcde";
        String pat = "ab";
        int lpsTable[] = lps(pat);
        // System.out.println(lpsTable);
   
        int i = 0, j = 0;
        while(i < str.length()){
            if(str.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            if(j == pat.length()){
                System.out.println("Pattern found at index: " + (i-j));
                break;
            }else if(i < str.length() && str.charAt(i) != pat.charAt(j)){
                if(j != 0){
                    j = lpsTable[j-1];
                }else{
                    i++;
                }
            }
        }

    }

    public static int[] lps(String pat){
        int arr[] = new int[pat.length()];
        int j = 0;
        for(int i = 1; i < pat.length(); i++){
            if(pat.charAt(j) == pat.charAt(i)){
                arr[i] = j+1;
                j++;
            }else{
                j = 0;
            }
        }
        return arr;
    }
}
