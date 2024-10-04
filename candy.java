import java.util.*;
import java.io.*;
public class candy {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // find the factors pairs of n
        long n = readLong();
        int sqrt = (int) Math.floor(Math.sqrt(n));
        ArrayList<Long> pair = new ArrayList<>();
        for (long i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                System.out.println(i);
                if (i == Math.sqrt(n)) continue;
                pair.add(n/i);
            }
        }
        Collections.sort(pair);
        for (int i = 0; i < pair.size(); i++) System.out.println(pair.get(i));
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