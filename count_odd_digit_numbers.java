import java.util.*;
import java.io.*;
public class count_odd_digit_numbers {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // multiply by 100, always add 2 digits
        // 1e18 is odd digits but too big to multiply by 10
        long n = readLong();
        long ans = 0;
        for (long i = 1; i <= (long) 1e16; i *= 100) { // overflowed with 1e18 * 10
            if (i*10 <= n) {
                ans += (i*10) - i;
            } else {
                ans += Math.max(0, n-i+1);
                break;
            }
        }
        System.out.println(ans + (n == (long) 1e18 ? 1: 0));
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