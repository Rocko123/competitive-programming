import java.util.*;
import java.io.*;
public class dmopc_weak_data {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        long k = readLong();

        // look more closely at the "original" problem
        // in the psa of an array there are even(incl. 0)C2 + oddC2 even subarrays
        
        if (k == 0) {
            System.out.println(1);
            System.out.println(1);
            System.exit(0);
        }
        int even = 0, odd = 0;
        Map<Long, Integer> calc = new HashMap<>(); // nc2, n
        for (int i = 2; i <= (int) 1e6+1; i++) {
            long choose = (long) i*(i-1)/2;
            if (calc.containsKey(k-choose)) {
                if (i + calc.get(k-choose) <= (int) 1e6+1) {
                    even = i;
                    odd = calc.get(k-choose);
                    break;
                }
            } else if (choose == k) {
                even = i;
                break;
            }
            calc.put(choose, i);
        }
        if (even == 0) {
            System.out.println(-1);
            System.exit(0);
        }
        System.out.println(even+odd-1);
        int[] psa = new int[even+odd], ans = new int[even+odd];
        for (int i = even; i <= even+odd-1; i++) psa[i] = 1;
        // System.out.println(Arrays.toString(ans));
        for (int i = 1; i < even+odd-1; i++) {
            ans[i] = psa[i] - psa[i-1];
            System.out.print(ans[i] + " ");
        }
        System.out.println(psa[even+odd-1]-psa[even+odd-2]);
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