import java.util.*;
import java.io.*;
public class string_finding {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // kmp algorithm
        String s = readLine(), t = readLine();

        int[] lps = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int j = lps[i-1]; // longest prefix of guy before you
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = lps[j-1]; // find the first equal one before you
            if (s.charAt(i) == s.charAt(j)) j++;
            // since length is 1 idx, j is actually the string idx+1, if i is that value
            // then you can extend the lps
            lps[i] = j;
        }
        // https://cp-algorithms.com/string/prefix-function.html
        // https://www.youtube.com/watch?v=V5-7GzOfADQ

    } 
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }   
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }  
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}