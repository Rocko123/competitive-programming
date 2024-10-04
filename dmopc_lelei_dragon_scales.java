import java.util.*;
import java.io.*;
public class dmopc_lelei_dragon_scales {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int w = readInt(), h = readInt(), n = readInt();

        int[][] field = new int[h+2][w+2];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                field[i][j] = field[i-1][j] + field[i][j-1] - field[i-1][j-1] + readInt();
            }
        }
        int ans = 0;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                for (int k = i; k <= h; k++) {
                    int x2 = Math.min(j + n / (k-i+1)-1, w);
                    // System.out.println(i + " " + j + " " + k + " " + x2);
                    ans = Math.max(ans, field[k][x2]-field[k][j-1]-field[i-1][x2]+field[i-1][j-1]);
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