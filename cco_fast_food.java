import java.util.*;
import java.io.*;
public class cco_fast_food {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k, ans = 0;
    static int[] stores, out;
    public static void main(String[] args) throws IOException{
        // binary search the dist
        n = readInt(); k = readInt();
        stores = new int[n+1]; out = new int[k+1];
        for (int i = 1; i <= n; i++) stores[i] = readInt();
        int zero = readInt();
        if (zero == 0) zero = 0;

        binarySearch();
        check(ans);
        for (int i = 1; i < k; i++) System.out.print(out[i] + " ");
        System.out.println(out[k]);
        System.out.println(ans);
        System.out.println();
    }
    static void binarySearch () {
        int L = 0, R = stores[n]-stores[1];
        while (L <= R) {
            int M = (L+R)/2;
            if (check(M)) {
                ans = M;
                R = M-1;
            } else {
                L = M+1;
            }
        }
    }
    static boolean check (int d) {
        // check function implementations not working at all
        int start = 1, j = 1;
        for (int i = 1; i <= k; i++) {
            j = start;
            while (j <= n && stores[j]-stores[start] <= d) j++;
            out[i] = stores[j-1]; start = j;
            while (start <= n && stores[start]-out[i] <= d) start++;
        }
        return start == n+1;
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