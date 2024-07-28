import java.util.*;
import java.io.*;
public class is_it_tree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int adj[][] = new int[4][4]; // 4 x 4 matrix
    	
    	int sum = 0;
    	boolean connected = true;
    	
    	for (int i = 0; i < 4; i++) {
    		int row = 0;
    		for (int j = 0; j < 4; j++) {
    			adj[i][j] = readInt();
    			sum += adj[i][j]; // check number of adj vertices
    			row += adj[i][j]; // check if its at least connected
    		}
    		if (row == 0) {
    			connected = false; // not connected, not tree
    		}
    	}
    	if (sum == 6 && connected) { // 4 x (4-1) / 2, sum of edges in tree
			System.out.println("Yes");
		} else {
			System.out.println("No");
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