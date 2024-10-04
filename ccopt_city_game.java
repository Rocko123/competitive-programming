import java.util.*;
import java.io.*;
public class ccopt_city_game {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // maybe some idea similar to just green enough
        // maintain the highest row above
        // i think idea is fully correct, just needs stack optimization
        // another way is to consider the one just smaller than you +1 your left bound
        // and the current one >= you -1 your right bound.  
        int k = readInt();
        for (; k > 0; k--) {
            int m = readInt(), n = readInt();
            int ans = 0;
            int[] heights = new int[n+2];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (readCharacter() == 'R') {
                        heights[j] = 0;
                    } else {
                        heights[j]++;
                    }
                }
                // needs stack optimization
                int[] s = new int[n+1];
                int top = -1;
                for (int j = 1; j <= n+1; j++) {
                    while (top >= 0 && heights[s[top]] > heights[j]) {
                        int cur = s[top];
                        ans = Math.max(ans, (j-cur) * heights[cur]);
                        top--;
                    }
                    top++;
                    s[top] = j;
                }
            }
            System.out.println(ans*3);
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