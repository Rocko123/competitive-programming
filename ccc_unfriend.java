import java.util.*;
import java.io.*;
public class ccc_unfriend {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> adj[];
    public static void main(String[] args) throws IOException{
        int n = readInt();
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) adj[readInt()].add(i);
        System.out.println(dfs(n)-1); // cannot remove ourself
    }
    static int dfs (int person) {
        // base case = 2
        int ans = 1;
    	for(int i: adj[person])
    		ans *= dfs(i); // include all paths below
    	ans++; // don't include this path at all
    	return ans;
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