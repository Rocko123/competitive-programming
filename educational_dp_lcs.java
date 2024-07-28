import java.util.*;
import java.io.*;
public class educational_dp_lcs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String s, t;
    static int[][] dp = new int[30003][3003];
    public static void main(String[] args) throws IOException{
    	s = next(); t = next();

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int r = s.length(), c = t.length();
        StringBuffer sb = new StringBuffer();
        String ans = "";
        while (r > 0 && c > 0) {
            if (dp[r][c] == dp[r-1][c]) {
                r--;
            } else if (dp[r][c] == dp[r][c-1]) {
                c--;
            } else {
                sb.append(s.charAt(r-1));
                r--; c--;
            }
        }
        ans = sb.reverse().toString();
        System.out.println(ans);
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