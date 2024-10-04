import java.util.*;
import java.io.*;
public class wc_big_book_recipes {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<String, Integer> idx;
    static ArrayList<pair> adj[];
    static double[] ans;
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for (; t > 0; t--) {
            int n = readInt();
            ArrayList<String> in = new ArrayList<>(); // input order
            idx = new HashMap<>();
            adj = new ArrayList[n];
            ans = new double[n];

            for (int i = 0; i < n; i++) {
                String key = readLine();
                in.add(key); idx.put(key, i);
            }
            for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (in.get(i).charAt(0) > 90) continue;
                int k = readInt();
                for (; k > 0; k--) {
                    double cnt = readDouble();
                    StringBuilder sb = new StringBuilder();
                    while (st.hasMoreTokens()) {sb.append(next());sb.append(" ");}
                    String key = sb.toString().trim();
                    adj[i].add(new pair(cnt, key)); // ingredients
                }
            }
            String key = readLine();
            fun(key, adj[idx.get(key)], 1);
            for (int i = 0; i < n; i++) {
                if (ans[i] != 0) System.out.println(ans[i] + " " + in.get(i));
            }
        }
    }
    static void fun (String cur, ArrayList<pair> ingredient, double amongus) {
        for (pair i: ingredient) {
            if (i.b.charAt(0) > 90) ans[idx.get(i.b)] += i.cnt*amongus;
            else fun(i.b, adj[idx.get(i.b)], amongus*i.cnt);
        }
    }
    static class pair {
        double cnt;
        String b;
        pair (double cnt0, String b0) {
            cnt = cnt0;
            b = b0;
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