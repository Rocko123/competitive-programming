import java.util.*;
import java.io.*;
public class dmopc_grade11_math {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // use a treemap with all the powers of 2
        // from the ranges L to R, find the first power of 2 still in the treemap
        // loop from that value to R and add all those values
        
        int n = readInt(), m = readInt();

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, 1<<(n-i));
        }

        long ans = 0;
        String s = readLine();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ans += map.get(i+1) % ((int)1e9+7);
                map.remove(i+1);
            }
        }
        // System.out.println(ans);

        for (int i = 0; i < m; i++) {
            int L = readInt(), R = readInt();
            Integer start = map.ceilingKey(L);
            // System.out.println("Key " + start);
            if (start != null) {
                for (int j = start; j <= R; j++) {
                    if (map.containsKey(j)) {
                        ans += map.get(j) % ((int)1e9+7);
                        map.remove(j);
                    }
                }
            }
            System.out.println(ans);
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