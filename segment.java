import java.util.*;
import java.io.*;
public class segment {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        ArrayList<line> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) lines.add(new line(readInt(), readInt()));

        int last = -1, ans = 0;
        PriorityQueue<line> q = new PriorityQueue<>(lines); // bro thinks they're going to sort themsevles
        while (!q.isEmpty()) {
            line cur = q.poll();
            if (cur.s >= last) {
                ans++;
                last = cur.r;
            }
        }
        System.out.println(ans);
    }   
    static class line implements Comparable<line> {
        int s, r;
        line (int s0, int r0) {
            s = s0; r = r0;
        }
        public int compareTo(line x) {
            return Integer.compare(r, x.r);
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