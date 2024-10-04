import java.util.*;
import java.io.*;
public class usaco_swapity_swap {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int a1, a2, b1, b2;
    public static void main(String[] args) throws IOException{
    	int n = readInt(), k = readInt();
        a1 = readInt();
        a2 = readInt();
        b1 = readInt(); 
        b2 = readInt();

        int[] cows = new int[n+1];
        for (int i = 1; i <= n; i++) cows[i] = i;
        int mod = findMod(cows, 0);
        int times = k % mod;
        cows = simulate(times, cows);
        printArr(cows);

    }
    static int[] simulate(int times, int[] arr) {
        for (;times > 0; times--) {
            for (int i = 0; i <= (a2-a1)/2; i++) {
                int temp = arr[a1+i];
                arr[a1+i] = arr[a2-i];
                arr[a2-i] = temp;
            }
            for (int i = 0; i <= (b2-b1)/2; i++) {
                int temp = arr[b1+i];
                arr[b1+i] = arr[b2-i];
                arr[b2-i] = temp;
            }
        }
        return arr;
    }

    static int findMod (int[] arr, int times) {
        while (!checker(arr) || times == 0) {
            arr = simulate(1, arr);
            times++;
        }
        return times;
    }

    static boolean checker(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (!(arr[i] > arr[i-1])) {
                return false;
            }
        }
        return true;
    }

    static void printArr (int[] arr) {
        for (int i = 1; i < arr.length; i++) System.out.println(arr[i]);
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