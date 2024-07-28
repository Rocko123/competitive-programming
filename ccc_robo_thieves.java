import java.util.*;
import java.io.*;
public class ccc_robo_thieves {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] graph;
    static boolean[][] vis;
    static int n, m;
    public static void main(String[] args) throws IOException{
        // 0 1 BFS
        n = readInt(); m = readInt();
        graph = new char[n][m];
        vis = new boolean[n][m];
        int[][] dist = new int[n][m];
        List<int[]> exits = new ArrayList<>(), cams = new ArrayList<>();
        int sr = -1, sc = -1;
        for (int i = 0; i < n; i++) {
            graph[i] = readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == '.') exits.add(new int[] {i, j});
                if (graph[i][j] == 'C') cams.add(new int[] {i, j});
                if (graph[i][j] == 'S') {
                    sr = i; sc = j;
                }
            }   
        }

        int[][] dir = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] i: cams) { // new way to update what cams can see
            for (int[] j: dir) {
                int r = i[0], c = i[1];
                while (graph[r][c] != 'W') {
                    if (graph[r][c] == '.' || graph[r][c] == 'S') vis[r][c] = true;
                    r += j[0]; c += j[1];
                }
            }
        }
        /* 
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        */
        Deque<int[]> q = new LinkedList<>();
        if (!vis[sr][sc]) {
            dist[sr][sc] = 0; q.add(new int[] {sr, sc});
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            // System.out.println(Arrays.toString(cur));
            int r = cur[0], c = cur[1];
            int d = dist[r][c] + 1;

            if (graph[r][c] == 'L') {
                if (inG(r, c-1)) {
                    q.addFirst(new int[] {r, c-1});
                    vis[r][c-1] = true;
                    dist[r][c-1] = dist[r][c];
                }
                continue;
            } else if (graph[r][c] == 'R') {
                if (inG(r, c+1)) {
                    q.addFirst(new int[] {r, c+1});
                    vis[r][c+1] = true;
                    dist[r][c+1] = dist[r][c];
                }
                continue;
            } else if (graph[r][c] == 'U') {
                if (inG(r-1, c)) {
                    q.addFirst(new int[] {r-1, c});
                    vis[r-1][c] = true;
                    dist[r-1][c] = dist[r][c];
                }
                continue;
            } else if (graph[r][c] == 'D') {
                if (inG(r+1, c)) {
                    q.addFirst(new int[] {r+1, c});
                    vis[r+1][c] = true;
                    dist[r+1][c] = dist[r][c];
                }
                continue;
            }

            for (int[] i: dir) {
                int nr = r + i[0], nc = c + i[1];
                if (inG(nr, nc)) {
                    vis[nr][nc] = true;
                    if (graph[nr][nc] == 'L' || graph[nr][nc] == 'R' || graph[nr][nc] == 'U' || graph[nr][nc] == 'D') {
                        q.addFirst(new int[] {nr, nc});
                    } else {
                        q.add(new int[] {nr, nc});
                    }
                    dist[nr][nc] = d;
                }
            }
        }
        for (int[] i: exits) {
            if (vis[i[0]][i[1]] && dist[i[0]][i[1]] != 0) {
                System.out.println(dist[i[0]][i[1]]);
            } else {
                System.out.println(-1);
            }
        }
    }
    static boolean inG (int nr, int nc) {
        return graph[nr][nc] != 'W' && !vis[nr][nc];
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
