import java.util.*;
import java.io.*;
public class bobs_portal_travel {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // binary lifting way
    	int n = readInt();
        long k = readLong();
        int[][] bl_table = new int[60][n+1]; // switch dimensions improves cache hit

        for (int i = 1; i <= n; i++) {
            bl_table[0][i] = readInt();
        }
        for (int i = 1; i < 60; i++) { // every power of 2
            for (int j = 1; j <= n; j++) { // every node
                bl_table[i][j] = bl_table[i-1][bl_table[i-1][j]];
                // 2^(i-1) + 2^(i-1)
            }
        }
        // for (int i = 1; i <= n; i++) System.out.println(Arrays.toString(bl_table[i]));

        int cur = 1;
        for (int i = 59; i >= 0; i--) {
            if (((k >> i) & 1) != 0) { // bit is true take that many steps from current
                // System.out.println(i);
                cur = bl_table[i][cur];
            }
        }
        System.out.println(cur);
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