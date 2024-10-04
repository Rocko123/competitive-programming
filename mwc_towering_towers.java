import java.util.*;
import java.io.*;
public class mwc_towering_towers {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        Stack<tower> s = new Stack<>();
        int[] towers = new int[n+1], ans = new int[n+1];
        for (int i = 1; i <= n; i++) towers[i] = readInt();

        // decreasing monotonic stack

        // problem: missing deleted sections
        s.add(new tower(towers[1], 1));
        for (int i = 2; i <= n; i++) {
            while (!s.isEmpty() && s.peek().h <= towers[i]) {
                s.pop();
            }
            ans[i] = s.isEmpty() ? i-1: i-s.peek().i; 
            // highest tower so far always stays
            // taller than it, taller than all
            s.add(new tower(towers[i], i));
        }
        for (int i = 1; i < n; i++) System.out.print(ans[i] + " ");
        System.out.println(ans[n]);
    }
    static class tower {
        int h, i;
        tower (int h0, int i0) {
            h = h0; i = i0;
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