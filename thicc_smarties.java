import java.util.*;
import java.io.*;
public class thicc_smarties {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), k = readInt();
        int[] f = new int[n+1], freq = new int[(int) 1e6+1];
        for (int i = 1; i <= n; i++) f[i] =readInt();

        int cnt = 0;
        long ans = 0;
        for (int L = 1, R = 1; R <= n; R++) {
            if (++freq[f[R]] == 1) cnt++;
            while (cnt >= k) {
                ans += (n-R+1);
                if (--freq[f[L]] == 0) cnt--;
                L++;
            }
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