import java.util.*;
import java.io.*;
public class ccc_keep_on_truckin {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // check how many ways we can reach i from j, sum up the ways for j
        // dp use smaller problems to solve larger problem
        int[] predef = {0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000};
        ArrayList<Integer> motels = new ArrayList<>();
        for (int i = 0; i < predef.length; i++) motels.add(predef[i]);
        int a = readInt(), b = readInt(), n = readInt();
        for (int i = 0; i < n; i++) {
            motels.add(readInt());
        }
        Collections.sort(motels);
        long[] dp = new long[motels.size()];
        dp[0] = 1; 
        for (int i = 1; i < motels.size(); i++) {
            for (int j = 0; j < i; j++) {
                int dist = motels.get(i) - motels.get(j);
                if (a <= dist && dist <= b) {
                    // if the distance between the motels is valid
                    // all the ways to get the previous motel must be
                    // able to get to the current motel
                    dp[i] += dp[j];
                }
            }
        }
        System.out.println(dp[dp.length-1]);
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