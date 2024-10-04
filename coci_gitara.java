import java.util.*;
import java.io.*;
public class coci_gitara {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // montonic stack

        int n = readInt(), p = readInt(); // need P?
        Stack<Integer>[] str = new Stack[7];
        for (int i = 1; i <= 6; i++) str[i] = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int s = readInt(), f = readInt(), moves = 0;
            while (!str[s].isEmpty() && str[s].peek() > f) {
                moves++;
                str[s].pop();
            }
            if (str[s].isEmpty() || str[s].peek() < f) {
                str[s].add(f);
                moves++;
            }
            ans += moves;
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