import java.util.*;
import java.io.*;
public class ccc_rgb_words {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	long rgb = 0;
    	int n = readInt();
    	String s = readLine();
    	// psa if wa
    	// test case:
    	/*
    	 5
		 RRGBB
		 4
    	 */
    	int[] r = new int[n+1];
    	int[] b = new int[n+1];
    	ArrayList<Integer> g = new ArrayList<>();
    	
    	for (int i = 1; i <= n; i++) {
    		if (s.charAt(i-1) == 'G') {
    			g.add(i);
    		}
    		if (s.charAt(i-1) == 'R') {
    			r[i] = r[i-1] + 1;
    		} else {
    			r[i] = r[i-1];
    		}
    		if(s.charAt(i-1) == 'B') {
    			b[i] = b[i-1] + 1;
    		} else {
    			b[i] = b[i-1];
    		}
    	}
    	// for all R's starting from the previous G index to the current times
    	// all the B's from the current G index to the next G index
    	// the current R-1 or B+1 may not exist
    	
    	for (int i = 0; i < g.size(); i++) {
    		boolean back = false, front = false;
    		if (i - 1 >= 0) back = true;
    		if (i + 1 < g.size()) front = true;
    		if (front && back) {
    			rgb += (long)(r[g.get(i)] - r[g.get(i-1)]) * (b[g.get(i+1)] - b[g.get(i)]);
    		} else if (front) {
    			rgb += (long)r[g.get(i)] * (b[g.get(i+1)] - b[g.get(i)]);
    		} else if (back) {
    			rgb += (long)(r[g.get(i)] - r[g.get(i-1)]) * (b[n] - b[g.get(i)]);
    		} else {
    			rgb += (long)r[g.get(i)] * (b[n] - b[g.get(i)]);
    		}
    	}
    	System.out.println(rgb);
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
