import java.util.*;
import java.io.*;
public class usaco_closest_cow_wins {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int k, m, n;
    static ArrayList<Integer> cows, patches;
    public static void main (String[] args) throws IOException {
        // we can always beat Nohj so long as he isnt on the patch
        // idea: find the midpoint of two cows loop add the solution from the left
        // cow to the mid and the mid to the right
        // add these to an array, sort it, and take the first n values

        k = readInt(); m = readInt(); n = readInt();

        cows = new ArrayList<>(); patches = new ArrayList<>();
        HashMap<Integer, Integer> val = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int p = readInt(), t = readInt();
            val.put(p, t); patches.add(p);
        }
        for (int i = 0; i < m; i++) cows.add(readInt());
        Collections.sort(cows); Collections.sort(patches);

        long ans = 0;
        ArrayList<Long> ansarr = new ArrayList<>();
        for (int i = 0; i < cows.size(); i++) {
            long sum = 0;
            int L = -1, R = -1;
            if (i == 0) {
                R = binarySearch(cows.get(i), false);
                if (R == -1) continue;
                for (int j = 0; j <= R; j++) {
                    sum += val.get(patches.get(j));
                }
                ansarr.add(sum);
            } else if (i == cows.size()-1) {
                L = binarySearch(cows.get(i), true);
                if (L == -1) continue;
                for (int j = L; j < patches.size(); j++) {
                    sum += val.get(patches.get(j));
                }
                ansarr.add(sum);
            } else {
                
            }
        }
        Collections.sort(ansarr);
        System.out.println(ansarr);
        for (int i = 0; i < Math.min(n, ansarr.size()); i++) ans += ansarr.get(ansarr.size()-i-1);
        System.out.println(ans);
    }
    static int binarySearch (double start, boolean up) { // find range for patches
        int L = 0, R = k-1, ans = -1;
        while (L <= R) {
            int M = (L+R)/2;
            if (up) {
                if (patches.get(M) > start) {
                    ans = M;
                    R = M-1;
                } else {
                    L = M+1;
                }
            } else {
                if (patches.get(M) < start) {
                    ans = M;
                    L = M+1;
                } else {
                    R = M-1; 
                }
            }
        }
        return ans;
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