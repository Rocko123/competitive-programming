import java.util.*;
import java.io.*;
public class oths_coffee_jelly {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean good;
    static boolean[][] vis;
    static char[][] g;
    static int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n, m;
    public static void main(String[] args) throws IOException{
        n = readInt(); m =readInt();
        g = new char[n+1][m+1];
        vis = new boolean[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String s = readLine();
            for (int j = 1; j <= m; j++) {
                g[i][j] = s.charAt(j-1);
                if (g[i][j] == 'X') vis[i][j] = true;
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!vis[i][j]) {
                    good = vis[i][j] = true;
                    bfs(i, j);
                    if (good) ans++;
                }
            }
        }
        System.out.println(ans);
    } 
    static void bfs (int y, int x) {
        if (g[y][x] == '*') good = false;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0], cx = cur[1];
            for (int[] i: dir) {
                int ny = cy + i[0], nx = cx + i[1];
                if (good(nx, ny)) {
                    q.add(new int[] {ny, nx});
                    if (g[ny][nx] == '*') good = false;
                    vis[ny][nx] = true;
                }
            }
        }
    }
    static boolean good (int x, int y) {
        return x >= 1 && x <= m && y >= 1 && y <= n && !vis[y][x];
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