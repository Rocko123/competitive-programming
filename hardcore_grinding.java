import java.util.*;
import java.io.*;
public class hardcore_grinding {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int[] tasks = new int[(int)1e7+1];
        for (int i = 0; i < n; i++) {
            int s = readInt(), f = readInt();
            tasks[s]++; tasks[f]--;
        }
        int ans = 0;
        int[] psa = new int[(int)1e7+1];
        for (int i = 1; i <= (int)1e7; i++) {
            psa[i] = psa[i-1] + tasks[i];
            ans = Math.max(ans, psa[i]);
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