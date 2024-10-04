import java.util.*;
import java.io.*;
public class ccc_pinball_ranking {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] bit = new int[100001];
    public static void main(String[] args) throws IOException{
        // new way
        // sort by decreasing values, then index
        // update the bit at the cur idx and find the sum of elements with indicies >= you
        // since its sorted by values then index, you get exaclty the number of elements idx < you val >= you
        
        int t = readInt();

        pair[] games = new pair[t+1];
        for (int i = 1; i <= t; i++) games[i] = new pair(readInt(), i);
        Arrays.sort(games, 1, t+1);

        long ans = 0;
        for (int i = 1; i <= t; i++) {
            update(games[i].idx);
            ans += query(games[i].idx);
        }
        System.out.println((double) ans/t);
    }
    static int query (int idx) {
        int sum = 0;
        for (int i = idx; i > 0; i-=(i&-i)) { // get lsb and move upwards
            sum+=bit[i];
        }
        return sum;
    }
    static void update (int idx) {
        for (int i = idx; i <= 100000; i+=(i&-i)) { // propagate val down the tree
            bit[i]++;
        }
    }
    static class pair implements Comparable<pair> {
        int val, idx;
        pair (int val0, int idx0) {
            val = val0; idx = idx0;
        }
        public int compareTo (pair x) {
            if (x.val == val) {
                return Integer.compare(x.idx, idx);
            } else {
                return Integer.compare(x.val, val);
            }
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
