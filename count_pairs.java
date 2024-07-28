import java.util.*;
import java.io.*;
public class count_pairs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException{
        // the order doesnt matter?
        // binary search for element that makes it not work
        // subtract the nubmer of pairs of not working from working answer
        n = readInt(); m = readInt();
        long ans = 0;
        arr = new long[n+1];
        for (int i = 1; i <= n; i++) arr[i] = readInt();    
        Arrays.sort(arr, 1, n+1);

        int L = 1, R = n;
        while (L < R) {
            if (arr[L] + arr[R] <= m) {
                ans += (R-L); 
                // all the pairs starting at L+1 to R work with L
                L++; // make start bigger and see if it works
            } else {
                R--;
                // make end smaller see if it works
            }
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