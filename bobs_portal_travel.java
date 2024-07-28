import java.util.*;
import java.io.*;
public class bobs_portal_travel {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static final int MM = 2*100000+5;
    public static void main(String[] args) throws IOException{
    	// functional graph
    	int n = readInt();
    	long k = readLong();
    	int[] towns = new int[MM];
    	int[] dist = new int[MM];
    	
    	for (int i = 1; i <= n; i++) {
    		towns[i] = readInt();
    	}
    	
    	Arrays.fill(dist, -1);
    	int cur = 1, cycle = 0;
    	while (true) {
    		int next = towns[cur];
    		if (dist[next] != -1 && cycle == 0) { // if it's previously been visited, there is a cycle
    			cycle = dist[cur] - dist[next] + 1; // cycle length
    			k %= cycle; // remove all the cycles from k
    		}
    		if (k == 0) {
        		System.out.println(cur);
        	}
    		k--;
    		// when all cycles are moved, it doesn't matter what happens in dist array,
    		// we just need to node we end up at when k = 0
    		dist[next] = dist[cur] + 1;
    		cur = next;
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