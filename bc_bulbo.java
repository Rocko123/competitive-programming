import java.util.*;
import java.io.*;
public class bc_bulbo {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // dp way, slower
        int n = readInt(), x = readInt();

        int[][] game = new int[n][2];
        int[] endpoints = new int[2*n+1];
        long[] dp = new long[2*n+1];

        for (int i = 0; i < n; i ++) {
            game[i][0] = endpoints[2*i] = readInt();
            game[i][1] = endpoints[2*i+1] = readInt();
        }
        endpoints[2*n] = x;
        Arrays.sort(endpoints);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0; 

        for (int i = 0; i < n; i++) {
            long best = dp[0];
            int last = 
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