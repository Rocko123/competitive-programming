import java.util.*;
import java.io.*;
public class gc_shortest_path_SPFA {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // bellman ford but better
        // bool array used to check if a node in q
        // use double end q and small label first
        int n = readInt(), m = readInt();

        long[] dist = new long[n+1]; Arrays.fill(dist, Integer.MAX_VALUE);
        List<int[]> adj[] = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (; m > 0; m--) {
            int u = readInt(), v = readInt(), w = readInt(); 
            adj[u].add(new int[] {v, w});
        }
        boolean[] inQ = new boolean[n+1];
        Deque<Integer> q = new LinkedList<>();
        dist[1] = 0; q.add(1); inQ[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll(); inQ[cur] = false;
            for (int[] i: adj[cur]) {
                int next = i[0], weight = i[1];
                if (dist[next] > dist[cur] + weight) {
                    // last sub pushed in q even if distance was not better = TLE
                    dist[next] = dist[cur] + weight; 
                    if (!inQ[next]) {
                        // small label first
                        if (!q.isEmpty() && dist[next] < dist[q.peek()]) {
                            q.addFirst(next);
                        } else {
                            q.add(next);
                        }
                        inQ[next] = true;
                    }
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
