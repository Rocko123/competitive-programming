import java.util.*;
import java.io.*;
public class dwite_floppy_disk {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // learn about knapsack problem
        // similar to CCC Golf
        for (int i = 0; i < 5; i++) {
            int n = readInt();
            boolean[] good = new boolean[1441];
            good[0] = true;
            int ans = 1440;
            for (; n > 0; n--) {
                int s = readInt();
                for (int j = 1440; j >= s; j--) {
                    // order doesnt matter, it is guaranteed that we can have s
                    // then the current s + any previous s will be good
                    if (good[j - s]) {
                        good[j] = true;
                        ans = Math.min(ans, 1440-j);
                    }
                }
            }
            System.out.println(ans);
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
