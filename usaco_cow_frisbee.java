import java.util.*;
import java.io.*;
public class usaco_cow_frisbee {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // monotonic stack
        int n = readInt();
        int[] cows = new int[n+1];
        Stack<pair> up = new Stack<>(), down = new Stack<>();
        for (int i = 1; i <= n; i++) cows[i] = readInt();

        long ans = 0;
        // do it forwards and backwards
        for (int i = n; i >= 1; i--) {
            while (!up.isEmpty() && up.peek().val <= cows[i]) up.pop();
            ans += up.isEmpty() ? 0: up.peek().idx-i+1;
            up.add(new pair(i, cows[i]));
        }
        for (int i = 1; i <= n; i++) {
            while (!down.isEmpty() && down.peek().val <= cows[i]) down.pop();
            ans += down.isEmpty() ? 0: Math.abs(down.peek().idx-i)+1;
            down.add(new pair(i, cows[i]));
        }
        System.out.println(ans);
    }
    static class pair {
        int idx, val;
        pair (int idx0, int val0) {
            idx = idx0; val = val0;
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