import java.util.*;
import java.io.*;
public class uts_ianine_lil_lab {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(); 
        long[] monitorsum = new long[(int)1e5 * 2 + 1]; // sum of all monitors for some value coupon
        HashMap<Integer, ArrayList<coupon>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = readInt(), m = readInt();
            if (!map.containsKey(k + m)) map.put(k+m, new ArrayList<coupon>());
            map.get(k+m).add(new coupon(k, m));
            monitorsum[k+m] += m;
        }

        // since the sums are all the same
        // if we sort by K or M, the other will
        // be sorted in reverse order
        // check each coupon to find best balance

        // simpler and faster way
        long ans = 0;
        for (Integer i: map.keySet()) {
            Collections.sort(map.get(i));
            long kbsum = 0; 
            for (coupon j: map.get(i)) {
                kbsum += j.k;
                monitorsum[j.v] -= j.m;
                ans = Math.max(ans, Math.min(kbsum, monitorsum[j.v]));
            }
        }
        System.out.println(ans);
    }
    static class coupon implements Comparable<coupon> {
        int k, m, v;
        coupon (int k0, int m0) {
            k = k0; m = m0; v = k0 + m0;
        }
        public int compareTo(coupon x) {
            return Integer.compare(x.k, k);
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