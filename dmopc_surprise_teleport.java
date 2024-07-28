import java.util.*;
import java.io.*;
public class dmopc_surprise_teleport {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int r = readInt(), c = readInt();
    	int sr = readInt(), sc = readInt(), er = readInt(), ec = readInt();
    	
    	char[][] matrix = new char[r][c];
    	for (int i = 0; i < r; i++) {
    		matrix[i] = readLine().toCharArray();
    	}
    	int wTP = -1;
    	 
    	boolean[][] visited = new boolean[r][c];
    	int[][] dist = new int[r][c];
    	Queue<int[]> q = new LinkedList<>();
    	
    	visited[sr][sc] = true;
    	q.add(new int[] {sr, sc});
    	
    	int[][] directions = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
    	while (!q.isEmpty()) {
    		int[] cur = q.poll();
    		int y = cur[0];
    		int x = cur[1];
    		int d = dist[y][x] + 1;
    		for (int i = 0; i < 4; i++) {
    			int nr = y + directions[i][0];
    			int nc = x + directions[i][1];
    			if (nr >= 0 && nr < r && nc >= 0 && nc < c && matrix[nr][nc] != 'X') {
    				if (!visited[nr][nc]) {
    					dist[nr][nc] = d;
    					visited[nr][nc] = true;
    					q.add(new int[] {nr, nc});
    				}
    			}
    		}
    	}
    	
    	wTP = dist[er][ec];
    	
    	int t = readInt();
    	for (int i = 0; i < t; i++) {
    		int y = readInt();
    		int x = readInt();
    		if (visited[y][x]) {
    			wTP = Math.min(wTP, dist[y][x]);
    		}
    	}
    	
    	System.out.println(dist[er][ec]-wTP);
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