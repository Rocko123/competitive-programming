import java.util.*;
import java.io.*;
public class path_finder {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dir = new int[][] {{-1,0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static HashSet<Integer> adj[], vis[];
    static int n, m, k;
    public static void main(String[] args) throws IOException{
        // very good problem by 4fecta from IOI
        n = readInt(); m = readInt(); k = readInt();
        adj = new HashSet[n+5]; vis = new HashSet[n+5];

        for (int i = 0; i <= n+4; i++) {
            adj[i] = new HashSet<>();
            vis[i] = new HashSet<>();
        }

        ArrayList<Integer> left = new ArrayList<>(), bottom = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int r = readInt(), c = readInt();
            adj[r].add(c);
            if (c == 1) left.add(r);
            if (r == n) bottom.add(c);
        }
        for (int r: left) {
            dfs (r, 1);
        }
        for (int i = 0; i <= n+4; i++) vis[i].clear();
        for (int c: bottom) {
            dfs(n, c);
        }
        System.out.println("YES");
    }
    static void dfs (int r, int c) {
        /*
        4 2 2
        4 1
        3 2
        */
        if (r == 1 || c == m) {
            System.out.println("NO");
            System.exit(0);
        } 
        if (vis[r].contains(c)) return;
        vis[r].add(c);
        for (int[] i: dir) {
            int nr = r + i[0], nc = c + i[1];
            if (good(nr, nc)) {
                dfs(nr, nc);
            }
        }
        // reason why old code didnt work
        // suppose we start with a blocked in the middle
        // one dfs goes all the way right, one goes all the way left
        // this should create a wall, but each depends on the initial block which is not marked L or R
        // 4fecta's code works because it eliminates this dependency
    }
    static boolean good (int nr, int nc) {
        return adj[nr].contains(nc);
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