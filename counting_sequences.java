import java.util.*;
import java.io.*;
public class counting_sequences {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // dp state: number of DISTINCT subsequences for the first i chars
        // dp transition: first occurence: 2 * dp[i-1] + 1
        // not first occurence: 2 * dp[i-1] - dp[last_ocur-1]
        // when we carry over the subsequences from previous dp, the last occurence
        // appends that char, however in the duplicate occurence we do the same thing again
        
        String s = readLine();
        int n = s.length(), mod = (int) 1e4+7;

        int[] dp = new int[n+1], prev = new int[26];
        for (int i = 1; i <= n; i++) {
            int c = (int) s.charAt(i-1) - 97;
            if (prev[c] == 0) {
                dp[i] = (2*dp[i-1] + 1) % mod;
            } else {
                dp[i] = (2*dp[i-1] - dp[prev[c]-1]) % mod;
            }
            prev[c] = i;
        }
        System.out.println(dp[n]);
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