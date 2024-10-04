import java.util.*;
import java.io.*;
public class fbhc_lazy_sort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for (int j = 1; j <= t; j++) {
            int n = readInt();
            Deque<Integer> og1 = new LinkedList<>(), og2 = new LinkedList<>(), nw1 = new LinkedList<>(), nw2 = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int student = readInt();
                og1.addFirst(student); og2.addFirst(student);
            }
            // *from bottom to top*
            // have to try both for first one
            nw1.add(og1.pollFirst()); nw2.add(og2.pollLast());
            boolean good1 = true, good2 = true;
            for (int i = 1; i < n; i++) {
                if (og1.peekFirst() == nw1.peekFirst()-1) {
                    nw1.addFirst(og1.pollFirst());
                } else if (og1.peekFirst() == nw1.peekLast()+1) {
                    nw1.addLast(og1.pollFirst());
                } else if (og1.peekLast() == nw1.peekFirst()-1) {
                    nw1.addFirst(og1.pollLast());
                } else if (og1.peekLast() == nw1.peekLast()+1) {
                    nw1.addLast(og1.pollLast());
                } else {
                    good1 = false;
                    break;
                }
            }
            for (int i = 1; i < n; i++) {
                if (og2.peekFirst() == nw2.peekFirst()-1) {
                    nw2.addFirst(og2.pollFirst());
                } else if (og2.peekFirst() == nw2.peekLast()+1) {
                    nw2.addLast(og2.pollFirst());
                } else if (og2.peekLast() == nw2.peekFirst()-1) {
                    nw2.addFirst(og2.pollLast());
                } else if (og2.peekLast() == nw2.peekLast()+1) {
                    nw2.addLast(og2.pollLast());
                } else {
                    good2 = false;
                    break;
                }
            }
            // System.out.println(good1);
            // System.out.println(good2);
            System.out.println("Case #" + j + ": " + (good1 || good2 ? "yes": "no"));
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