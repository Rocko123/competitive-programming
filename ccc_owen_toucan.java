import java.util.*;
import java.io.*;
public class ccc_owen_toucan {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt(), k = readInt();
    	int[] a = new int[n];
    	for (int i = 0; i < n; i++) a[i] = i+1; // initially have n distinct
    	for (int i = 0; i + 1 < n -(k-1); i++) a[i] = a[i+1]; // elements from 0 to less than n - (k-1) to be 1
    	a[n-(k-1)-1] = 1; // end of 1 section
    	for (int i = 0; i < n; i++) {
    		System.out.print(a[i] + (i==n-1? "\n": " "));
    	}
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
