import java.util.*;
import java.io.*;
public class vm7wc_uniting_earth_empire {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        Stack<pair> s = new Stack<>();
        long[] hills = new long[n];
        for (int i = 0; i < n; i++) hills[i] = readLong();

        // do it both ways to find hills with b >= a, and b < a
        // same height not working
        // 3
        // 0
        // 0
        // 1
        // ans = 3
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long cnt = 1;
            while (!s.isEmpty() && s.peek().val <= hills[i]) {
                if (s.peek().val == hills[i]) {
                    cnt += s.peek().count;
                }
                ans += s.pop().count;
            }
            s.add(new pair(cnt, hills[i]));
        }
        s.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek().val < hills[i]) {
                s.pop();
                ans++;
            }
            s.add(new pair(1, hills[i]));
        }
        System.out.println(ans);
    }
    static class pair {
        long count, val;
        pair (long count0, long val0) {
            count = count0; val = val0;
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