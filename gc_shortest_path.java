import java.util.*;
import java.io.*;
public class gc_shortest_path {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // bellman ford template
    	int n = readInt(), m = readInt();
        List<int[]> adj[] = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (; m > 0; m--) {
            int a = readInt(), b = readInt(), c = readInt();
            adj[a].add(new int[] {b, c});
        }

        long[] dist = new long[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int[] k: adj[j]) {
                    dist[k[0]] = Math.min(dist[k[0]], dist[j] + k[1]);
                }
            }
        }
        System.out.println(dist[n]);
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
