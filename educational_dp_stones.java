import java.util.*;
import java.io.*;
public class educational_dp_stones {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), k = readInt();
        int[] take = new int[n];
        for (int i = 0; i < n; i++) take[i] = readInt();

        // dp state: Taro has i coins
        // dp transition: if Taro can get to a losing state W, else L

        Arrays.sort(take);
        int[] dp = new int[k+1];
        for (int i = 1; i <= k; i++) {
            for (int j: take) {
                if (j <= i) {
                    dp[i] = Math.max(dp[i], dp[i-j] == 0 ? 1: 0);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[k] == 1 ? "First": "Second");
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