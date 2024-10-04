import java.util.*;
import java.io.*;
public class ccc_pennies_in_ring {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // gauss circle problem
        // idea: from 0 to r, find the difference of
        // r - floor(sqrt (r^2 - y^2))

        while (true) {
            int r = readInt();
            if (r == 0) System.exit(0);
            int remove = 0;
            for (int i = 1; i <= r; i++) {
                // System.out.println(r-Math.floor(Math.sqrt(r*r-i*i)));
                remove += r-Math.floor(Math.sqrt(r*r-i*i));
            }
            System.out.println((2*r+1) * (2*r+1)-4 * remove); // can also use pick theorem here
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