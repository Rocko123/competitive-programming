import java.util.*;
import java.io.*;
public class ccc_firehose {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] houses;
    static int h, k;
    public static void main(String[] args) throws IOException{
        // opposite of CCO fast food?
        // idea: try every hose length with binary search

        h = readInt();
        houses = new int[h*2]; // circle
        for (int i = 0; i < h; i++) {
            houses[i] = readInt();
            houses[i+h] = houses[i] + (int) 1e6; 
        }
        Arrays.sort(houses);
        k = readInt();

        System.out.println(binarySearch());
    }
    static int binarySearch () {
        int L = 0, R = (int) 1e6-1, ans = Integer.MAX_VALUE;
        while (L <= R) {
            int M = (L+R)/2;
            if (check(M)) {
                ans = M;
                R = M-1;
            } else {
                L = M+1;
            }
        }
        return ans;
    }
    static boolean check (int length) { 
        // a hose can start at like 999999 and go to 0
        // instaed of the other way around
        // basically have to check every house
        int used = Integer.MAX_VALUE;
        for (int i = 0; i < h; i++) { // starting house
            int temp = 1, pos = houses[i] + 2*length;
            for (int j = i+1; j < i+h; j++) {
                if (pos < houses[j]) {
                    temp++;
                    pos = houses[j] + 2*length;
                }
            }
            used = Math.min(used, temp);
        }
        return used <= k;
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