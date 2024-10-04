import java.util.*;
import java.io.*;
public class aac_koala_balloons {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] psa;
    static boolean[][] vis;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n, m;
    public static void main(String[] args) throws IOException{
        // idea: bfs + 2d psa good
        // my problem: binary search is used to find
        // the optimal side length instead of looping

        n = readInt(); m = readInt();
        psa = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String s = readLine();
            for (int j = 1; j <= m; j++) {
                psa[i][j] = psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1] + (s.charAt(j-1) == 'X' ? 1: 0);
            }
        }

        System.out.println(binarySearch());
    }
    static class coord {
        int y, x;
        coord (int y0, int x0) {
            y = y0; x = x0;
        }
    }
    static int binarySearch () {
        int L = 1, R = Math.min(n, m), ans = 0;
        while (L <= R) {
            int M = (L+R)/2;
            if (bfs(M)) {
                ans = M;
                L = M+1;
            } else {
                R = M-1;
            }
        }
        return ans;
    }
    static boolean bfs (int s) {
        vis = new boolean[n+1][m+1];

        Queue<coord> q = new LinkedList<>();
        if (psa[s][s] != 0) {
            return false;
        } else {
            q.add(new coord(s, s));
            vis[s][s] = true;
        }

        while (!q.isEmpty()) {
            coord cur = q.poll();
            for (int[] i: dir) {
                int y1 = cur.y + i[0], y2 = y1 - s + 1;
                int x1 = cur.x + i[1], x2 = x1 - s + 1;
                if (good(x1, y1) && good(x2, y2) && psa[y1][x1]-psa[y2-1][x1]-psa[y1][x2-1]+psa[y2-1][x2-1] == 0 && !vis[y1][x1]) {
                    q.add(new coord(y1, x1));
                    vis[y1][x1] = true;
                }
            }
        }
        return vis[n][m];   
    }
    static boolean good (int x, int y) {
        return x >= 1 && x <= m && y >= 1 && y <= n;
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