import java.util.*;
import java.io.*;
public class coci_stol {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // loop the height and then use two pointers to find if the section is clear

        int R = readInt(), C = readInt();
        int[][] psa = new int[R+1][C+1];
        for (int i = 1; i <= R; i++) {
            String s = readLine();
            for (int j = 1; j <= C; j++) {
                psa[i][j] = psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1] + (s.charAt(j-1) == '.' ? 0: 1);
            }
        }
        int ans = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = i; j <= R; j++) {
                int l = 1, r = 1;
                for (; r <= C; r++) {
                    int val = psa[j][r] - psa[j][l-1] - psa[i-1][r] + psa[i-1][l-1];
                    if (val == 0) {
                        ans = Math.max(ans, (j-i+1 + r-l+1)*2 -1);
                    } else {
                        l = r+1; // bring the left pointer up to r again
                    }
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