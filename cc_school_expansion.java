import java.util.*;
import java.io.*;
public class cc_school_expansion {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // best way to build N rooms
        // fracturing search

        int n = readInt(), a = readInt(), b = readInt();

        HashSet<List> vis = new HashSet<>();
        PriorityQueue<room> pq = new PriorityQueue<>();
        List<Long> ans = new ArrayList<>();

        pq.add(new room(a+b, 1, 1)); vis.add(List.of(1, 1));

        long cost = 0;
        while (!pq.isEmpty()) {
            room cur = pq.poll();    
            ans.add(cur.cost); cost += cur.cost; n--;
            if (n == 0) break; 

            long i = cur.i, j = cur.j;

            // check each neighboring room, unlimited rooms/floors
            if (!vis.contains(List.of(i+1, j))) {
                pq.add(new room((long) a*(i+1) + b*j, i+1, j));
                vis.add(List.of(i+1, j));
            }
            if (!vis.contains(List.of(i, j+1))) {
                pq.add(new room((long) a*i + b*(j+1), i, j+1));
                vis.add(List.of(i, j+1));
            }
        }
        System.out.println(cost);
    } 
    static class room implements Comparable<room> {
        long cost, i, j;
        room (long cost0, long i0, long j0) {
            cost = cost0; i = i0; j = j0;
        }
        public int compareTo(room x) {
            return Long.compare(cost, x.cost);
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