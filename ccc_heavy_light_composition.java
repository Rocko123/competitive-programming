import java.util.*;
import java.io.*;
public class ccc_heavy_light_composition {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int t = readInt(), n = readInt();
        for (; t > 0; t--) {
            char[] s = readLine().toCharArray();
            int[] freq = new int[26];
            for (int i = 0; i < n; i++) freq[(int)(s[i]-'a')]++;
            // System.out.println(Arrays.toString(freq));
            boolean good = true;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (freq[(int)(s[i]-'a')] < 2) {good = false; break;}
                } else if (i % 2 != 0) {
                    if (freq[(int)(s[i]-'a')] != 1) {good = false; break;}
                }
            }
            if (good) {
                System.out.println('T');
                continue;
            } else {
                good = true;
            }
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (freq[(int)(s[i]-'a')] != 1) {good = false; break;}
                } else if (i % 2 != 0) {
                    if (freq[(int)(s[i]-'a')] < 2) {good = false; break;}
                }
            }
            if (good)  {
                System.out.println('T');
            } else {
                System.out.println('F');
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