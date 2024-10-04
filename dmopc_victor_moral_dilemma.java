import java.util.*;
import java.io.*;
public class dmopc_victor_moral_dilemma {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), d = readInt();
        int[] t = new int[n+1], psa = new int[n+1];
        for (int i = 1; i <= n; i++) {
            t[i] = readInt();
            psa[i] = psa[i-1] + t[i];
        }
        int l = 1, r = n;
        for (int i = 0; i < d; i++) {
            int ni = readInt();
            int f = psa[l+ni-1]-psa[l-1];
            int s = psa[r]-psa[l+ni-1];
            if (f >= s) {
                System.out.println(f);
                l += ni;
            } else {
                System.out.println(s);
                r = l+ni-1;
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