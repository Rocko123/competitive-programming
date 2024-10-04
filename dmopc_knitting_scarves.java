import java.util.*;
import java.io.*;
public class dmopc_knitting_scarves {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), q = readInt();

        ArrayList<node> ll = new ArrayList<>();
        for (int i = 1; i <= n; i++) ll.add(new node(i));
        for (int i = 0; i < n; i++) {
            if (i < n-1) ll.get(i).nxt = ll.get(i+1);
            if (i > 0) ll.get(i).prev = ll.get(i-1);
        }

        int head = 0;
        for (; q > 0; q--) {
            int l = readInt()-1, r = readInt()-1, k = readInt()-1;
            if (k != -1) {
                node temp = ll.get(k).nxt;
                ll.get(k).nxt = ll.get(l);
                ll.get(r).nxt = temp;
                if (ll.get(l).prev != null) ll.get(l).prev = ll.get(r).nxt;
            } else {
                ll.get(r).nxt = ll.get(head);
                ll.get(head).prev = ll.get(r);
                if (ll.get(l).prev != null) {
                    ll.get(l).prev.nxt = null;
                    ll.get(l).prev = null;
                }
                head = l;
            }
        }
        /*
        cur = ll.get(head);
        while (cur.nxt != null) {
            System.out.print(cur.val + " ");
            cur = cur.nxt;
        }
        System.out.println();
        */
    } 
    static class node {
        int val;
        node nxt = null, prev = null;
        node (int val0) {
            val = val0;
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