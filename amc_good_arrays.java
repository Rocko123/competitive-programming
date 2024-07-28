import java.util.*;
import java.io.*;
public class amc_good_arrays {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        int n = readInt(), mod = (int) 1e9+7;
        // dp state: num good arrays for first i nums
        // dp transition: dp[n-1] + dp[n-3] + 1
        // we can take all the good arrays from n-1 and create an array of [n]
        // we can take n-3 
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