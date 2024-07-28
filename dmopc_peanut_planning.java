import java.util.*;
import java.io.*;
public class dmopc_peanut_planning {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    public static void main(String[] args) throws IOException{
        n = readInt(); m = readInt();
        TreeSet<Integer> shops = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int stock = readInt();
            shops.add(stock);
            map.put(stock, map.getOrDefault(stock, 0) + 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();        
        ans.add(shops.first()); int prev = shops.first();

        if (map.get(prev) > 1) {
            map.put(prev, map.get(prev)-1);
        } else {
            map.remove(prev);
            shops.remove(prev);
        }
        for (int i = 2; i <= n; i++) {
            Integer a = shops.ceiling(m-prev);
            if (a == null) {
                System.out.print(-1);
                System.exit(0);
            } else {
                prev = a;
                if (map.get(prev) > 1) {
                    map.put(prev, map.get(prev)-1);
                } else {
                    map.remove(prev);
                    shops.remove(prev);
                }
                ans.add(a);
            }
        }
        // m = 8
        // 1 2 4 4 6 7 8
        // 1 7 2 6 4 4 8
        for (int i: ans) System.out.print(i + " ");
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