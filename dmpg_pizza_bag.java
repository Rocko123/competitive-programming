import java.util.*;
import java.io.*;
public class dmpg_pizza_bag {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // idea: sliding window
        // build the psa and then find the min to remove from [i-k+1, i-1]
        int n = readInt(), k = readInt();
        int[] pizza = new int[2*n+1];
        long[] psa = new long[2*n+1];
        for (int i = 1; i <= n; i++) pizza[i] = pizza[i+n] = readInt();
        for (int i = 1; i <= 2*n; i++) psa[i] = (long) psa[i-1] + pizza[i];
        //System.out.println(Arrays.toString(psa));

        Deque<pair> dq = new ArrayDeque<>();
        for (int i = n-k; i < n; i++) {
            while (!dq.isEmpty() && dq.peekLast().val > psa[i]) dq.pollLast();
            dq.add(new pair(psa[i], i));
        }

        long ans = 0;
        for (int i = n; i <= 2*n; i++) {
            while (i-dq.peekFirst().idx > k) dq.pollFirst();
            ans = Math.max(ans, psa[i]-dq.peekFirst().val);
            while (!dq.isEmpty() && dq.peekLast().val > psa[i]) dq.pollLast();
            dq.add(new pair(psa[i], i));
        }
        System.out.println(ans);
        // DO NOT CODE AT 1 AM!!!
    } 
    static class pair implements Comparable<pair> {
        long val;
        int idx;
        pair (long val0, int idx0) {
            val = val0; idx = idx0;
        }
        public int compareTo (pair x) {
            return Long.compare(val, x.val);
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