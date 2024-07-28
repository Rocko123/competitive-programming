import java.util.*;
import java.io.*;
public class ccc_golf {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int dist = readInt(), numClubs = readInt();
 
    	int[] clubs = new int[numClubs+1];
    	int[] dp = new int[dist+1]; // stores the number of clubs needed to get to a dist i
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	for (int i = 1; i <= numClubs; i++) {
    		clubs[i] = readInt();
    		dp[clubs[i]] = 1;
    	}
    	
    	for (int i = 1; i <= numClubs; i++) {
    		for (int j = 1; j <= dist; j++) {
    			// compute all possible distances
    			if (clubs[i] <= j && dp[j-clubs[i]] != Integer.MAX_VALUE) {
    				// if the club is less than or equal to a distance j and we have some way to get to 
    				// get there such that their sums is j, we take the minimum distance (num clubs) from the current 
    				// path and the previous (max val if no previous)
    				dp[j] = Math.min(dp[j], dp[j-clubs[i]] + 1);
    			}
    		}
    	}
    	System.out.println(dp[dist] == Integer.MAX_VALUE ? "Roberta acknowledges defeat.": "Roberta wins in " + dp[dist] + " strokes.");
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
