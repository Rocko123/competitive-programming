import java.util.*;
import java.io.*;
public class egoi_inflation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt();
        
        HashMap<Long, Integer> setP = new HashMap<>();
        long sum = 0, delta = 0;
        for (int i = 1; i <= n; i++) {
            long price = readLong();
            if (!setP.containsKey(price)) {
                setP.put(price, 1);
            } else {
                setP.put(price, setP.get(price) + 1);
            }
            sum += price;
        }

        int q = readInt();
        for (int i = 0; i < q; i++) {
            String com = next();
            if (com.equals("INFLATION")) {
                long x = readLong();
                delta += x; 
            } else {
                long x = readLong(), y = readLong();
                x -= delta; y -= delta; // this gives the correct prices since all values were incremented
                // by delta but we never changed their values in the map
                if (x != y && setP.containsKey(x)) {
                    sum += (y - x) * setP.get(x);
                    setP.put(y, setP.getOrDefault(y, 0) + setP.get(x));
                    setP.remove(x);
                }
            }
            System.out.println(sum + delta * n);
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