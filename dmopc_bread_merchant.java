import java.util.*;
import java.io.*;
public class dmopc_bread_merchant {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        int[] p = new int[n+1], ans = new int[n+1], outdeg = new int[n+1];
        List<Integer> radj[] = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            p[i] = readInt(); 
            radj[i] = new ArrayList<>();
        }

        // instead of running dfs to detect cycles, where nodes
        // could rely on their parents and children depending on if there are police
        // run topo sort on reversed graph for all nodes with out degree 0
        // then if there are police at some node they will be forced to go there

        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt();
            radj[b].add(a);
            outdeg[a]++;
        }


        boolean[] vis = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (outdeg[i] == 0) { // dead end
                q.add(i);
                vis[i] = true;
            } 
        }

        
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans[cur] = 1;
            for (int i: radj[cur]) {
                if ((--outdeg[i] == 0 || p[i] > 0) && !vis[i]) {
                    outdeg[i] = 0;
                    vis[i] = true;
                    q.add(i);
                    // if the only way to get there is from a dead end 
                    // or theres a cop that could force the robber they are captured
                }
            }
        }
        for (int i = 1; i < n; i++) System.out.print(ans[i] + " ");
        System.out.println(ans[n]);
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