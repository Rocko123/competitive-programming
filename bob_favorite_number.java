import java.util.*;
import java.io.*;
public class bob_favorite_number {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // factors always come in pairs, if its a perfect square its counted once
        // remove all perfect squares from 1 - n -> sqrt(n)
        int n = readInt();
        int squares = 0;
        for (int i = 1; i * i <= n; i+= 2) squares++;
        System.out.println((n+1)/2 - squares);
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