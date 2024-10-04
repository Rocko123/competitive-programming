import java.util.*;
import java.io.*;
public class cco_snowflakes {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        // could loop over each index of each snowflake both ways
        Set<ArrayList<Integer>> s = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 1; j <= 6; j++) a.add(readInt());
            if (i != 1) {
                for (int j = 0; j < 6; j++) {
                    ArrayList<Integer> b = new ArrayList<>();
                    ArrayList<Integer> c = new ArrayList<>();
                    for (int k = j; k < j+6; k++) {
                        b.add(a.get(k%6));
                    }
                    for (int k = j; k > j-6; k--) {
                        c.add(a.get((k+6)%6));
                    }
                    // System.out.println(b);
                    // System.out.println(c);
                    if (s.contains(b) || s.contains(c)) {
                        System.out.println("Twin snowflakes found.");
                        System.exit(0);
                    }
                }
            }
            s.add(a);
        }
        System.out.println("No two snowflakes are alike.");
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