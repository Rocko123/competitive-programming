import java.util.*;
import java.io.*;
public class usaco_potion_farming {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> adj[];
    static int[] potions, leaves, val;
    static int ans = 0, maxtake = 0;
    public static void main(String[] args) throws IOException{
        int n = readInt(); 

        potions = new int[n+1]; leaves = new int[n+1]; val = new int[n+1]; 
        adj = new ArrayList[n+1];

        // idea: max potions we can take is the number of leaves
        // dfs to find number of potions collectable at some node and 
        // the number of leaves reachable, take their minimum

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            potions[i] = readInt();
        }

        for (int i = 1; i < n; i++) {
            int a = readInt(), b = readInt();
            adj[a].add(b); adj[b].add(a);
        }
        
        // find leaf nodes
        for (int i = 2; i <= n; i++) {
            if (adj[i].size() == 1) {   
                leaves[i]++; // increment each leaf
                maxtake++;
            }
        }
        for (int i = 1; i <= maxtake; i++) val[potions[i]]++; // increment the first # of leafs potions
        System.out.print(dfs(1, 0));
    }
    static int dfs (int cur, int parent) {
        int potion = val[cur]; // maximum potions collectable from cur to its leafs
        for (int nxt: adj[cur]) {
            if (nxt == parent) continue;
            potion += dfs(nxt, cur); // dfs to find the number of collectable potions
            leaves[cur] += leaves[nxt]; // number of leaves we can get to from cur
        }
        return Math.min(potion, leaves[cur]); // at most we can take the number of potions collected
        // or the number of leaves reached. which ever is smaller
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