import java.util.*;
import java.io.*;
public class usaco_swapity_swapity_swap {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] cows;
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt(), k = readInt();
        cows = new int[n+1];
        // idea: finding the cycle of the entire game takes too long
        // try finding the cycle for each individual cow
        for (int i = 1; i <= n; i++) cows[i] = i;

        int[] nxt = new int[n+1], ans = new int[n+1];
        for (int i = 1; i <= m; i++) {
            int L = readInt(), R = readInt();
            reverse(L, R);
        }
        for (int i = 1; i <= n; i++) nxt[i] = cows[i];

        boolean[] vis = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            // finding the cycle finds the answers for every cow in the cycle
            // this caused tle
            if (vis[i]) continue;
            List<Integer> cycle = new ArrayList<>();
            int cur = i;
            for (; !vis[cur]; cur = nxt[cur]) {
                vis[cur] = true;
                cycle.add(cur);
            }
            int size = cycle.size();
            for (int j = 0; j < size; j++) {
                int pos = j + k % size; // mod the cycle steps plus steps to get to current cow
                ans[cycle.get(j)] = cycle.get(pos % size); // loop back incase of overflow
            }
        }
        for (int i = 1; i <= n; i++) System.out.println(ans[i]);
    }
    static void reverse (int l, int r) {
        for (int i = 0; i <= (r-l)/2; i++) {
            int temp = cows[l+i];
            cows[l+i] = cows[r-i];
            cows[r-i] = temp; 
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