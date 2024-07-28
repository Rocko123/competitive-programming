import java.util.*;
import java.io.*;
public class usaco_balancing_bacteria {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // 2nd order difference array
        // try to make the furthest left non zero cell zero
        // first dif is the difference in bacteria levels
        // second dif is the ans because it is the dif of the dif in bacteria levels
        // after doing the sprays required to get i-1 to 0, 
        // we still need to perform dif2[i] sprays to get i to 0
        int n = readInt();
        long[] grass = new long[n+1], dif1 = new long[n+1];
        for (int i = 1; i <= n; i++) grass[i] = readLong();
        for (int i = 1; i <= n; i++) dif1[i] = grass[i] - grass[i-1];
        long ans = 0;
        for (int i = 1; i <= n; i++) ans += Math.abs(dif1[i] - dif1[i-1]);
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
