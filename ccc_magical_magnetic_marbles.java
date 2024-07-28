import java.util.*;
import java.io.*;
public class ccc_magical_magnetic_marbles {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt(), k = readInt();
    	ArrayList<Integer> soloMarbles = new ArrayList<>();
    	String marbles = readLine();
    	int marblesLeft = 0;
    	
    	// greedy approach merge sections that are connected
    	// by the least empty spots
    	// there will always be at least 1 open slot, marblesLeft >= 1
    	boolean start = false;
    	for (int i = 0; i < n; i++) {
    		if (!start && marbles.charAt(i) == '1') {
    			start = true;
    			marblesLeft++;
    		}
    		if (start && marbles.charAt(i) == '1' && (i + 1 == n || marbles.charAt(i+1) == '0')) {
    			start = false;
    			soloMarbles.add(i);
    			// merged all marbles, final marble in right most pos
    		}
    	}
    	ArrayList<Integer> gaps = new ArrayList<>();
    	for (int i = 1; i < soloMarbles.size(); i++) {
    		gaps.add(soloMarbles.get(i) - soloMarbles.get(i-1)-1);
    	}
    	Collections.sort(gaps);
    	
    	for (int i: gaps) {
    		if (k >= i) {
    			k -= i; marblesLeft--;
    		}
    	}
    	if (k > 1 && marblesLeft == 0) marblesLeft = 1;
    	System.out.println(marblesLeft);
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
