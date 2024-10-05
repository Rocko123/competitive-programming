import java.util.*;
import java.io.*;
public class string_finding {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // kmp algorithm
        String s = readLine(), t = readLine();
        String prefix = t+"A"+s;

        int[] lps = new int[prefix.length()];
        for (int i = 1; i < prefix.length(); i++) {
            int j = lps[i-1]; // longest prefix of guy before you
            while (j > 0 && prefix.charAt(i) != prefix.charAt(j)) j = lps[j-1]; // find the first equal one before you
            if (prefix.charAt(i) == prefix.charAt(j)) j++;
            // since length is 1 idx, j is actually the string idx+1, if i is that value
            // then you can extend the lps
            lps[i] = j;
        }
        //System.out.println(Arrays.toString(lps));
        for (int i = t.length()+1; i < prefix.length(); i++) {
            if (lps[i] == t.length()) {
                System.out.println(i-2*t.length());
                System.exit(0);
            }
        }
        System.out.println(-1);
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
