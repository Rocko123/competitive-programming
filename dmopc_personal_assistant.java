import java.util.*;
import java.io.*;
public class dmopc_personal_assistant {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static anime animes[];
    static long dp[];
    public static void main(String[] args) throws IOException{
        int n = readInt();
        dp = new long[n+1]; animes = new anime[n+1];
        for (int i = 1; i <= n; i++) {
            long r = readLong(), l = readLong(), h = readLong();
            animes[i] = (new anime(r, r+l, h));
        }
        Arrays.sort(animes, 1, n+1);
        // for (int i = 1; i <= n; i++) System.out.println(animes[i].l);

        for (int i = 1; i <= n; i++) {
            long happy = animes[i].h;
            int idx = binarySearch(animes[i].r);
            dp[i] = Math.max(dp[i-1], happy + dp[idx]);
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]);
    }
    static int binarySearch (long start) {
        int L = 1, R = animes.length-1, idx = 0;
        while (L <= R) {
            int M = (L+R)/2;
            if (animes[M].l <= start) {
                // since dp[i] always best, the best will be the anime that ended just before
                idx = M;
                L = M+1;
            } else {
                R = M-1;
            }
        }
        return idx;
    }
    static class anime implements Comparable<anime> {
        long r, l, h;
        anime (long r0, long l0, long h0) {
            r = r0; l = l0; h = h0;
        }
        public int compareTo (anime x) {
            return Long.compare(l, x.l);
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