import java.util.*;
import java.io.*;
public class ccc_waterloo_harvest {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int r = readInt(), c = readInt();
        char[][] field = new char[r][c];
        boolean[][] vis = new boolean[r][c];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < r; i++) field[i] = readLine().toCharArray();
        int a = readInt(), b = readInt();


        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {a, b});
        vis[a][b] = true;
        if (field[a][b] == 'L') ans += 10;
        if (field[a][b] == 'M') ans += 5;
        if (field[a][b] == 'S') ans += 1;
    
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0], col = cur[1];
            for (int[] i: dir) {
                int nr = i[0] + row, nc = i[1] + col;
                if (nr >= 0 && nr < r && nc >= 0 && nc < c && !vis[nr][nc] && field[nr][nc] != '*') {
                    q.add(new int[] {nr, nc});
                    if (field[nr][nc] == 'L') ans += 10;
                    if (field[nr][nc] == 'M') ans += 5;
                    if (field[nr][nc] == 'S') ans += 1;
                    vis[nr][nc] = true;
                }
            } 
        }
        System.out.println(ans);
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