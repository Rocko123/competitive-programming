import java.util.*;
import java.io.*;
public class ioi_triangle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int matrix[][] = new int[100][100];
    static int memoize[][] = new int[100][100];
    static int ans = 0;
    static int n;
    public static void main(String[] args) throws IOException{
    	n = readInt();
    	for (int i = 0; i < 100; i++) {
    		Arrays.fill(memoize[i], -1);
    	}
    	
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j <= i; j++) {
    			matrix[i][j] = readInt();
    		}
    	}
    	dfs(0, 0);
    	System.out.println(ans);
    	
    	// for (int i = 0; i < n; i++) System.out.println(Arrays.toString(memoize[i]));
    }
    
    static int dfs (int y, int x) {
    	if (y == n) {
    		return 0;
    	}
    	if (memoize[y][x] != -1) {
			return memoize[y][x];
		}
    	ans = Integer.MIN_VALUE;
    	ans = Math.max(ans, dfs(y + 1, x) + matrix[y][x]);
    	ans = Math.max(ans, dfs(y + 1, x + 1) + matrix[y][x]);
    	return memoize[y][x] = ans;
    	// bottom up approach, see output memoize
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
