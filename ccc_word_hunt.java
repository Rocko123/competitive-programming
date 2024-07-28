import java.io.*;
import java.util.*;

public class ccc_word_hunt {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] grid;
	static int r, c;
	static char[] w;
	static int found = 0;
	// static boolean found = false; // can't use boolean because multiple answers
	// can result from one starting path, ex1 sample 2
	static int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	public static void main (String[] args) throws IOException {
		// dfs
		w = readLine().toCharArray();
		r = readInt(); c = readInt();
		grid = new char[r][c];
		
		for (int i = 0; i < r; i++) {
			grid[i] = readLine().replaceAll("\\s", "").toCharArray();
		}
		
		int count = 0;
		for (int i = 0; i < r; i ++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == w[0]) {
					for (int k = 0; k < 8; k++) {
						int x = j + dir[k][0];
						int y = i + dir[k][1];
						if (inBounds(x, y) && grid[y][x] == w[1]) {
							dfs(x, y, k, 2, false);
						}
					}
				}
			}
		}
		System.out.println(found);
		
	}
	static void dfs(int x, int y, int heading, int index, boolean turned) {
		if (index == w.length) {
			found++;
			return;
		}
		if (!turned){
			for (int i = heading % 2; i < 8; i+= 2) {
				int curX = x + dir[i][0];
				int curY  = y + dir[i][1];
				int back = (heading + 4) % 8;
				if (inBounds(curX, curY) && grid[curY][curX] == w[index] && i != back) {
					if (i != heading) {
						dfs(curX, curY, i, index+1, true);
					} else {
						dfs(curX, curY, i, index+1, false);
					}
				}
			}
		} else{
			int curX = x + dir[heading][0];
			int curY = y + dir[heading][1];
			if (inBounds(curX, curY) && grid[curY][curX] == w[index]) {
				dfs(curX, curY, heading, index+1, true);
			}
		}
	}
	
	static boolean inBounds (int x, int y) {
		return x >= 0 && x < c && y >= 0 && y < r;
	}
	
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine().trim());
		}
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static long readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}