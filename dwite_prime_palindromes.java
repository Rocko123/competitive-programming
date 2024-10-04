import java.util.*;
import java.io.*;
public class dwite_prime_palindromes {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        boolean[] isPrime = new boolean[(int) 1e6];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < (int) 1e6; i++) {
            if (isPrime[i]) for (long j = (long) i*i; j < (int) 1e6; j += i) isPrime[(int)j] = false;
        }
        long[] psa = new long[(int) 1e6];
        for (int i = 2; i < (int) 1e6; i++) {
            if (isPrime[i]) {
                String f = String.valueOf(i);
                String r = "";
                for (int j = f.length()-1; j >= 0; j--) r += f.charAt(j);
                if (f.equals(r)) psa[i]++; 
            }
        }
        for (int i = 1; i < (int) 1e6; i++) psa[i] += psa[i-1];
        // 5 inputs 
        for (int t = 1; t <= 5; t++) {
            int l = readInt(), u = readInt();
            System.out.println(psa[u]-psa[l-1]);
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