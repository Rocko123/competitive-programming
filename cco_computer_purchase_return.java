import java.util.*;
import java.io.*;
public class cco_computer_purchase_return {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int total = readInt(), n = readInt();
        List<int[]> [] items = new ArrayList[total+1];
        for (int i = 1; i <= total; i++) items[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int c = readInt(), v = readInt(), t = readInt();
            items[t].add(new int[] {c, v});
        }

        int b = readInt();
        int[] dp = new int[b+1];
        for (int i = 1; i <= total; i++) {
            for (int j = b; j >= 1; j--) {
                for (int k = 0; k < items[i].size(); k++) {
                    int cost = items[i].get(k)[0], value = items[i].get(k)[1];
                    if (j >= cost) {
                        dp[j] = Math.max(dp[j], dp[j-cost] + value);
                    }
                }
            }
        }
        System.out.println(dp[b] == 0 ? -1: dp[b]);
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