import java.util.*;
import java.io.*;
public class ny_world_domination {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, k;
    static long ans = Long.MAX_VALUE;
    static long[] snow;
    public static void main(String[] args) throws IOException{
        // idea: instead of trying to always fix the weakest link
        // binary search all possible heights from 1 to 2e9

        n = readInt(); m = readInt(); k = readInt();
        snow = new long[n+1];
        for (int i = 1; i <= n; i++) {
            snow[i] = readLong();
            ans = Math.min(ans, snow[i]);
        }
        System.out.println(solve());
    }
    static long solve () {
        long lo = 1, hi = (long) 2e9;
        while (lo <= hi) {
            long mid = (lo+hi)/2;
            if (check(mid)) {
                ans = mid;
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return ans; 
    }
    static boolean check (long min) {
        long used = 0, cur = 0;
        long[] add = new long[n+1];
        for (int i = 1; i <= n; i++) {
            cur += add[i];
            if (snow[i]+cur >= min) continue;
            long needed = min-(snow[i]+cur);
            used += needed; cur += needed;
            // overflow at n?
            if (i+m <= n) add[i+m] -= needed;
        }
        return used <= k;
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