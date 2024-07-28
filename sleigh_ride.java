import java.util.*;
import java.io.*;
public class sleigh_ride {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	// 2 times the weight of the edges minus the weight of the furthest edge
    	// We need to traverse every path at least twice except for one, to get the min dist
    	// we select the longest path and visit it last so that we don't have to visit it again
    	// must travel every edge twice except the furtherest one to get min time
    	
    	int n = readInt();
    	List<int[]> adj[] = new ArrayList[n+1];
    	for (int i = 0; i <= n; i++) {
    		adj[i] = new ArrayList<>();
    	}
    	
    	int weightSum = 0;
    	for (int i = 0; i < n; i++) {
    		int a = readInt(), b = readInt(), c = readInt();
    		adj[a].add(new int[] {b, c});
    		adj[b].add(new int[] {a, c});
    		weightSum += c;
    	}
    	
    	int furthest = -1;
    	boolean[] visited = new boolean[n+1];
    	int[] dist = new int[n+1];  	
    	Queue<Integer> q = new LinkedList<>();
    	
    	q.add(0);
    	visited[0] = true;
    	while (!q.isEmpty()) {
    		int cur = q.poll();
    		int d = dist[cur];
    		for (int[] i: adj[cur]) {
    			if (!visited[i[0]]) {
    				visited[i[0]] = true;
    				dist[i[0]] = d + i[1];
    				q.add(i[0]); // how did I forget this and how did I pass two cases LOL
    				if (dist[i[0]] > furthest) {
    					furthest = dist[i[0]];
    				}
    			}
    		}
    	}
    	
    	System.out.println(2*weightSum - furthest);
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