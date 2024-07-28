import java.util.*;
import java.io.*;
public class factors {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	long a = readLong(), b = readLong();

        if (a == b && a == 1) {
            System.out.println(1);
            System.exit(0);
        }

        long n = b-a+1;
        long sum = n * (a + b)/2;
        // System.out.println(sum);
        System.out.println(factor(sum));
    }
    static long factor (long n) {
        long facts = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) facts += 2;
        }
        return facts;
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