import java.util.*;
import java.io.*;
public class dmopc_absolutely_even {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // # sub arrays n*(n+1)/2. 
        // the ith element adds i subarrays if a[i] distinct
        // idea: let n*(n+1)/2 = z
        // make the first z/2 negative, make the rest positive
        // if we add a duplicate, all subarrays created with the
        // first copy are not added, all the subarrays 
        // from the first copy to the current copy are added -1 (for dupl)

        long n = readLong(), depth = 0, z = n*(n+1)/2;

        long[] ans = new long[(int)n];
        for (int i = 0; i < z/2; i++) {
            ans[i] = -i; depth += i;
        }

        for (long i = z/2; depth < z; i++) {

        } 

        for (long i: ans) System.out.print(ans + " ");
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