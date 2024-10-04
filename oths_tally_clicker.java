import java.util.*;
import java.io.*;
public class oths_tally_clicker {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int ans = 0;
        if (n >= 9999) {
            ans = 9 + n % 9999;
        } else if (n >= 8888) {
            ans = 8 + n % 8888;
        } else if (n >= 7777) {
            ans = 7 + n % 7777;
        } else if (n >= 6666) {
            ans = 6 + n % 6666;
        } else if (n >= 5555) {
            ans = 5 + n % 5555;
        } else if (n >= 4444) {
            ans = 4 + n % 4444;
        } else if (n >= 3333) {
            ans = 3 + n % 3333;
        } else if (n >= 2222) {
            ans = 2 + n % 2222;
        } else if (n >= 1111) {
            ans = 1 + n % 1111;
        } else {
            ans = n;
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