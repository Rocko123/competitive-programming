import java.util.*;
import java.io.*;
public class ccc_trucking_troubles {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int c, r, d;
    static List<Integer> adj[];
    static List<edge> edges;
    static List<Integer> dest = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        // instead of removing all the edges 1 by 1, try to remove only the edges
        // that connect the destination cities to the graph

        c = readInt(); r = readInt(); d = readInt();
        adj = new ArrayList[c+1];
        for (int i = 1; i <= c; i++) adj[i] = new ArrayList<>();

        edges = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            int x = readInt(), y = readInt(), w = readInt();
            adj[x].add(y);  adj[y].add(x);
            edges.add(new edge(x, y, w));
        }
        Collections.sort(edges);

        for (int i = 0; i < d; i++) dest.add(readInt());

        int ans = edges.get(edges.size()-1).w;
        for (edge i: edges) {
            boolean good = bfs(i);
            if (!good) {
                ans = i.w;
                break;
            }
        }
        System.out.println(ans);
    }
    static boolean bfs (edge x) {
        int ban1 = x.u, ban2 = x.v;
        for (int i = 0; i < adj[ban1].size(); i++) {
            if (adj[ban1].get(i) == ban2) {
                adj[ban1].remove(i);
            }
        }
        for (int i = 0; i < adj[ban2].size(); i++) {
            if (adj[ban2].get(i) == ban1) {
                adj[ban2].remove(i);
            }
        }

        boolean[] vis = new boolean[c+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1); vis[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i: adj[cur]) {
                if (!vis[i]) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        boolean good = true;
        for (int i: dest) {
            if (!vis[i]) {
                good = false;
                break;
            }
        }
        return good;
    }
    static class edge implements Comparable<edge> {
        int u, v, w;
        edge (int u0, int v0, int w0) {
            u = u0; v = v0; w = w0;
        }
        public int compareTo (edge x) {
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