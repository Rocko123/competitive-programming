import java.util.*;
import java.io.*;
public class cco_pizza_party {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] stacks;
    static int k = 1;
    public static void main(String[] args) throws IOException{
        // idea: solve in reverse, put the last persons pizza at the bottom
        // problem: to create a new stack or add to the current stack
        // a[i] == b[i] good
        // if a[i] != b[i] pizza must go on an existing stack or as its own stack
        // when the i > j for b[i] == a[j], a[j] has been placed earlier, look for it in DS
        // only increase the stacks when pizza is in DS but idx < min of all stacks

        int n = readInt();
        int[] a = new int[n], b = new int[n], c = new int[n], d = new int[n], freq = new int[(int)1e6+1];
        stacks = new int[n+1];
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = readInt();
            map.put(a[i], new LinkedList<>());
            freq[a[i]]++;
        }
        for (int i = n-1; i >= 0; i--) {
            b[i] = readInt();
            freq[b[i]]--;
        }
        for (int i = 0; i <= (int) 1e6; i++) {
            if (freq[i] != 0) {
                System.out.println(-1);
                System.exit(0);
            }
        }
        // a stack for a pizza that has already been "explored"
        // is the largest smaller than the cur idx or create
        // a new stack.
        // reverse order -> binary search
        int pizza = 0;
        for (int i = 0; i < n; i++) {
            // should not move to next pizza if nothing is done with cur pizza
            if (pizza < n && a[pizza] == b[i]) {
                c[pizza] = d[n-i-1] = 1; stacks[1] = pizza;
                pizza++;
            } else {
                if (!map.get(b[i]).isEmpty()) {
                    int idx = map.get(b[i]).poll(), stk = binarySearch(idx); 
                    c[idx] = d[n-i-1] = stk; stacks[stk] = idx;
                    continue; 
                } else {
                    while (pizza < n) {
                        if (a[pizza] == b[i]) {
                            c[pizza] = d[n-i-1] = 1; stacks[1] = pizza;
                            pizza++;
                            break;
                        } else {
                            map.get(a[pizza]).add(pizza);
                            pizza++;
                        }
                    }
                }
            } 
        }

        System.out.println(k);
        for (int i = 0; i < n; i++) System.out.print(c[i] + " ");
        System.out.println();
        for (int i = 0; i < n; i++) System.out.print(d[i] + " ");
        System.out.println();
    }
    static int binarySearch(int idx) {
        // stacks are in reverse order
        int L = 1, R = k, good = -1;
        while (L <= R) {
            int M = (L+R)/2;
            if (stacks[M] < idx) {
                good = M;
                R = M-1;
            } else {
                L = M+1;
            }
        }
        if (good == -1) good = ++k;
        return good;
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