import java.util.*;
import java.io.*;
public class cheeseburger_corollary_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int t = readInt();
    	
    	for (int i = 1; i <= t; i++) {
    		int s = readInt();
        	int d = readInt();
        	int k = readInt();
        	
        	int buns = (s+d) * 2;
        	int burgers = s + d*2;
        	
        	int kbuns = k+1;
        	int kburgers = k;
        	
        	if (buns >= kbuns && burgers >= kburgers) {
        		System.out.printf("Case #%d: YES\n", i);
        	} else {
        		System.out.printf("Case #%d: NO\n", i);
        	}
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