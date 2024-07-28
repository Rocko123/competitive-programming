import java.util.*;
import java.io.*;

public class mwc_bad_news {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
    static char[][] grid;
    static boolean[][] vis;
	static int dir[][] = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	public static void main(String args[]) throws IOException {
		// bfs/dfs word search, "No letter can be used more than once 
		// in the making of a single word" means in the grid not word itself

		n = readInt(); int queries = readInt();
		
		grid = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = readCharacter();
			}
		}

		for (; queries > 0; queries--) {
			String word = readLine();
			boolean found = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == word.charAt(0)) {
						vis = new boolean[n][n];
						if (dfs(i, j, word, 1)) {
                            found = true;
                            break;
                        }
					}
					if (found) {
						break;
					}
				}
				if (found) {
					break;
				}
			}
			if (found) {
				System.out.println("good puzzle!");
			} else {
				System.out.println("bad puzzle! ");
			}
		}
	}

    static boolean dfs (int y, int x, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        vis[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int newY = y + dir[i][0];
            int newX = x + dir[i][1];
            if (inBounds(newX, newY) && !vis[newY][newX] && grid[newY][newX] == word.charAt(index)) {
                if (dfs(newY, newX, word, index+1)) {
                    return true;
                }
            }
        }
        vis[y][x] = false;
        return false;
        // I still don't know why this is the full solution
    }

	static boolean inBounds (int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine().trim());
		}
		return st.nextToken();
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
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
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	
}