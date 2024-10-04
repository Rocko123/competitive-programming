import java.util.*;
import java.io.*;
public class coci_diferencija {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> small = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        // idea was wrong, monotonic stack problem
        // find the number of subarrays that use a[i] as min and as max
        // use bracket way L * R using mono stack

        int n = readInt();
        int[] a = new int[n+2];
        for (int i = 1; i <= n; i++) a[i] = readInt();

        Stack<Integer> m = new Stack<>(), M = new Stack<>();
        long ans = 0;
        a[n+1] = (int) 1e9; // stop the last element
        for (int i = 1; i <= n+1; i++) {
            while (!M.isEmpty() && a[M.peek()] <= a[i]) {
                // current element is larger than the previous, previous can be max up to here
                int idx = M.pop();
                int r = i-idx;
                int l = idx-(M.isEmpty() ? 0: M.peek());
                // included a[i] as a subarray but is removed in next loop
                ans += (long) l * r * a[idx];
            }
            M.add(i);
        }
        // System.out.println(ans);
        a[n+1] = -(int) 1e9;
        for (int i = 1; i <= n+1; i++) {
            while (!m.isEmpty() && a[m.peek()] >= a[i]) {
                // current element is smaller than the previous, previous can be min up to here
                int idx = m.pop();
                int r = i-idx;
                int l = idx-(m.isEmpty() ? 0: m.peek());
                ans -= (long) l * r * a[idx];
            }
            m.add(i);
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