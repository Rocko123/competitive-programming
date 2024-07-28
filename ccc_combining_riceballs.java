import java.util.*;
import java.io.*;
public class ccc_combining_riceballs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] psa;
    public static void main(String[] args) throws IOException{
        int n = readInt(), ans = 0;
        int[] rice = new int[n+1]; psa = new int[n+1];
        boolean[][] dp = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            rice[i] = readInt();
            psa[i] = psa[i-1] + rice[i];
            dp[i][i] = true;
            ans = Math.max(ans, rice[i]);
        }
        
        // estimate the time complexity -> O(n^3) passes
        // dp state can we combine one giant rice ball from L to R
        // dp transition: 
        // 1: if dp[L][M] && dp[M+1][R] and sum(L,M) == sum (M+1, R); dp[L][R] = true
        // 2: if dp[L][p] && dp[q][R] && dp[p+1][q-1] && sum (L,p) == sum(q, R) dp[L][R] = true
        // use two pointers to move p from left to right, move q from right to left O(n)
        // if p+1 == q, case 2 becomes case 1
        
        for (int len = 1; len <= n; len++) {
            for (int l = 1; l+len-1 <= n; l++) {
                int r = l+len-1;
                for (int p = l, q = r; p < q;) {
                    if (dp[l][p] && dp[q][r] && (p+1 == q || dp[p+1][q-1]) && sum(l, p) == sum(q, r)) {
                        dp[l][r] = true;
                        break;
                    }
                    if (sum(l, p) < sum(q, r)) {
                        p++;
                    } else {
                        q--;
                    }
                }
                if (dp[l][r]) ans = Math.max(ans, sum(l, r));
            }
        }
        System.out.println(ans);
    } 
    static int sum(int L, int R) {
        return psa[R] - psa[L-1];
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