import java.util.*;
import java.io.*;
public class coci_kratki {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt(), k = readInt();

        if ((long) k * k < (long) n) {
            // max (LIS, LDS) = K
            // #LIS = LDS (not LNDS because all i are distinct)
            // #LIS * LIS ~ n -> LDS * LIS ~ n
            // the minimum is LIS = LDS = sqrt(n)
            System.out.println(-1);
            System.exit(0);
        } 

        for (int i = k; i <= n+k; i += k) {
            // build LDS of size K
            for (int j = Math.min(i, n); j > i-k; j--) {
                System.out.print(j + " ");
            }
        }
        System.out.println();
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