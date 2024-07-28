import java.util.*;
import java.io.*;
public class dmopc_shoe_shopping {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt();
        double[] shoes = new double[n+1], dp = new double[n+1];
        for (int i = 1; i <= n; i++) {
            shoes[i] = readDouble();
            dp[i] = dp[i-1] + shoes[i]; // purchase shoe without discount
            if (i >= 2) {
                dp[i] = Math.min(dp[i], dp[i-2] + shoes[i-1] + shoes[i] - 0.5 * Math.min(shoes[i-1], shoes[i]));
                // pick 2 shoe discount, take the lowest price of the first i-2 shoes, the use the discount on the i-1 and i shoe
            }
            if (i >= 3) {
                dp[i] = Math.min(dp[i], dp[i-3] + shoes[i-2] + shoes[i-1] + shoes[i] - Math.min(shoes[i-2], Math.min(shoes[i-1], shoes[i])));
                // same idea as above with dif discount
            }
        }
        System.out.printf("%.1f\n", dp[n]);
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