import java.util.*;
import java.io.*;
public class oths_chess_pieces {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        String s = readLine();
        if (s.equals("queen")) {
            System.out.println(9);
        } else if (s.equals("rook")) {
            System.out.println(5);
        } else if (s.equals("bishop") || s.equals("knight")) {
            System.out.println(3);
        } else if (s.equals("pawn")) {
            System.out.println(1);
        } else {
            System.out.println("priceless");
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