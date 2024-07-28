import java.util.*;
import java.io.*;
public class ioi_palindrome {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt();
        String s = readLine();

        int[][] dp = new int[2][n+1];

        for (int i = n-1; i >= 1; i--) { // loop L end points from n-1 to 1
            for (int j = i+1; j <= n; j++) { // loop right end point to N
                if (s.charAt(i-1) == s.charAt(j-1)) {
                    dp[i%2][j] = dp[(i+1)%2][j-1]; // end points are the same answer is in other row
                    // new problem is the string L to R+1
                } else {
                    dp[i%2][j] = Math.min(dp[(i+1)%2][j], dp[i%2][j-1]) + 1;
                    // min of inserting from the L or R
                }
            }
        }
        System.out.println(dp[1][n]); // ? how is it always in 1
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