import java.util.*;
import java.io.*;
public class waiting_in_line {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> small = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        int n = readInt();
        Map<Integer, Integer> line = new HashMap<>();
        for (int i = 1; i <= n; i++) line.put(readInt(), i);
        
        int q = readInt();
        for (; q > 0; q--) {
            int x = readInt(), y = readInt();
            if (line.get(x) < line.get(y)) {
                System.out.println(x);
            } else {
                System.out.println(y);
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