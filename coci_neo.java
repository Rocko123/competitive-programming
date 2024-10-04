import java.util.*;
import java.io.*;
public class coci_neo {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // rearrange equation to col1 <= col2
        // if its working with above row it is working with all above row
        // problem: too long to get clear idea + implement
        // trying to monostack the height two columns
        // made calculating the heights difficult
        // preprocess the good 2x2 then run monostack on heights

        int r = readInt(), s = readInt();
        int[][] g = new int[r+1][s+1];
    
        int ans = 0;
        int[] h = new int[s+1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= s; j++) {
                g[i][j] = readInt();
                if (j == 1) continue;
                if (g[i-1][j-1] - g[i][j-1] <= g[i-1][j] - g[i][j]) {
                    h[j]++;
                } else {
                    h[j] = 0;
                }
            }
            if (i == 1) continue;
            Stack<Integer> S = new Stack<>();
            for (int j = 2; j <= s; j++) {
                while (!S.isEmpty() && h[S.peek()] >= h[j]) {
                    int ht = S.pop();
                    int L = S.isEmpty() ? 1: S.peek();
                    ans = Math.max(ans, (j-L) * (h[ht]+1));
                }
                S.add(j);
            }
            while (!S.isEmpty()) {
                int ht = S.pop();
                int L = S.isEmpty() ? 1: S.peek();
                ans = Math.max(ans, (s-L+1) * (h[ht]+1));
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