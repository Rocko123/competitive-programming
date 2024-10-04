import java.util.*;
import java.io.*;
public class dmopc_tank {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), p = readInt(), m = readInt();
        int[] def = new int[n+1], res = new int[n+1], phy = new int[p+1], mag = new int[m+1];
        long[] psa1 = new long[p+1], psa2 = new long[m+1];
        for (int i = 1; i <= n; i++) {
            def[i] = readInt();
            res[i] = readInt();
        }
        // sorting by damage faster
        for (int i = 1; i <= p; i++) phy[i] = readInt();
        for (int i = 1; i <= m; i++) mag[i] = readInt();
        Arrays.sort(phy); Arrays.sort(mag);
        for (int i = 1; i <= p; i++) psa1[i] = phy[i] + psa1[i-1];
        for (int i = 1; i <= m; i++) psa2[i] = mag[i] + psa2[i-1];

        long val = Long.MAX_VALUE, ans = -1;
        for (int i = 1; i <= n; i++) {
            // takes damage from the start bigger to the end
            // ans is sum from start to end - tank*(end-start+1)
            int pidx = binarySearch(def[i], phy);
            int midx = binarySearch(res[i], mag);
            long sum = psa1[p]-psa1[pidx-1]-(long)def[i]*(p-pidx+1) + psa2[m]-psa2[midx-1]-(long)res[i]*(m-midx+1);
            if (sum < val) {
                val = sum;
                ans = i;
            }
        }
        System.out.println(ans);
    }
    static int binarySearch (int val, int[] arr) {
        int lo = 1, hi = arr.length-1, idx = arr.length;
        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (arr[mid] > val) {
                idx = mid;
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return idx;
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