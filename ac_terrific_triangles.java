import java.util.*;
import java.io.*;
public class ac_terrific_triangles {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for (; t > 0; t--) {
            long[] s = new long[3];
            s[0] = readLong(); s[1] = readLong(); s[2] = readLong();
            Arrays.sort(s);
            long a = s[0]*s[0], b = s[1]*s[1], c = s[2]*s[2];
            if (a+b == c) {
                System.out.println("R");
            } else if (a+b < c) {
                System.out.println("O");
            } else {
                System.out.println("A");
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