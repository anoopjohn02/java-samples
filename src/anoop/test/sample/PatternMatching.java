package anoop.test.sample;

public class PatternMatching {
    /*
        KMP Algorithm (Knuth-Morris-Pratt)
     */
    public static void main(String[] args) {
        PatternMatching patternMatching = new PatternMatching();
        System.out.println(patternMatching.patternMatching("ABABDABACDAABCDABEABF", "ABCDABEABF"));
        System.out.println(patternMatching.patternMatching("ABABDABACDABABCABAB", "ABABCABAB"));
    }

    private boolean patternMatching(String s, String pattern){

        //Prepare Pi or lps table
        int[] piTable = new int[pattern.length()];
        piTable[0] = 0;
        int ptr1 = 0;
        int ptr2 = 1;
        while(ptr2 < pattern.length()){
            if(pattern.charAt(ptr2) == pattern.charAt(ptr1)){
                ptr1++;
                piTable[ptr2] = ptr1;
                ptr2++;
            } else {
                if (ptr1 != 0) {
                    ptr1 = piTable[ptr1-1];
                } else {
                    piTable[ptr2] = ptr1;
                    ptr2++;
                }
            }
        }
        for(int i : piTable){
            System.out.print(i);
        }

        // Search for pattern
        int i = 0, j = 0;
        while(i < s.length()){
            //System.out.println(i+","+j);
            //System.out.println(s.charAt(i)+","+pattern.charAt(j+1));
            if(s.charAt(i) == pattern.charAt(j)){
                i++; j++;
            }
            if(j == pattern.length()){
                System.out.println("    Matching");
                return true;
            } else if (i < s.length() && s.charAt(i) != pattern.charAt(j)){
                if(j != 0){
                    j = piTable[j-1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}
