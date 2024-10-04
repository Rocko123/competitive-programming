import java.util.*;
import java.io.*;
public class battleships {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // 2d psa will MLE, instead we can try to count
        // how many grids each ship will contribute to
        // then sum them all up and divide by the number of grids

        int m = readInt(), n = readInt(), s = readInt();
        long ans = 0;
        for (int i = 1; i <= m; i++) {
            String S = readLine();
            for (int j = 1; j <= n; j++) {
                if (S.charAt(j-1) == 'X') {
                    int l = Math.max(1, j-s+1), r = Math.min(n, j+s-1), len = r-l+1;
                    int c = Math.max(1, i-s+1), f = Math.min(m, i+s-1), ht = f-c+1;
                    if (len >= s && ht >= s) {
                        int total = (len-s+1) * (ht-s+1);
                        ans += total;
                        // System.out.println(len + " " + ht + " " + total);
                    }
                }
            }
        }
        long grids = (m-s+1) * (n-s+1);
        System.out.println((double) ans/grids);

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