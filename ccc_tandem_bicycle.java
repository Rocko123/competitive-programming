import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class ccc_tandem_bicycle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int type = readInt();
        boolean findMax = type == 1 ? false: true;
        int n = readInt();
        int[] dmoj = new int[n], wcipeg = new int[n];
        for (int i = 0; i < n; i++) dmoj[i] = readInt();
        for (int i = 0; i < n; i++) wcipeg[i] = readInt();
        
        Arrays.sort(dmoj); Arrays.sort(wcipeg);
        if (findMax) reverse(wcipeg);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(dmoj[i], wcipeg[i]);
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