import java.util.*;
import java.io.*;
public class dmopc_classic_problem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // idea: maintain two pointers L and R for the current subarray, use a max and min deque to track the max and min
        // proof: each element gets added to both deques once, when we add another element we can only at most ever remove one of the instances. Then over the two
        // deques its guaranteed that all elements from L to R exist, in relative order. When L to R stops working, move L forwards and remove it from the respective deque(s) until it works.  
        // since we say the max-min <= k for L to R, it means all subarrays including R will work -> R-L+1
        // note: Two subarrays are different if they occupy a different range of elements, even if the elements themselves are the same

        int n = readInt(), k = readInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) a[i] = readInt();

        Deque<Integer> max = new ArrayDeque<>(), min = new ArrayDeque<>();
        long ans = 0;
        for (int L = 1, R = 1; R <= n; R++) {
            while (!max.isEmpty() && max.peekLast() < a[R]) max.pollLast();
            while (!min.isEmpty() && min.peekLast() > a[R]) min.pollLast();
            max.add(a[R]); min.add(a[R]);
            while (max.peekFirst() - min.peek() > k) {
                if (max.peekFirst() == a[L]) max.pollFirst();
                if (min.peekFirst() == a[L]) min.pollFirst();
                L++;
            }
            ans += (R-L+1);
        }
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