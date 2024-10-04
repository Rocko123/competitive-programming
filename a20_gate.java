import java.util.*;
import java.io.*;
public class a20_gate {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // 2^20 = 1MB
        int n = readInt();
        for (; n > 0; n--) { 
            // read problem better
            /*
            check k-th bit:   x >> k & 1    or    x &  1<< k
            set k-th bit:   x | 1 << k
            clear k-th bit:   x  & ~(1<<k) 
            flip k-th bit:   x ^ (1<<k)
             */
            String s = readLine();
            Long pull_high = Long.parseLong(s, 16);
            Long pull_low = (pull_high & (1<<20)) > 0 ? pull_high ^ (1 << 20): pull_high;
            String ans = "", tohex = Long.toHexString(pull_low);
            for (int i = 0; i < 8-tohex.length(); i++) ans += "0";
            for (int i = 0; i < tohex.length(); i++) ans += Character.toUpperCase(tohex.charAt(i));
            if (s.equals(ans)) System.out.println(s);
            else System.out.println(ans + " " + s);
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