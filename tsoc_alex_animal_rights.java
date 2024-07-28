import java.util.*;
import java.io.*;
public class tsoc_alex_animal_rights {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int r = readInt(), c = readInt();
    	
    	char[][] matrix = new char[r][c];
    	for (int i = 0; i < r; i++) {
    		matrix[i] = readLine().toCharArray();
    	}
    	
    	int rooms = 0;
    	for (int i = 0; i < r; i++) {
    		for (int j = 0; j < c; j++) {
    			if (matrix[i][j] == 'M') {
    				int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    				Queue<int[]> q = new LinkedList();
    				q.add(new int[] {i, j});
    				while (!q.isEmpty()) {
    					int[] cur = q.poll();
    					int y = cur[0];
    					int x = cur[1];
    					for (int k = 0; k < 4; k++) {
    						int nr = y + dir[k][0];
    						int nc = x + dir[k][1];
    						if (nr >= 0 && nr < r && nc >= 0 && nc < c && matrix[nr][nc] != '#') {
    							q.add(new int[] {nr, nc});
    							matrix[nr][nc] = '#';
    						}
    					}
    				}
    				rooms++;
    			}
    		}
    	}
    	System.out.println(rooms);
    	
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