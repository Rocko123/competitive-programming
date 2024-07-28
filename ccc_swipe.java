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

        ArrayList<int[]> left = new ArrayList<>(), right = new ArrayList<>(), seg = new ArrayList<>();

        // group consecutive segments in B together
        int L = 0, R = 0;
        for (int i = 0; i < n; i++) {
            if (b[L] != b[R]) {
                seg.add(new int[] {L, R-1});
                L = R;
            }
            if (i == n-1) {
                seg.add(new int[] {L, i});
                L = R;
            }
            R++;
        }

        // find a target in A
        int index = 0;
        for (int i = 0; i < seg.size(); i++) {
            boolean bad = true;
            for (int j = index; j < n; j++) {
                if (a[j] == b[seg.get(i)[0]]) {
                    if (j > seg.get(i)[0]) { // perform left swipe from j
                        left.add(new int[] {seg.get(i)[0], j});
                    }
                    if (j < seg.get(i)[1]) { // perform right swipe from j
                        right.add(new int[] {j, seg.get(i)[1]});
                    }
                    index = j;
                    bad = false;
                    break;
                }
            }
            if (bad) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        //printArr(left);
        //printArr(right);
        System.out.println("YES");
        System.out.println(left.size() + right.size());
        for (int i = 0; i < left.size(); i++) {
            System.out.println("L " + left.get(i)[0] + " " + left.get(i)[1]);
        }
        for (int i = right.size()-1; i >= 0; i--) {
            System.out.println("R " + right.get(i)[0] + " " + right.get(i)[1]);
        }
    }
    static void printArr (ArrayList<int[]> arr) {
        for (int[] i: arr) {
            System.out.println(Arrays.toString(i));
        }
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
