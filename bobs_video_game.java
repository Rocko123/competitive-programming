import java.util.*;
import java.io.*;
public class bobs_video_game {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // find the largest monsters health
        // then any other monsters we can also defeat
        // use floyd warshall
        int n = readInt(), m = readInt(), t = readInt();
        long[][] dist = new long[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (; m > 0; m--) {
            int s = readInt(), e = readInt(), h = readInt();
            dist[s][e] = h;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // if a step to an intermediate vertex k is better than 
                    // the direct path i to j, take it
                    dist[i][j] = Math.min(dist[i][j], Math.max(dist[i][k], dist[k][j]));
                    // take the greatest monster health between the edges ik and kj
                }
            }
        }
        for (; t > 0; t--) {
            int a = readInt(), b = readInt();
            System.out.println(dist[a][b] == Integer.MAX_VALUE ? -1: dist[a][b]);
        }
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
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
