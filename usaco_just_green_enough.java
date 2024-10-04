import java.util.*;
import java.io.*;
public class usaco_just_green_enough {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // monostack way
        // do use the columns idea again
        // loop each cell from 1 to n
        // create an decreasing monostack from 1 to n and from n to 1
        // create two arrays l and r for the furthest brackets to a 100
        // to be conitued maybe
        int n = readInt();
        int[][] field = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                field[i][j] = readInt();
                if (field[i][j] < 100) {
                    field[i][j] = 0;
                } else if (field[i][j] == 100) {
                    field[i][j] = 1;
                } else {
                    field[i][j] = 2;
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            boolean[] good = new boolean[n+1];
            Arrays.fill(good, true);
            for (int j = i; j <= n; j++) {
                int[] bracketl = new int[n+1], bracketr = new int[n+1];
                Stack<Integer> l = new Stack<>(), r = new Stack<>();
                for (int k = 1; k <= n; k++) good[k] = good[k] & field[j][k] >= 1; 
                for (int k = 1; k <= n; k++) {
                    if(!good[k]) continue;
                    while (!r.isEmpty() && r.peek() >= field[j][k]) {

                    }
                    if (field[j][k] != 1) r.add(k);
                }
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