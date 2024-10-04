import java.util.*;
import java.io.*;
public class coci_majstor {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int r = readInt();
        char[] sven = readLine().toCharArray();
        int[][] game = new int[r][3]; // R P S
        

        int actual = 0, optimal = 0, n = readInt();

        for (; n > 0; n--) {
            String round = readLine();
            for (int i = 0; i < r; i++) {
                char cur = round.charAt(i);
                if (cur == 'R') {
                    game[i][0]++;
                    if (sven[i] == 'P') {
                        actual += 2;
                    } else if (sven[i] == 'R') {
                        actual++;
                    }
                } else if (cur == 'P') {
                    game[i][1]++;
                    if (sven[i] == 'S') {
                        actual += 2;
                    } else if (sven[i] == 'P') {
                        actual++;
                    }
                } else {
                    game[i][2]++;
                    if (sven[i] == 'R') {
                        actual += 2;
                    } else if (sven[i] == 'S') {
                        actual++;
                    }
                }
            }
        }
        System.out.println(actual);
        for (int i = 0; i < r; i++) {
            int p1 = game[i][0] * 2 + game[i][1];
            int p2 = game[i][1] * 2 + game[i][2];
            int p3 = game[i][2] * 2 + game[i][0];
            optimal += Math.max(p1, Math.max(p2, p3));
        }
        System.out.println(optimal);
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