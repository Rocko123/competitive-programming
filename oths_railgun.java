import java.util.*;
import java.io.*;
public class oths_railgun {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), s = readInt(), t = readInt();
        int[] robots = new int[n], psa = new int[n];
        for (int i = 0; i < n; i++) {
            robots[i] = readInt();
            if (i == 0) {
                psa[i] = robots[i];
            } else {
                psa[i] = psa[i-1] + robots[i];
            }
        }
        int ans = 0;
        for (int i = 0; i <= t; i++) {
            int L = i*s, R = (t-i)*s;
            if (L + R >= n) {
                ans = psa[n-1];
                break;
            }
            if (L == 0) {
                ans = psa[n-1] - psa[n-R-1];
                continue;
            }
            if (R == 0) {
                ans = Math.max(ans, psa[L-1]);
                break;
            }
            ans = Math.max(ans, psa[L-1] + psa[n-1] - psa[n-R-1]);
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