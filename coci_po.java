import java.util.*;
import java.io.*;
public class coci_po {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // idea: probably monostack
        // if its greater than the current one it must be a new update
        // if its less than the current one it is the end of an update
        // create an increasing monostack
        int n = readInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) a[i] = readInt();
        // 2 2 1 2
        // out: 3

        // dont need to maintain min, if the stack is empty it means it is the new min
        int ans = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (!s.isEmpty() && s.peek() > a[i]) {
                s.pop();
            }
            // wa
            // 2 0 2
            if (a[i] != 0 && (s.isEmpty() || s.peek() < a[i])) {
                s.add(a[i]);
                ans++;
            }
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