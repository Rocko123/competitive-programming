import java.util.*;
import java.io.*;
public class usaco_cannonball {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), s = readInt();
        int[] target = new int[n+1], jump = new int[n+1];
        boolean[] visTarget = new boolean[n+1];
        int k = 1, targets = 0; 
        boolean forward = true;
        for (int i = 1; i <= n; i++) {
            int q = readInt(), v = readInt();
            if (q == 0) {
                jump[i] = v;
            } else {
                target[i] = v;
            }
        }
        while (s > 0 && s <= n) {
            // System.out.println("At: " + s);
            if (target[s] > 0 && !visTarget[s] && k >= target[s]) {
                targets++;
                visTarget[s] = true;
                if (forward) {
                    s += k;
                } else {
                    s -= k;
                }
            } else if (target[s] > 0) { 
                if (forward) {
                    s += k;
                } else {
                    s -= k;
                }
            } else {
                k += jump[s];
                if (forward) {
                    s -= k; forward = false;
                } else {
                    s += k; forward = true;
                }
            }
        }
        System.out.println(targets);
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
