import java.util.*;
import java.io.*;
public class scb_rock_paper_scissors {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt();
        int[] played = new int[3];

        for (int i = 0; i < n; i++) {
            String in = next();
            if (in.equals("rock")) {
                played[0]++;
            } else if (in.equals("paper")) {
                played[1]++;
            } else {
                played[2]++;
            }
        }
        System.out.println(played[0] > (played[2]) || (played[1] > (played[0])) || (played[2] > played[1]) ? "yes": "no");
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