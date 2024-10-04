import java.util.*;
import java.io.*;
public class oths_magic_barrier {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt(), q = readInt();
        HashMap<Integer, pair> map = new HashMap<>();
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int a = readInt();
                map.put(a, new pair(j, i));
            }
        }
        for (; q > 0; q--) {
            int k = readInt(), r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();
            if (!map.containsKey(k)) {System.out.println("no"); continue;}
            int kx = map.get(k).x, ky = map.get(k).y;
            if (kx >= c1 && kx <= c2 && ky >= r1 && ky <= r2) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    } 
    static class pair {
        int x, y;
        pair (int x0, int y0) {
            x = x0; y = y0;
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