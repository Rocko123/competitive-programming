import java.util.*;
import java.io.*;
public class sam_comnputer {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> adj[];
    static int t, n, b;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        t = readInt(); n = readInt();

        adj = new ArrayList[t+1];
        for (int i = 1; i <= t; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int c = readInt(), v = readInt(), item = readInt();
            adj[item].add(new int[] {c, v});
        }

        b = readInt();
        dp = new int[t+1][b+1];
        System.out.println(fun(t, b));
    }
    static int fun (int item, int money) { // #items bought, money left
        if (item == 0) return 0;
        if (dp[item][money] != 0) return dp[item][money];

        for (int[] i: adj[item]) {
            if (money - i[0] >= 0) {
                dp[item][money] = Math.max(dp[item][money], fun(item-1, money-i[0]) + i[1]);
            }
        }
        return dp[item][money];
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