import java.util.*;
import java.io.*;
public class coci_ozljeda {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int k = readInt();
        long[] xor = new long[k+2];
        long[] psa = new long[k+2];
        for (int i = 1; i <= k; i++) {
            xor[i] = readLong();
            psa[i] = xor[i] ^ psa[i-1];
        }
        xor[k+1] = psa[k];
        psa[k+1] = xor[k+1] ^ psa[k];
        // a^c^c = a

        // if k = 3
        // a, b, c
        // 1: a
        // 2: b
        // 3: c
        // 4: a ^ b ^ c
        // 5: b ^ c ^ a ^ b ^ c = a
        // System.out.println();

        //System.out.println(Arrays.toString(xor));
        // System.out.println(Arrays.toString(psa));

        int q = readInt();
        for (; q > 0; q--) {
            long l = readLong() % (k+1), r = readLong() % (k+1);
            if (l == 0) l = k+1;
            if (r == 0) r = k+1;
            System.out.println(psa[(int)r]^psa[(int)(l-1)]);
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