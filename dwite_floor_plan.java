import java.util.*;
import java.io.*;
public class dwite_floor_plan {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int R, C;
    static char[][] graph;
    static boolean[][] vis;
    public static void main(String[] args) throws IOException{
        R = readInt(); C = readInt();
        int[] ans = new int[5];
        graph = new char[R][C];
        for (int i = 0; i < R; i++) {
            graph[i] = readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] != '.' && graph[i][j] != '#') {
                    int index = Integer.valueOf(String.valueOf(graph[i][j]))-1;
                    int size = 1;
                    vis = new boolean[R][C];
                    vis[i][j] = true;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int r = cur[0]; int c = cur[1];
                        for (int[] k: dir) {
                            int nr = r + k[0];
                            int nc = c + k[1];
                            if (check(nr, nc)) {
                                q.add(new int[] {nr, nc});
                                vis[nr][nc] = true;
                                size++;
                            }
                        }
                    }
                    ans[index] = size;
                }
            }
        }
        for (int i: ans) System.out.println(i);
    }
    static boolean check (int nr, int nc) {
        return nr >= 0 && nr < R && nc >= 0 && nc < C && graph[nr][nc] != '#' && !vis[nr][nc];
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