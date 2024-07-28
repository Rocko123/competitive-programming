import java.util.*;
import java.io.*;
public class dmopc_valid_strings {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt();
        for (; n > 0; n--) {
            boolean bad = false;
            int brackets1 = 0;
            int brackets2 = 0;
            String s = next();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    brackets1++;
                } else if (s.charAt(i) == ')') {
                    brackets2++;
                } 
                if (brackets1 < brackets2) {
                    bad = true;
                    break;
                }
            }
            System.out.println(bad || brackets1 != brackets2 ? "NO": "YES");
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