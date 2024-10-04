import java.util.*;
import java.io.*;
public class split_array {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    public static void main(String[] args) throws IOException{
        n = readInt();
        long[] a = new long[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = a[i-1] + readInt();
        }
        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (Math.abs(a[n]-2*a[i]) < ans) {
                ans = Math.abs(a[n]-2*a[i]);
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