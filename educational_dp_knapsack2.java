import java.util.*;
import java.io.*;
public class educational_dp_knapsack2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), w = readInt();
        // 1e9 * 8 bytes = 8gb still too much space
        // change dp state and transition

        int maxVal = n * 1000;
        int[] dp = new int[maxVal + 1]; 
        // each item is at most a value of 1000, the most value if maxVal
        Arrays.fill(dp, w+1); // for each value, each item has a capcity > W
        dp[0] = 0; // 0 weight -> 0 items
        for (int i = 1; i <= n; i++) {
            int wi = readInt(), vi = readInt();
            for (int j = maxVal; j >= vi; j--) {
                dp[j] = Math.min(dp[j], dp[j-vi] + wi);
                // basically flipped the question
                // dp stores the capacity for some value j
                // if this weight at the same value is less, take it
            }
        }
        for (int i = maxVal; i >= 0; i--) {
            if (dp[i] <= w) { // largest value less than capacity W
                System.out.println(i);
                System.exit(0);
            }
        }
        // time O(n*maxval)
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