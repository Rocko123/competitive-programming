import java.util.*;
import java.io.*;
public class toospooky4me {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), l = readInt(), S = readInt();
        // dsa not working
        /*
        2 100 1
        20 59 1
        69 70 1
        WA: 49
         */
        List<pair> houses = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int a = readInt(), b = readInt(), s = readInt();
            houses.add(new pair(a, s)); houses.add(new pair(b+1, -s));
            // always stop it at 1 more, then when you subtract the houses is correct
        }
        Collections.sort(houses);
        int sum = 0, spook = 0;
        for (int i = 0; i < houses.size()-1; i++) {
            sum += houses.get(i).val;
            if (sum >= S) spook += houses.get(i+1).pos - houses.get(i).pos;
        }
        System.out.println(l-spook);
    }
    static class pair implements Comparable<pair>{
		int pos, val;
		pair(int p, int v){ pos = p; val = v; }
		public int compareTo(pair x) { return Integer.compare(pos, x.pos); }
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
