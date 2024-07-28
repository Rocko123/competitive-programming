import java.util.*;
import java.io.*;
public class coci_alias {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> adj[];
    static int n;
    public static void main(String[] args) throws IOException{
    	n = readInt(); int m = readInt();
    	adj = new ArrayList[n];
    	for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    	HashMap<String, Integer> wordKey = new HashMap<>();
    	
    	int wordNum = 0;
    	for (int i = 0; i < m; i++) {
    		String x = next(), y = next(); int t = readInt();
    		if (!wordKey.containsKey(x)) {
    			wordKey.put(x, wordNum);
    			wordNum++;
    		}
    		if (!wordKey.containsKey(y)) {
    			wordKey.put(y, wordNum);
    			wordNum++;
    		}
    		adj[wordKey.get(x)].add(new int[] {wordKey.get(y), t});
    	}
    	
    	int q = readInt();
    	for (; q > 0; q--) {
    		String a = next(), b = next();
    		int ans = dijkstra(wordKey.get(a), wordKey.get(b));
    		System.out.println(ans == Integer.MAX_VALUE ? "Roger": ans);
    	}
    }
    static int dijkstra(int start, int end) {
    	int[] dist = new int[n];
    	boolean[] vis = new boolean[n];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	dist[start] = 0;
    	
    	for (int i = 0; i < n; i++) {
    		int next = -1;
    		int min = Integer.MAX_VALUE;
    		for (int j = 0; j < n; j++) {
    			if (!vis[j] && dist[j] < min) {
    				next = j;
    				min = dist[j];
    			}
    		}
    		if (next == -1) break;
    		vis[next] = true;
    		for (int[] j: adj[next]) {
    			if (dist[j[0]] > dist[next] + j[1]) {
    				dist[j[0]] = dist[next] + j[1];
    			}
    		}
    	}
    	return dist[end];
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
