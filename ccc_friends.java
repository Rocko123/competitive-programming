import java.util.*;
import java.io.*;
public class ccc_friends {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	// functional graph
    	int n = readInt();
    	int next[] = new int[10000];
    	for (int i = 1; i <= n; i++) {
    		next[readInt()] = readInt();
    	}
    	while (true) {
    		int x = readInt(), y = readInt();
    		if (x == 0 && y == 0) {
    			break;
    		}
    		boolean visited[] = new boolean[10000];
    		int dist = 0;
    		while (!visited[x] && x != y) {
    			visited[x] = true;
    			x = next[x];
    			dist++;
    		}
    		if (x == y) {
    			System.out.println("Yes " + (dist-1));
    		} else {
    			System.out.println("No");
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