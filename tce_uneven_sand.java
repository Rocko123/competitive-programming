import java.util.*;
import java.io.*;
public class tce_uneven_sand {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        long low = 1, high = (int)2e9;
        while (low <= high) {
            long mid = (low+high)/2;
            System.out.println(mid);
            System.out.flush();
            String response = readLine();
            if (response.equals("FLOATS")) {
                high = mid-1;
            } else if (response.equals("SINKS")) {
                low = mid+1;
            } else {
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