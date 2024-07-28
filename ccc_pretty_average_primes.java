import java.util.*;
import java.io.*;
public class ccc_pretty_average_primes {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int t = readInt();
    	
    	for (int i = 0; i < t; i++) {
    		int n = readInt();
    		int sum = 2 * n;
    		int start = n % 2 == 0 ? n+1: n;
    		while (true) {
    			// only have to loop at most to n
    			if (isPrime(start) && isPrime(sum-start)) {
    				System.out.println(start + " " + (sum-start));
    				break;
    			} else {
    				start += 2;
    			}
    		}
    	}
    }
    
    static boolean isPrime (int n) {
    	// when i < 2, it's not prime
    	for (int i = 2; i <= Math.sqrt(n); i++) {
    		if (n % i == 0) {
    			return false;
    		}
    	}
		return true;
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