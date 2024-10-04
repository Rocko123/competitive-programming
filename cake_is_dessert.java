import java.util.*;
import java.io.*;
public class cake_is_dessert {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // 2d dsa template

        int n = readInt(), m = readInt(), k = readInt();
        long[][] cake = new long[m+2][n+2];

        for (; k > 0; k--) {
            int X = readInt(), y = m-readInt()+1, x = readInt(), Y = m-readInt()+1;
            cake[Y][X]++; cake[Y][x+1]--;
            cake[y+1][X]--; cake[y+1][x+1]++;
        }

        for (int t = 1; t <= 2; t++) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    cake[i][j] = cake[i][j-1] + cake[i-1][j] + cake[i][j] - cake[i-1][j-1];
                }
            }
            /*
            for (int i = 1; i <= m; i++) System.out.println(Arrays.toString(cake[i]));
            System.out.println();
            */
        }
        int q = readInt();
        for (; q > 0; q--) {
            int x1 = readInt(), y2 = m-readInt()+1, x2 = readInt(), y1 = m-readInt()+1;
            System.out.println(cake[y2][x2] - cake[y2][x1-1] - cake[y1-1][x2] + cake[y1-1][x1-1]);
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