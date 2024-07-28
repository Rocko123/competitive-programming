import java.util.*;
    import java.io.*;
    public class longest_increasing_subsequence_nlongn {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static ArrayList<Integer> dp;
        public static void main(String[] args) throws IOException{
            int n = readInt();
            dp = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                binarySearch(readInt());
            }
            System.out.println(dp.size());
        }
        static void binarySearch (int target) {
            if (dp.isEmpty() || dp.get(dp.size()-1) < target) {
                dp.add(target);
                return;
            }
            int L = 0, R = dp.size()-1, M = (L+R)/2, idx = R;
            while (L <= R) {
                M = (L+R)/2;
                if (dp.get(M) < target) {
                    L = M+1;
                } else {
                    idx = M;
                    R = M-1;
                }
            }
            dp.set(idx, target);
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