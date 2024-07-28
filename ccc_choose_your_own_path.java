import java.io.*;
import java.util.*;

public class ccc_choose_your_own_path {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int n = readInt();
		
		List<Integer> adj[] = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) adj[i] = new ArrayList();
		
		for (int i = 1; i <= n; i++) {
			int m = readInt();
			for (int j = 0; j < m; j++) {
				int mi = readInt();
				adj[i].add(mi);
			}
			if (m == 0) {
				adj[i].add(0);
			}
		}
		
		Queue<Integer> q = new LinkedList();
		boolean[] visisted = new boolean[n+1];
		int[] dist = new int[n+1];
		
		q.add(1);
		visisted[1] = true;
		
		int shortestEnd = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int cur = q.poll();
			int d = dist[cur] + 1;
			for (int i: adj[cur]) {
				if (!visisted[i] && i != 0) {
					if (i != 0) {
						dist[i] = d;
						q.add(i);
						visisted[i] = true;
						}
					} 
					if (i == 0) {
						if (d < shortestEnd) {
							shortestEnd = d;
						}
					}
				}
		}
		
		String allVisisted = "Y";
		for (int i = 1; i <= n; i++) {
			if (visisted[i] == false) {
				allVisisted = "N";
				break;
			}
		}
		
		System.out.println(allVisisted);
		System.out.println(shortestEnd);
		
	}
	
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine().trim());
		}
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
