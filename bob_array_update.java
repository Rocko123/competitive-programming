import java.util.*;
import java.io.*;
public class bob_array_update {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), q = readInt();
        long[] a = new long[n+3], a2 = new long[n+3];
        for (; q > 0; q--) {
            int op = readInt();
            if (op == 1) {
                int L = readInt(), R = readInt();
                a[L]++; a[R+1]--;
            } else {
                int L = readInt(), R = readInt();
                a2[L]++; a2[R+1] -= (R-L+1) + 1; a2[R+2] += (R-L+1);
                // another way of cancelling the extra from the second psa
                // first time make R+1 negative by an extra (R-L+1), -(R-L+1)-1, and then add
                // back (R-L+1) to R+2 to cancel it out on the first psa, basically leaving
                // L = 1, R+1 = -1 on the first pass
            }
        }
        for (int i = 1; i <= n; i++) {
            a[i] += a[i-1];
            a2[i] += a2[i-1];
        }
        for (int i = 1; i <= n; i++) a2[i] += a2[i-1];
        for (int i = 1; i < n; i++) System.out.print(a[i] + a2[i] + " ");
        System.out.println(a[n] + a2[n]);
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