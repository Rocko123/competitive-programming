import java.util.*;
import java.io.*;
public class no_more_separation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt();
    	int m = readInt();
    	
    	for (int i = 1; i <= n; i++) {
    		for (int j = (i+1); j <= n; j++) {
    			System.out.println(i + " " + j);
    			m--;
    			if (m == 0) {
    				System.exit(0);
    			}
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