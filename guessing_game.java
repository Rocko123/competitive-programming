import java.util.*;
import java.io.*;
public class guessing_game {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), x = readInt()+1, y = readInt()-1;
        int ans = 0;
        while (x <= y) {
            int mid = (x+y)/2;
            ans++;
            if (mid < n) {
                x = mid + 1;
            } else if (mid > n) {
                y = mid-1;
            } else {
                System.out.println(ans);
                break;
            }
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