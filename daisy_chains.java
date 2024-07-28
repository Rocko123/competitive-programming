import java.util.*;
import java.io.*;
public class daisy_chains {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt();
    	int arr[] = new int[n];
    	
    	for (int i = 0; i < n; i++) {
    		arr[i] = readInt();
    	}
    	
    	int ans = 0;
    	for (int i = 0; i < n; i++) {
    		int sum = 0;
    		for (int j = 1; j < n; j++) {
    			sum += arr[j];
    			boolean found = false;
    			for (int k = i; k <= j; k++) {
    				if(arr[k] * (j - i + 1) == sum) {
    					found = true;
    				}
    			}
    			if (found) {
    				ans++;
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