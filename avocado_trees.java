import java.util.*;
import java.io.*;
public class avocado_trees {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // only consider reachable avacodes to build psa
    	int max = 0;
        int n = readInt(), q = readInt(), h = readInt();
        int[] psa = new int[n+1];
        for(int i = 1; i <= n; i++) {
            int height = readInt();
            int avocados = readInt();
            if (height <= h) {
                psa[i] = psa[i-1] + avocados;
            } else {
                psa[i] = psa[i-1];
            }
        }

        for (int i = 0; i < q; i++) {
            int L = readInt(), R = readInt();
            if (psa[R] - psa[L-1] > max) {
                max = psa[R] - psa[L-1];
            }
        }
        System.out.println(max);
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
