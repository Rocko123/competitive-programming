import java.util.*;
import java.io.*;
public class oths_explosion {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), d = readInt();
        int[] towers = new int[n+1], dsa = new int[n+1];
        for (int i = 1; i <= n; i++) towers[i] = readInt();
        for (int i = 1; i <= n; i++) dsa[i] = towers[i] - towers[i-1];

        int ans = 0, longest = 0, curRunning = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                ans++;
            } else {
                if (Math.abs(dsa[i]) <= d) {
                    curRunning++;
                } else {
                    ans++;
                    curRunning = 0;
                }
            }
            longest = Math.max(curRunning, longest);
        }
        System.out.println(ans);
        System.out.println(longest + 1); // counted consecutive explosion wrong if longest is not at start
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