import java.util.*;
import java.io.*;
public class wac_two_permutations {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        // look into birthday paradox

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        HashMap<Integer, Integer> posA = new HashMap<>(), posB = new HashMap<>();

        Collections.shuffle(list); // inputs we try
        for (int j = 0; j < Math.min(n, 10000); j++) {
            int i = list.get(j);
            System.out.println(i + " " + i);
            System.out.flush();

            int a = readInt(), b = readInt();
            if (a == b) { 
                break;
            } else if (posA.containsKey(b)) { // found b previously
                System.out.println(posA.get(b) + " " + i);
            } else if (posB.containsKey(a)) { // found a previously
                System.out.println(i + " " + posB.get(a));
            }
            posA.put(a, i); posB.put(b, i);
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