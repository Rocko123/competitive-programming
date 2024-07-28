import java.util.*;
import java.io.*;
public class usaco_palindrome_game {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for (; t > 0; t--) {
            String s = readLine(); // s is very big
            // < 10 = W
            // 10 = L
            // 11-19 = W
            // 20 = L
            // 21 - 29 = W
            // 30 = L

            // random case s = 100
            // take 99 -> L, take 88 -> L, take 77 -> L, take 66 -> L
            if (s.charAt(s.length()-1) == '0') {
                System.out.println('E');
            } else {
                System.out.println('B');
            }
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