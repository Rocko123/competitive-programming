import java.util.*;
import java.io.*;
public class wc_keeping_score {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int l = readInt(), g = readInt();

        int[] legolas = new int[l], gimli = new int[g];
        for (int i = 0; i < l; i++) legolas[i] = readInt();
        for (int i = 0; i < g; i++) gimli[i] = readInt();

        Arrays.sort(legolas); Arrays.sort(gimli);
        int j = l-1;
        int ans = -1;
        for (int i = g-1; i > 0; i--) {
            int scoreG = 0, scoreL = 0;
            if (i == g-1 || gimli[i] != gimli[i-1]) {
                scoreG = g - i; // all up to i are not counted
                for (;j > 0 && legolas[j] >= gimli[i]; j--) {} // find next j < i
                scoreL = l - (j+1); // all up to j and including are not counted
                if (scoreG > scoreL) {
                    ans = gimli[i];
                    break;
                }
            }
        }
        System.out.println(ans);
    }
    static void reverse (int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
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