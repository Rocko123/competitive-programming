import java.util.*;
import java.io.*;
public class ccc_minimum_cost_roads {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();

        List<edge> adj[] = new ArrayList[n+1];
        for (int i = 0; i < m; i++) {
            int u = readInt(), v = readInt(), l = readInt(), c = readInt();
            adj[u].add(new edge(v, c, l)); adj[v].add(new edge(u, c, l));
        }
        
    }
    static class edge implements Comparable<edge> {
        int node, cost, length;
        edge (int node0, int cost0, int length0) {
            node0 = node; cost0 = cost; length0 = length;
        }
        public int compareTo(edge x) {
            return Integer.compare(length, x.length);
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