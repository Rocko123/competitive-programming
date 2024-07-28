import java.util.*;
import java.io.*;
public class vm7wc_ggg {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	// since each elemnt in A and B are distinct
        // we can find the positions of B[i] in A
        // using this new array of idicies, we can
        // LIS the idicies so that there is no overlap
        // maintain the idicies of the values of A in an array

        int n = readInt();
        int[] a = new int[n], bina = new int[(int) 1e6+1];
        Arrays.fill(bina, -1);
        for (int i = 0; i < n; i++) {
            a[i] = readInt();
            bina[a[i]] = i;
        }

        int m = readInt();
        int[] b = new int[m];
        ArrayList<Integer> LIS = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            b[i] = readInt();
            int idx = bina[b[i]];
            if (idx == -1) continue;
            if (LIS.isEmpty() || idx > LIS.get(LIS.size()-1)) {
                LIS.add(idx);
            } else {
                binarySearch(idx, LIS);
            }
        }
        System.out.println(LIS.size());
    }
    static ArrayList<Integer> binarySearch (int element, ArrayList<Integer> LIS) {
        int L = 0, R = LIS.size()-1, M = (L+R)/2;
        int idx = R;
        while (L <= R) {
            M = (L+R) / 2;
            if (LIS.get(M) >= element) {
                idx = M;
                R = M-1;
            } else {
                L = M+1;
            }
        }
        LIS.set(idx, element);
        return LIS;
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