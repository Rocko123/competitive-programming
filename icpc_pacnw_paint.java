import java.util.*;
import java.io.*;
public class icpc_pacnw_paint {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<art> artists = new ArrayList<>(), dp = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        // n is very large, k isn't that big
        // dp state: since a 10^18 array is way too big, instead
        // store the best answer for a possible end, at most K ends

        long n = readLong(), ans = 0; int k = readInt();

        for (int i = 0; i < k; i++) {
            long a = readLong(), b = readLong();
            artists.add(new art(a, b));
        }
        Collections.sort(artists);

        HashSet<Long> in = new HashSet<>();
        for (art i: artists) {
            int idx = binarySearch(i.a); // find last left artist
            long coverage = i.b-i.a+1;
            coverage += idx != -1 ? dp.get(idx).b: 0;
            ans = Math.max(ans, coverage);

            // looping from 0 to idx is too slow
            // instead, move the best answer along always

            if (in.contains(i.b)) { // a same end already exists
                int idx2 = binarySearch(i.b)+1; // get its idx
                dp.get(idx2).b = ans;
            } else {
                dp.add(new art(i.b, ans));
            }
            in.add(i.b);
        }
        System.out.println(n-ans);
    }
    static int binarySearch (long start) { // always return idx < start with max value
        int L = 0, R = dp.size()-1, idx = -1;
        while (L <= R) {
            int M = (L+R)/2;
            if (dp.get(M).a < start) {
                idx = M;
                L = M+1;
            } else {
                R = M-1;
            }
        }
        return idx;
    }
    static class art implements Comparable<art> {
        long a, b;
        art (long a0, long b0) {
            a = a0; b = b0;
        }
        public int compareTo(art x) {
            return Long.compare(b, x.b);
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