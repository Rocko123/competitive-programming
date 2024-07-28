import java.util.*;
import java.io.*;
public class dmopc_golden_lily {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	// dijkstra
        int l = readInt(), d = readInt();

        int[][] g = new int[d][l];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < l; j++) {
                g[i][j] = readInt();
            }
        }
        int endx = readInt(), endy = readInt();

        int ans = 0;
        List<edge> adj[] = new ArrayList[d*l];
        for (int i = 0; i < d*l; i++) adj[i] = new ArrayList<>();

        int counter = 0;
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < l; j++) {
                if (j > 0) {
                    adj[counter].add(new edge(counter-1, g[i][j-1]));
                }
                if (j < l-1) {
                    adj[counter].add(new edge(counter+1, g[i][j+1]));
                }
                if (i < d-1) {
                    adj[counter].add(new edge(counter+l, g[i+1][j]));
                }
                if (i == endy && j == endx) ans = counter;
                counter++;
            }
        }

        int[] dist = new int[d*l];
        Arrays.fill(dist, Integer.MAX_VALUE/2);
        dist[0] = g[0][0];

        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(0, g[0][0]));
        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            if (cur.w > dist[cur.u]) continue;
            for (edge i: adj[cur.u]) {
                int nxt = i.u, nd = i.w + cur.w;
                if (dist[nxt] > nd) {
                    dist[nxt] = nd;
                    pq.add(new edge(nxt, nd));
                }
            }
        }
        System.out.println(dist[ans]);
    }
    static class edge implements Comparable<edge> {
        int u, w;
        edge (int u0, int w0) {
            u = u0; w = w0;
        } 
        public int compareTo(edge x) {
            return Integer.compare(w, x.w);
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