import java.util.*;
import java.io.*;
public class gc_trees {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	// find the size of each component
        // num edges - (n - num components)

        int n = readInt();
        int edges = 0;
        List<Integer> adj[] = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int u = readInt();
                if (u == 1) {
                    adj[i].add(j);
                    edges++;
                }
            }
        }
        edges /= 2;

        int components = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                components++;
                q.add(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int j: adj[cur]) {
                        if (!vis[j]) {
                            q.add(j);
                            vis[j] = true;
                        }
                    }
                }
            }
        }
        System.out.println(edges - (n-components));
        
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