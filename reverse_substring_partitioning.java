import java.util.*;
import java.io.*;
public class reverse_substring_partitioning {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt();
    	char[] s = readLine().toCharArray();
    	// we can RSP if pos[0] == pos[n-1]
    	// optimal index to split is one such that the adjacent letters
    	// to the split are the same
    	// count the areas where s[i] == s[i+1] and s[0] == s[n-1]
    	// if all letters are same answer is 1, since substring > 0
    	if (s[0] != s[n-1]) {
    		System.out.println(n);
    	} else {
    		int count = 1;
    		// aaaa
    		for (int i = 1; i < n; i++) {
    			if (s[i] == s[i-1]) {
    				count++;
    			}
    		}
    		System.out.println(Math.max(1, n-count));
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