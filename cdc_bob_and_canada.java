import java.util.*;
import java.io.*;
public class cdc_bob_and_canada {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // idea: two pointers with psa
        int t = readInt();
        for (; t > 0; t--) {
            int n = readInt();
            String flag = readLine();
            int[] psaR = new int[n+1], psaW = new int[n+1];
            for (int i = 1; i <= n; i++) {
                psaR[i] = psaR[i-1] + (flag.charAt(i-1) == 'R' ? 1: 0);
                psaW[i] = psaW[i-1] + (flag.charAt(i-1) == 'W' ? 1: 0);
            }
            // consider two cut points L >= 1 and L < R < n
            // then the answer is psaW[L] + psaR[R]-psaR[L] + psaW[n] - psaW[R]
            // we can loop R and maintain a best L 
            // min(psaW[L]-psaR[L]) + psaR[R]-psaW[R] + psaW[n]
            int minL = psaW[1]-psaR[1], ans = Integer.MAX_VALUE;
            for (int i = 2; i < n; i++) {
                ans = Math.min(ans, minL + psaR[i]-psaW[i] + psaW[n]);
                minL = Math.min(minL, psaW[i]-psaR[i]);
            }
            System.out.println(ans);
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