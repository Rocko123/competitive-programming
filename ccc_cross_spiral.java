import java.util.*;
import java.io.*;
public class ccc_cross_spiral {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] grid;
    static int C, R;
    // order, k-1, k, k+1
    public static void main(String[] args) throws IOException{
    	C = readInt(); R = readInt();
    	int bc = readInt(), br = readInt();
    	int steps = readInt();
    	
    	grid = new int[R+1][C+1];
    	for (int i = 1; i <= R; i++) {
    		for (int j = 1; j <= C; j++) {
    			if ((i <= br || i > R-br) && (j <= bc || j > C-bc)) {
    				grid[i][j] = -1;
    			}
    		}
    	}

    	
    	int r = 1, c = bc+1, cur = 1;
    	for (int i = 1; i <= steps; i++) {
    		grid[r][c] = i;
    		boolean stuck = true;
    		for (int j = -1; j <= 1; j++) {
    			int nCur = (j + cur + 4) % 4;
    			int nr = r + dir[nCur][0], nc = c + dir[nCur][1];
    			if (inG(nc, nr)) {
    				r = nr; c = nc; cur = nCur; stuck = false;
    				// System.out.println("cur:" + cur);
    				break;
    			}
    		}
    		if (stuck) break;
    	}
    	System.out.println(c);
    	System.out.println(r);
    	
    	/*
    	for (int i = 1; i <= r; i++) {
    		System.out.println(Arrays.toString(grid[i]));
    	}
    	*/
    }
    static boolean inG (int x, int y) {
    	return x >= 1 && x <= C && y >= 1 && y <= R && grid[y][x] == 0;
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
