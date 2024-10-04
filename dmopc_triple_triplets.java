import java.util.*;
import java.io.*;
public class dmopc_triple_triplets {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();

        // didn't understand question well
        // its not the elements that have to be distinct, but the indicies
        // we can just spam 1 1 2

        int ones = (n/4) * 2, twos = (n/4);
        if (ones + twos * 2 == n-1) {
            ones++;
        } else if (ones + twos * 2 == n-2) {
            ones += 2;
        } else {
            ones += 3;
        }
        
        // System.out.println(ones + " " + twos);
        System.out.println(factorial(ones)/(2 * factorial(ones-2)) * twos);
    }
    static long factorial (int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
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