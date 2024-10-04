import java.util.*;
import java.io.*;
public class smac_jumpscotch {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), d = readInt();
        int[] a = new int[n+1], dp = new int[n+1];
        for (int i = 1; i <= n; i++) a[i] = readInt();

        dp[1] = a[1];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(a[1], 1));
        for (int i = 2; i <= n; i++) {
            while (i-pq.peek().idx > d) pq.poll();
            dp[i] = pq.peek().val + a[i];
            pq.add(new pair(dp[i], i));
        }
        System.out.println(dp[n]);
    } 
    static class pair implements Comparable<pair> {
        int val, idx;
        pair (int val0, int idx0) {
            val = val0; idx = idx0;
        }
        public int compareTo (pair x) {
            return Integer.compare(val, x.val);
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