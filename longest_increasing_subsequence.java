import java.util.*;
import java.io.*;
public class longest_increasing_subsequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int[] a = new int[n], dp = new int[n];
        int size = 0;
        for (int i = 0; i < n; i++) {
            a[i] = readInt();
            size = Math.max(size, a[i]);
        }
        int[] t = new int[size];
        
    } 
    static node tree (int start, int end, int[] arr) {
        if (start == end) {
            return new node(start, end, arr[start], null, null);
        } else {
            int mid = (start + end)/2;
            node l = tree(start, mid, arr), r = tree(mid+1, end, arr);
            return new node(start, end, l.sum + r.sum, l, r);
        }
    } 
    static class node {
        int start, end; long sum;
        node left, right;
        node (int start0, int end0, long sum0, node left0, node right0) {
            start = start0; end = end0; sum = sum0;
            left = left0; right = right0;
        }
    }
    static void update (node root, int index, int val) {
        if (root.start == root.end && root.start == index) {
            root.sum = val;
        } else {
            int mid = (root.start + root.end) / 2;
            if (index <= mid) {
                update(root.left, index, val);
            } else {
                update(root.right, index, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    static long querySum (node root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.sum;
        } else {
            int mid = (root.start + root.end)/2; 
            if (j <= mid) {
                return querySum(root.left, i, j);
            } else if (i > mid) {
                return querySum(root.right, i, j);
            } else {
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