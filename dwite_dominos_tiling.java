import java.util.*;
import java.io.*;
public class dwite_dominos_tiling {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // similar to CEMC problem solving problem 5

        // dp state: num ways to tile first n columns
        // dp transition: group col n, n-1 -> 3 ways to make
        // group n-3, n-2, n-1, n -> 2 ways to make 
        // dp[n] = 3 * dp[i-2] + 2 * dp[i-4] + 2 * dp[i-6]...

        int[] dp = new int[31];
        int mod = (int) 1e6;

        dp[0] = 1;
        for (int i = 2; i <= 30; i += 2) {
            dp[i] = (3*dp[i-2]) % mod;
            for (int j = i-4; j >= 0; j -= 2) {
                dp[i] = (dp[i] + 2 * dp[j]) % mod;
            }
        }
        for (int i = 1; i <= 5; i++) {
            int n = readInt();
            System.out.println(dp[n]);
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