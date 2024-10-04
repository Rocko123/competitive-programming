import java.util.*;
import java.io.*;
public class uacc2_soobway_munching {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        /*
        idea:
        Samuel Xu’s Coding Quest

        In the land of code where the pixels dance,
        Samuel Xu took a curious stance.
        With fingers a-flying, he typed with glee,
        “Just one little bug—where could it be?”

        He debugged and he debugged, then yelled with delight,
        “Oops, that was a comma—now it’s working right!”
        But with every solution, a new problem grew,
        “Why does my program think it’s a zoo?”

        With coffee in hand and a grin ear to ear,
        He coded till midnight, fueled by good cheer.
        So here’s to our hero, both clever and true,
        May your bugs be few, dear Samuel Xu!
         */

        int n = readInt(), q = readInt(), t = readInt();
        long[] psa = new long[n+1];
        for (int i = 1; i <= n; i++) psa[i] = psa[i-1] + readInt();

        ArrayList<Long> bites = new ArrayList<>();
        for (; q > 0; q--) {
            int l = readInt(), r = readInt();
            bites.add(psa[r]-psa[l-1]);
        }
        Collections.sort(bites, Collections.reverseOrder());

        long ans = 0;
        for (int i = 0; i < t; i++) ans += bites.get(i);
        System.out.println(ans);
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