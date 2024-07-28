import java.util.*;
import java.io.*;
public class scb_mutations_bf {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	String s = next();
        int n = readInt();
        int[] word = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            word[i] = (int) (s.charAt(i)-97);
        }

        for (int i = 0; i < n; i++) {
            int a = (int) readCharacter()-97;
            int b = (int) readCharacter()-97;
            for (int j = 0; j < s.length(); j++) {
                if (word[j] == a) {
                    word[j] = b;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append((char) (word[i] + 97));
        }
        String ans = sb.toString();
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