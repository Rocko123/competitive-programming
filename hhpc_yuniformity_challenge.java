import java.util.*;
import java.io.*;
public class hhpc_yuniformity_challenge {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt(), q = readInt();
        int[] arr = new int[n+1];
        int[] adj = new int[n+1];
        int[] zero = new int[n+1];
        int[] last = new int[n+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        // want all consecutive or 0
        // or be able to make a 0
        for (int i = 1; i <= n; i++) {
            arr[i] = readInt();
            if (arr[i] == arr[i-1]) {
                adj[i] = adj[i-1] + 1;
            } else {
                adj[i] = adj[i-1];
            }
            if (arr[i] == 0) {
                zero[i] = zero[i-1] + 1;
            } else {
                zero[i] = zero[i-1];
            }
            map.put(arr[i], i);
            if (map.containsKey(-arr[i])) {
                last[i] = map.get(-arr[i]);
                // when we assign values to last[i]
                // index will alway be < i
            }
        }

        for (int i = 1; i <= n; i++) {
            last[i] = Math.max(last[i], last[i-1]); 
            // stores closest left index that is the opposite of a[i]
            // if there is no opposite, we just take the last opposite
            // of some random number, because it is out of range
            // we check last[r] it will then be guaranteed to be
            // less than L basically meaning no opposite exists
        }

        // all the numbers are already the same
        // or there exists a 0 
        // or 2 elements x and -x
        // all queries O(1)
        for (; q > 0; q--) {
            int l = readInt(), r = readInt();
            if (adj[r] - adj[l] == r-l) {
                System.out.println("YES");
                continue;
            }
            if (zero[r]-zero[l-1] > 0) {
                System.out.println("YES");
                continue;
            }
            if (last[r] >= l) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
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
