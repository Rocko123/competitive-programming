import java.util.*;
import java.io.*;
public class segment_tree_practice1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[] seg, a;
    public static void main(String[] args) throws IOException{
    	// https://www.youtube.com/watch?v=ZBHKZF5w4YU&t=13s
        // https://cp-algorithms.com/data_structures/segment_tree.html

        // 0 index
        // parent (i-1)/2
        // left child 2i+1, right child 2i+2
        // 1 index
        // parent i/2
        // left child 2i, right child 2i+1
        
        int n = readInt(), q = readInt();
        a = new long[n+1]; seg = new long[4*n];
        // tree is 1 indexed, array is 0 indexed
        for (int i = 0; i < n; i++) a[i] = readInt();
        tree(0, n-1, 1);
        //System.out.println(Arrays.toString(seg));
        for (; q > 0; q--) {
            char op = readCharacter();
            if (op == 'S') {
                int l = readInt()-1, r = readInt()-1;
                System.out.println(query(1, 0, n-1, l, r));
            } else {
                int idx = readInt()-1;
                long val = readLong();
                update(1, 0, n-1, idx, val);
            }
        }
    } 
    static void tree (int lo, int hi, int pos) {
        if (lo == hi) { // leaf node
            seg[pos] = a[lo];
            return;
        }
        int mid = (lo+hi)/2;
        tree(lo, mid, 2*pos); // left branch range from low to mid
        tree(mid+1, hi, 2*pos+1); // right branch range from mid+1 to hi
        seg[pos] = seg[2*pos] + seg[2*pos+1]; // set to sum of youre already calculated left and right child
    }
    static long query (int pos, int lo, int hi, int qlo, int qhi) {
        if (qlo > qhi) { // no overlap
            return 0;
        }
        if (lo == qlo && hi == qhi) {
            return seg[pos];
        }
        int mid  = (lo+hi)/2;
        // query the left child that covers lo to mid, we want the segement from qlo to min(mid, qhi)
        // query the right child that covers mid+1 to high, we want the segment from max(qlo, mid+1) to qhi
        return query(pos*2, lo, mid, qlo, Math.min(mid, qhi)) + query(pos*2+1, mid+1, hi, Math.max(qlo, mid+1), qhi);
    }
    static void update (int pos, int lo, int hi, int idx, long val) {
        if (lo == hi) { // found leaf
            seg[pos] = val;
        } else {
            int mid = (lo+hi)/2;
            if (idx <= mid) {
                update(pos*2, lo, mid, idx, val); // search left child
            } else {
                update(pos*2+1, mid+1, hi, idx, val); // search right child
            }
            seg[pos] = seg[pos*2] + seg[pos*2+1]; // ammend tree sum
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