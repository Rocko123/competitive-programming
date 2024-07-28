import java.util.*;
import java.io.*;
public class usaco_feeding_cows {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	// plant each type of grass as right as possible
    	// since it will satisfy all the cows k greater and k less
    	int t = readInt();
    	for (int i = 0; i < t; i++) {
    		int n = readInt(), k = readInt();
    		char[] cows = readLine().toCharArray();
    		char[] grass = new char[n];
    		Arrays.fill(grass, '.');
    	
    		int patches = 0;
    		int nextG = Integer.MAX_VALUE, nextH = Integer.MAX_VALUE, last = n-1;
    		for (int j = 0; j < n; j++) {
    			while(grass[last] != '.') {
    				last--;
    			}
    			
    			if (cows[j] == 'G') {
    				if (Math.abs(nextG-j) > k) {
    					nextG = (j + k) < n ? j + k: last;
    					grass[nextG] = 'G';
    					patches++;
    				}
    			}
    			
    			if (cows[j] == 'H') {
    				if (Math.abs(nextH-j) > k) {
    					nextH = (j + k) < n ? j + k: last;
    					grass[nextH] = 'H';
    					patches++;
    				}
    			}
    		}
    		
    		
    		System.out.println(patches);
    		for (char j: grass) {
    			System.out.print(j);
    		}
    		System.out.println();
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