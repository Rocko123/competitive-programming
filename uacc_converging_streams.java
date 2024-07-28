import java.util.*;
import java.io.*;
public class uacc_converging_streams {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        double[] ans = new int[n+1];
        int[] pollution = new int[n+1], inDeg = new int[n+1];

        List<int[]> adj[] = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (; m > 0; m--) {
            int u = readInt(), v = readInt(), f = readInt();
            adj[u].add(new int[] {v, f});
            inDeg[v]++;
        }

        int start = 0;
        for (int i = 1; i <= n; i++) {
            pollution[i] = readInt(); 
            if (inDeg[i] == 0) start = i;
        }

        Queue<int[]> q = new LinkedList<>();
        while(!q.isEmpty()) {
            
        }
        // 27% at 100 pollution into junction 4 ~ 47.4
        // 73% at 100 pollution into junction 3, +40
        // 41% of 73% of pollution into junction 4 = ~73.5
        // junction 4 +36 == ~157
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
