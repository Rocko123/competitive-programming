import java.util.*;
import java.io.*;
public class multiple_of_k {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), k = readInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) a[i] = (a[i-1] + readInt()) % k;
        // idea: build a psa and mod everything by k
        // put the previous values in a hashmap, if we can remove
        // the remainder, the subarray is possible
        // System.out.println(Arrays.toString(a));
        int ans = -1;
        HashMap<Integer, Integer> modded = new HashMap<>();
        modded.put(0, 0);
        for (int i = 1; i <= n; i++) {
            if (!modded.containsKey(a[i])) {
                modded.put(a[i], i);
            } else {
                ans = Math.max(ans, i - modded.get(a[i]));
            }
        }
        System.out.println(ans);
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