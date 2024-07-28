import java.io.*;
import java.util.*;

public class ccc_symmetric_mountains {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main (String[] args) throws IOException {
		int n = readInt();
		
		int[] mountains = new int[n+1];
		int[] asymmetric_ans = new int[n+1];
		Arrays.fill(asymmetric_ans, Integer.MAX_VALUE);
		
		for (int i = 1; i <= n; i++) {
			mountains[i] = readInt();
		}
		
		for (int i = 1; i <= n; i++) {
			int asymVal = 0;	// accumulator as more mountains are incorporated in the crop
			
			// number of mountains is odd
			for (int L = i, R = i; L >= 1 && R <= n; L--, R++) {
				asymVal += Math.abs(mountains[L] - mountains[R]);
    			asymmetric_ans[R-L+1] = Math.min(asymmetric_ans[R-L+1], asymVal);
    		}
			
			
			// compute asymmetric for number of mountains is even
    		asymVal = 0;
    		for(int L = i, R = i+1; L >= 1 && R<= n; L--, R++) {
    			asymVal += Math.abs(mountains[L] - mountains[R]);
    			asymmetric_ans[R-L+1] = Math.min(asymmetric_ans[R-L+1], asymVal);
    		}
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(asymmetric_ans[i] + " ");
		}
		
	}
	
	static String next() throws IOException{
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine().trim());
		}
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
