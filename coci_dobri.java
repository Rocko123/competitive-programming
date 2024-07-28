import java.util.*;
import java.io.*;
public class coci_dobri {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt();
        int[] a = new int[n];
        Set<Integer> sums = new HashSet<>();
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            a[i] = readInt();
            for (int j = 0; j < i; j++) {
                if (sums.contains(a[i]-a[j])) {
                    ans++;
                    break;
                }
            }
            for (int j = 0; j <= i; j++) {
                sums.add(a[i] + a[j]);
            }
        }
        System.out.println(ans);
        // use ai = aj + ak + al
        // ai - aj = ak + al
        // if have ak + al, its good, add all ai + aj when done
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