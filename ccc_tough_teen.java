import java.util.*;
import java.io.*;
public class ccc_tough_teen {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	// topo sort + priority queue
    	List<Integer> adj[] = new ArrayList[8];
    	for (int i = 1; i <= 7; i++) adj[i] = new ArrayList<>();
    	int[] inDeg = new int[8];
    	
    	adj[1].add(7); inDeg[7]++;
    	adj[1].add(4); inDeg[4]++;
    	adj[2].add(1); inDeg[1]++;
    	adj[3].add(4); inDeg[4]++;
    	adj[3].add(5); inDeg[5]++;

    	while (true) {
    		int x = readInt(), y = readInt();
    		if (x == 0) break;
    		inDeg[y]++;
    		adj[x].add(y);
    	}
    	
    	PriorityQueue<Integer> q = new PriorityQueue<>();
    	for (int i = 1; i <= 7; i++) {
    		if (inDeg[i] == 0) {
    			q.add(i);
    		}
    		
    	}
    	
    	ArrayList<Integer> ans = new ArrayList<>();
    	while (!q.isEmpty()) {
    		int cur = q.poll();
    		ans.add(cur);
    		for (int i: adj[cur]) {
    			if (--inDeg[i] == 0) q.add(i);
    		}
    	}
    	
    	if (ans.size() != 7) {
    		System.out.println("Cannot complete these tasks. Going to bed.");
    	} else {
    		for (int i: ans) {
    			System.out.print(i + " ");
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