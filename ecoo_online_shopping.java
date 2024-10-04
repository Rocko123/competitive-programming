import java.util.*;
import java.io.*;
public class ecoo_online_shopping {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for (; t > 0; t--) {
            HashMap<String, ArrayList<item>> map = new HashMap<>();
            for (int n = readInt(); n > 0; n--) {
                for (int m = readInt(); m > 0; m--) {
                    String s = next();
                    int p = readInt(), q = readInt();
                    if (!map.containsKey(s)) map.put(s, new ArrayList<>());
                    map.get(s).add(new item(p, q));
                }
            }
            for (String i: map.keySet()) {
                Collections.sort(map.get(i));
            }
            int total = 0;
            for (int k = readInt(); k > 0; k--) {
                String s = next();
                int d = readInt();
                while (d > 0) {
                    for (item i: map.get(s)) {
                        if (i.q >= d) {
                            total += i.p * d;
                            d = 0;
                            break;
                        } else {
                            total += i.p * i.q;
                            d -= i.q;
                        }
                    }
                }
            }
            System.out.println(total);
        }
    }
    static class item implements Comparable<item> {
        int p, q;
        item (int p0, int q0) {
            p = p0; q = q0;
        }
        public int compareTo (item x) {
            return Integer.compare(p, x.p);
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