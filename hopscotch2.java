import java.util.*;
import java.io.*;
public class hopscotch2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), k = readInt();
        long[] a = new long[n+1], dp = new long[n+2];
        int[] pre = new int[n+2];
        for (int i = 1; i <= n; i++) a[i] = readLong();
        Arrays.fill(dp, 1, dp.length, Long.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        for (int i = 1; i <= n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() < i-k) dq.pollFirst();
            dp[i] = dp[dq.peekFirst()] + a[i];
            pre[i] = dq.peekFirst();
            while (!dq.isEmpty() && dp[dq.peekLast()] >= dp[i]) dq.pollLast();
            dq.add(i);
        }
        if (!dq.isEmpty() && dq.peekFirst() < n-k+1) dq.pollFirst();
        System.out.println(dp[dq.peekFirst()]);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = dq.peekFirst(); i > 0; i = pre[i]) ans.add(i);
        Collections.reverse(ans);
        for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
        System.out.println();
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