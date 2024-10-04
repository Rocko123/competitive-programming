import java.io.*;
import java.util.*;
public class ccc_swipe {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) a[i] = readInt();
        for (int i = 0; i < n; i++) b[i] = readInt();

        ArrayList<int[]> l = new ArrayList<>(), r = new ArrayList<>();
        int i = 0, j = 0;
        for (; i < n && j < n;) {
            if (a[i] != b[j]) {
                while (i < n && a[i] != b[j]) i++;
                if (i == n) {
                    System.out.println("NO");
                    System.exit(0);
                }
                if (j < i) l.add(new int[] {j, i});
            } else {
                while (j < n && a[i] == b[j]) j++; // increments j when !=
                if (i < j-1) r.add(new int[] {i, j-1});
            }
        }
        System.out.println("YES");
        System.out.println(l.size() + r.size());
        for (int k = 0; k < l.size(); k++) System.out.println("L " + l.get(k)[0] + " " + l.get(k)[1]);
        for (int k = r.size()-1; k >= 0; k--) System.out.println("R " + r.get(k)[0] + " " + r.get(k)[1]);
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException{
        return Integer.parseInt(next());
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
