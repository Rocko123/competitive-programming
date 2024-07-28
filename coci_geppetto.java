import java.util.*;
import java.io.*;
public class coci_geppetto {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] ban;
    static int n, m, ans = 1;
    static boolean[] vis;
    public static void main(String[] args) throws IOException{
        n = readInt(); m = readInt();

        // am i dumb or is this actually harder than it looks
        ban = new boolean[n+1][n+1]; vis = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt();
            ban[a][b] = ban[b][a] = true;
        }
        // how to elim duplicate pizzas?
        System.out.println(ans);
    }
    static void recur (int start) {
        
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