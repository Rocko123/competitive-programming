import java.util.*;
import java.io.*;
public class scb_magic_coupons {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), k = readInt();

        Set<Integer> maxP = new HashSet<>(), minP = new HashSet<>();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = readInt();
            String p = Integer.toString(prices[i]);
            if (p.length() == 1) {
                continue;
            } else {
                
            }
        }
        // greedy way
        // longer price + end > start good
        // short price + end < start good

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