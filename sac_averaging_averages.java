import java.util.*;
import java.io.*;
public class sac_averaging_averages {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), q = readInt();
        int[] grades = new int[n+1];
        for (int i = 1; i <= n; i++) {
            grades[i] = grades[i-1] + readInt();
        }
        
        for (; q > 0; q--) {
            int l = readInt(), r = readInt();
            System.out.println((grades[r]-grades[l-1])/(r-l+1));
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