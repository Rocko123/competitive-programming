import java.util.*;
import java.io.*;
public class xor {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // some pattern with multiples of 4
        // see: https://stackoverflow.com/questions/10670379/find-xor-of-all-numbers-in-a-given-range
        // n % 4 = 0 -> a
        // n % 4 = 1 -> 1
        // n % 4 = 2 -> a+1
        // n % 4 = 3 -> 0
        // at 0, val = 0
        // at 1, val = 1
        // at 2, val = 3
        // at 3, val = 0
        // at 4, val = 4
        // at 5, val = 1
        // at 6, val = 7
        // at 7, val = 0 cycle repeats every 4
        int t = readInt();
        for (; t > 0; t--) {
            int s = readInt(), f = readInt();
            System.out.println(getxor(f)^getxor(s-1));
        }
    }
    static long getxor (long n) {
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n+1;
        } else {
            return 0;
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