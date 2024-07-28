import java.util.*;
import java.io.*;
public class ccc_ragaman {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int[] freq = new int[26];
    	char[] word1 = readLine().toCharArray();
    	
    	for (char i: word1) freq[i-'a']++;
    	
    	char[] word2 = readLine().toCharArray();
    	for (char i: word2) {
    		if (i == '*'){
    			continue;
    		}
    		else if (freq[i-'a'] == 0) {
    			System.out.println("N");
    			System.exit(0);
    		} else {
    			freq[i-'a']--;
    		}
    	}
    	System.out.println("A");	
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