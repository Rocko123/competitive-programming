import java.util.*;
import java.io.*;
public class usaco_milk_exchange {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt(), m = readInt();

        long ans = 0;
        char[] steps = new char[n];
        String s = readLine();
        for (int i = 0; i < n; i++) {
            steps[i] = s.charAt(i);
        }
        int[] cap = new int[n];
        for (int i = 0; i < n; i++) {
            cap[i] = readInt();
            ans += cap[i];
        }
        // two cows that give to each other never lose, in a loop
        // cows that only give lose, we can consider a sequence
        // of cows that give to be a chain connected to a pair of cows in a loop
        // the link loses milk Math.min(m, linksum)
        int loss = 0;
        int chain = 0, index = 0;
        HashMap<Integer, Integer> chains = new HashMap<>();
        boolean[] inP = new boolean[n];
        char cur = steps[0];
        for (int i = 0; i < n; i++) {
            if (steps[i] == cur || chain == 0) {
                cur = steps[i];
                chain += cap[i];
            } else {
                if (cur == 'R') { // currently have an R chain
                    // System.out.println("C: " + (chain-1));
                    chains.put(index, chain-cap[i-1]);
                    index++; chain = 0; // next is the start of a new chain
                    inP[i] = inP[i-1] = true; 
                } else { // currently have an L chain
                    if (!inP[i-1]) { // previous L does not form a pain, add that chain
                        // System.out.println("C not in p: " + (chain));
                        chains.put(index, chain);
                        index++; 
                    }
                    chain = cap[i]; // cur is the start of a chain
                    cur = steps[i];
                }
            }
            if (i == n-1 && !inP[0] && !inP[i] && steps[i] == steps[0] && chains.containsKey(0)) {
                // System.out.println("joined LR: " + (chain));
                chains.put(0, chains.get(0) + chain);
            }
        }
        // for (int i: chains.keySet()) System.out.println(chains.get(i));
        for (int i: chains.keySet()) {
            loss += Math.min(m, chains.get(i));
        }
        // System.out.println(loss);
        System.out.println(Math.max(0, ans-loss));
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