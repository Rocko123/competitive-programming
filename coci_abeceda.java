import java.util.*;
import java.io.*;
public class coci_abeceda {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	// build a directed graph and then topo sort
    	// cycle no solution, multiple nodes in q multiple solutions
        // somehow the input can not be in lexicographic order
        int n = readInt();
        int[] inDeg = new int[26];
        boolean[] used = new boolean[26];
        List<Integer> adj[] = new ArrayList[26];
        for (int i = 0; i < 26; i++) adj[i] = new ArrayList<>();

        int charsUsed = 0;
        String prev = readLine(); int length = prev.length();
        for (; n > 1; n--) { 
            // as soon as we find a difference in chars stop
            String word = readLine();
            boolean dif  = false;
            String longer = word.length() > length ? word: prev;
            if (prev.startsWith(word) && !prev.equals(word)) charsUsed++; // big fraud
            length = Math.min(length, word.length());
            for (int i = 0; i < length; i++) {
                int char1 = prev.charAt(i)-97, char2 = word.charAt(i)-97;
                used[char1] = true; used[char2] = true;
                if (char1 != char2 && !dif) {
                    adj[char1].add(char2); 
                    inDeg[char2]++; 
                    dif = true;
                } 
            }
            for (int i = length; i < longer.length(); i++) {
                int char1 = longer.charAt(i)-97;
                used[char1] = true;
            }
            prev = word; length = word.length();
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (used[i]) {
                charsUsed++;
                if (inDeg[i] == 0) q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        boolean fail = false;
        while (!q.isEmpty()) {
            int cur = q.poll(); ans.add(cur);
            if (!q.isEmpty()) {
                fail = true;
            }
            for (int i: adj[cur]) {
                if (--inDeg[i] == 0) {
                    q.add(i);
                }
            }
        }
        if (ans.size() != charsUsed) {
            System.out.println("!");
        } else if (fail) {
            System.out.println("?");
        } else {
            for (int i: ans) System.out.print((char) (i+97));
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
