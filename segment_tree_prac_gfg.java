import java.util.*;
import java.io.*;
public class segment_tree_prac_gfg {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[] seg, a;
    static int n;
    public static void main(String[] args) throws IOException{
        // https://www.geeksforgeeks.org/segment-tree-efficient-implementation/
        // this implementation faster?

        n = readInt(); int q = readInt();
        a = new long[n]; seg = new long[4*n];
        // tree is 1 indexed, array is 0 indexed
        for (int i = 0; i < n; i++) a[i] = readInt();
        tree();
        // System.out.println(Arrays.toString(seg));
        for (; q > 0; q--) {
            char op = readCharacter();
            if (op == 'S') {
                // r + 1
                int l = readInt()-1, r = readInt();
                System.out.println(query(l, r));
            } else {
                int idx = readInt()-1;
                long val = readLong();
                update(idx, val);
            }
        }
    }
    static void tree () {
        for (int i = 0; i < n; i++) {
            seg[n+i] = a[i];
        }
        for (int i = n-1; i > 0; --i) {
            seg[i] = seg[i << 1] + seg[i << 1 | 1];
            // sum left child 2i and right child 2i+1
        }
    }
    static void update (int idx, long val) {
        idx += n;
        seg[idx] = val;
        for (int i = idx; i > 1; i >>= 1) {
            seg[i >> 1] = seg[i] + seg[i^1];
            // ammend the tree by summing 2i and 2i+1
        }
    }
    static long query (int l, int r) {
        long ans = 0;
        // stuff happens here
        for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) > 0) {
                ans += seg[l++];
            }
            if ((r & 1) > 0) {
                ans += seg[--r];
            }
        }
        return ans;
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