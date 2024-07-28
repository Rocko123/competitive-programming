import java.util.*;
import java.io.*;
public class ccc_chances_winning {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int t, ans = 0;
    static int pts[] = new int[5];
    static List<int[]> remGames = new ArrayList<>();
    public static void main(String[] args) throws IOException{
    	// dfs all possible games
    	t = readInt(); int g = readInt();
    	boolean[][] played = new boolean[5][5];
    	
    	for (int i = 0; i < g; i++) {
    		int a = readInt(), b = readInt();
    		int sa = readInt(), sb = readInt();
    		if (sa > sb) {
    			pts[a] += 3;
    		} else if (sb > sa) {
    			pts[b] += 3;
    		} else {
    			pts[a]++; pts[b]++;
    		}
    		played[a][b] = true;
    	}
    	for (int i = 1; i <= 4; i++) {
    		for (int j = i + 1; j <= 4; j++) {
    			if (!played[i][j]) remGames.add(new int[] {i, j});
    		}
    	}
    	games(0);
    	System.out.println(ans);
    }
    static void games (int start) {
    	if (start == remGames.size()) {
    		// played all remaining games, tall up W's
    		boolean win = true;
    		for (int i = 1; i <= 4; i++) {
    			if (i != t && pts[i] >= pts[t]) win = false;
    		}
    		if (win) ans++;
    		return;
    	}
    	// simulate all possible game outcomes
    	int a = remGames.get(start)[0], b = remGames.get(start)[1];
    	pts[a] += 3; games(start+1); pts[a] -= 3; // a wins
    	pts[b] += 3; games(start+1); pts[b] -= 3; // b wins
    	pts[a]++; pts[b]++; games(start+1); pts[a]--; pts[b]--; // tie
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
