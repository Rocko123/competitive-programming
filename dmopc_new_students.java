import java.util.*;
import java.io.*;
public class dmopc_new_students {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int I = readInt(), sum = 0;
        for (int i = 1; i <= I; i++) sum += readInt();

        int S = readInt();
        for (int i = 1; i <= S; i++) {
            sum += readInt();
            System.out.println(Math.round((sum/(double)(I+i)) * 1000)/1000.0);
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