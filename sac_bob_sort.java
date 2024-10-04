import java.util.*;
import java.io.*;
public class sac_bob_sort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), t = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = readInt();
            t = Math.max(t, a[i]);
        }
        t = (int) Math.log10(t)+1;

        // stupid custom comparator
        int mod = 1;
        pair[] sort;
        for (int i = 1; i <= t; i++) {
            mod *= 10;
            sort = new pair[n];
            for (int j = 0; j < n; j++) {
                sort[j] = new pair(a[j] % mod, a[j]);
            }
            Arrays.sort(sort);
            for (int j = 0; j < n-1; j++) System.out.print(sort[j].i + " ");
            System.out.println(sort[n-1].i);
        }

        /* bruce way
         a.sort((x, y)-> {
    			long x0 = (long)x/(long)Math.pow(10, k) % 10;
    			long y0 = (long)y/(long)Math.pow(10, k) % 10;
    			return Long.compare(x0, y0);
         */
    }
    static class pair implements Comparable<pair> {
        int u, i;
        pair (int u0, int i0) {
            u = u0; i = i0;
        }
        public int compareTo (pair x) {
            return Integer.compare(u, x.u);
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