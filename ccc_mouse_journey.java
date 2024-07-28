import java.util.*;
import java.io.*;
public class ccc_mouse_journey {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, ans = 0;
    static boolean[][] vis;
    static boolean[][] cat;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
    	R = readInt(); C = readInt();
    	int k = readInt();
    	vis = new boolean[R+1][C+1];
    	dp = new int[R+1][C+1];
    	cat = new boolean[R+1][C+1];
    	for (int i = 0; i < k; i++) {
    		int r = readInt(), c = readInt();
    		vis[r][c] = true;
    	}
    	for (int i = 1; i <= R; i++) {
    		Arrays.fill(dp[i], -1);
    	}
    	System.out.println(dfs(1, 1));
    }
    static int dfs (int r, int c) {
    	// when we have to compute the same path multiple times
    	// memoize the paths
    	if (c > C || r > R || cat[r][c] || vis[r][c]) {
    		return 0;
    	}
    	if (r == R && c == C) {
    		return 1;
    	}
    	if (dp[r][c] != -1) {
    		return dp[r][c];
    	}
    	int sum = 0;
    	vis[r][c] = true;
    	sum += dfs(r, c+1);
    	sum += dfs(r+1, c);
    	dp[r][c] = sum;
    	vis[r][c] = false;
    	return sum;
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
