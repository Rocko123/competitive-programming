import java.util.*;
import java.io.*;
public class ccc_hat_circle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int[] table = new int[2*n];
        for (int i = 0; i < n; i++) table[i] = table[i+n] = readInt();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (table[i] == table[i+n/2]) ans++;
        }
        System.out.println(ans);
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