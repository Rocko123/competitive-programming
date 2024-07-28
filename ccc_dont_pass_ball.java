import java.util.*;
import java.io.*;
public class ccc_dont_pass_ball {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // highest number has to be the scorer
        int n = readInt();
        if (n < 4) {
            System.out.println(0);
        }  else {
            int ans = 0;
            for (int i = 1; i <= n-3; i++) {
                for (int j = i+1; j <= n-2; j++) {
                    for (int k = j+1; k <= n-1; k++) {
                        if (i < j && j < k && k < n) {
                            ans++;
                        }
                    }
                }
            }
            System.out.println(ans);
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
