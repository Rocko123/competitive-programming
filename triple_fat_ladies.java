import java.util.*;
import java.io.*;
public class triple_fat_ladies {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int t = readInt();
    	for (; t > 0; t--) {
    		int k = readInt();
    		if (k < 192) {
    			System.out.println(192);
    		} else {
    			while (true) {
        			if (k % 10 != 2) {
        				k++;
        			} else {
        				k += 10;
        			}
        			if (isTripleEight(k)) {
        				System.out.println(k);
        				break;
        			}
        		}
    		}
    	}
    	
    }
    
    static boolean isTripleEight (int i) {
    	String suffix = String.valueOf((long)Math.pow(i, 3));
    	return suffix.substring(suffix.length()-3).equals("888");
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