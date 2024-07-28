import java.util.*;
import java.io.*;
public class ccc_maximum_distance {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for (; t > 0; t--) {
            int n = readInt();
            int[] x = new int[n], y = new int[n];
            for (int i = 0; i < n; i++) x[i] = readInt();
            for (int i = 0; i < n; i++) y[i] = readInt();
            int low = 0, high = 0, ans = 0;
            // original binary search was wrong
            // L R both start furthest left
            while (low < n && high < n) {
                if (y[high] >= x[low]) {
                    if ((high-low) > ans) { 
                        ans = high - low; // check if the new ans is better
                    } else {
                        high++; // go as far right as possible until we find a better answer
                    }
                } else {
                    low++; // y[high] too small, increment low until we get new valid low
                }
            }
            System.out.println("The maximum distance is " + ans);
        }
         
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