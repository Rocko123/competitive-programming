import java.util.*;
import java.io.*;
public class segment_tree_practice {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	// https://www.youtube.com/watch?v=rYBtViWXYeI
        // https://cp-algorithms.com/data_structures/segment_tree.html

        int n = readInt(), q = readInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = readInt();
        node root = tree(0, n-1, a);

        for (; q > 0; q--) {
            char op = readCharacter();
            if (op == 'S') {
                int l = readInt()-1, r = readInt()-1;
                System.out.println(querySum(root, l, r));
            } else {
                int i = readInt()-1, x = readInt();
                update(root, i, x);
            }
        }
    } 
    static node tree (int start, int end, int[] arr) {
        if (start == end) {
            return new node(start, end, arr[start], null, null);
            // created a leaf, this node covers the range from i to i
        } else {
            int mid = (start + end)/2;
            // create two child nodes L, R, who will cover the ranges from start to mid and mid to end
            node l = tree(start, mid, arr), r = tree(mid+1, end, arr);
            return new node(start, end, l.sum + r.sum, l, r); 
            // the current node will have child nodes that cover start to end (L and R) 
            // it has a value of their sums
        }
    } 
    static class node {
        // each node has a range from from i to j
        // two child nodes that will cover that range L and R
        int start, end; long sum;
        node left, right;
        node (int start0, int end0, long sum0, node left0, node right0) {
            start = start0; end = end0; sum = sum0;
            left = left0; right = right0;
        }
    }
    static void update (node root, int index, int val) {
        if (root.start == root.end && root.start == index) {
            root.sum = val; // we have reached a leaf
        } else {
            int mid = (root.start + root.end) / 2;
            if (index <= mid) {
                update(root.left, index, val);
            } else {
                update(root.right, index, val);
            }
            root.sum = root.left.sum + root.right.sum; // back population since we changed a value in tree
        }
    }
    static long querySum (node root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.sum; // if we come across a node that covers
            // the desired range, return its sum
        } else {
            int mid = (root.start + root.end)/2; 
            if (j <= mid) {
                // the whole range is in the left child
                return querySum(root.left, i, j);
            } else if (i > mid) {
                // the whole range is in the right child
                return querySum(root.right, i, j);
            } else {
                // partial range in the roots range, sum up the nodes that satisfy this range
                return querySum(root.left, i, mid) + querySum(root.right, mid+1, j);
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