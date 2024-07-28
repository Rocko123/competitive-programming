import java.util.*;
import java.io.*;
public class usaco_swapity_swap {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	// 12 pointer not 7 pointer
    	int n = readInt(), m = readInt(), k = readInt();
    	int a[] = new int[n+1], next[] = new int[n+1];
    	for (int i = 1; i <= n; i++) {
    		a[i]= i;
    	}
    	for (int i = 1; i <= m; i++) {
    		int l = readInt(), r = readInt();
    		reverse(a, l, r);
    	}
    	for (int i = 1; i <= n; i++) {
    		next[a[i]] = i;
    	}
    	
    	// use bfs to find cycle instead
    	boolean visited[] = new boolean[n+1];
    	int[] ans = new int[n+1];
    	for (int i = 1; i <= n; i++) {
    		if (visited[i]) {
    			continue;
    		}
    		List<Integer> cycle = new ArrayList<>();
    		for (int cur = i; !visited[cur]; cur = next[cur]) {
    			visited[cur] = true;
    			cycle.add(cur);
    		}
    		int rem = k % cycle.size();
    		for (int j = 0; j < cycle.size(); j++) {
    			int pos = cycle.get((j + rem) % cycle.size());
    			ans[pos] = cycle.get(j);
    		}
    	}
    	
    	for (int i = 1; i <= n; i++) {
    		System.out.println(ans[i]);
    	}
    }
    
    static void reverse (int a[], int l, int r)  {
    	for (int i = l, j = r; i < j; i++, j--) {
    		int temp = a[i];
    		a[i] = a[j];
    		a[j] = temp;
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