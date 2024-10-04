import java.util.*;
import java.io.*;
public class bob_digit_sum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // keep as string, at most 1001 chars * 1000 number within time
        int n = readInt();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String x = readLine();
            int val = 0;
            for (int j = 0; j < x.length(); j++) {
                val += (int) x.charAt(j)-48;
            }
            ans = Math.max(ans, val);
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