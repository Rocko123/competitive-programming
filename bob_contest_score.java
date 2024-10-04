import java.util.*;
import java.io.*;
public class bob_contest_score {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<Integer> scores = new HashSet<>();
    static int[] a;
    static int n;
    public static void main(String[] args) throws IOException{
        // brute force it, practice dfs
        // also can do quintiple nested loop 
        n = readInt();
        a = new int[n+1];
        for (int i = 1; i <= n; i++) a[i] = readInt();
        for (int i = 1; i <= n; i++) dfs(a[i], i);
        System.out.println(scores.size()+1);
    }
    static void dfs (int cur, int idx) {
        for (int i = idx+1; i <= n; i++) {
            dfs(cur + a[i], i);
        }
        scores.add(cur);
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