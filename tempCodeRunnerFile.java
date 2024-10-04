import java.util.*;
import java.io.*;
public class oths_ghoul_investigators {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int k = readInt(), n = readInt();
        boolean bad = false;
        for (; n > 0; n--) {
            int speed = readInt();
            if (speed >= k) {
                bad = true;
            }
        }
        System.out.println(bad ? "fight": "runaway");
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