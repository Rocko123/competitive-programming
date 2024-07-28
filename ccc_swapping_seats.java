import java.util.*;
import java.io.*;
public class ccc_swapping_seats {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    public static void main(String[] args) throws IOException{
        char[] input = readLine().toCharArray();
        n = input.length;
        int[] psaA = new int[n+1];
        int[] psaB = new int[n+1];
        int[] psaC = new int[n+1];

        int a = 0, b = 0, c = 0;
        for (int i = 1; i <= n; i++) {
            if (input[i-1] == 'A') {
                a++;
            } else if (input[i-1] == 'B') {
                b++;
            } else if (input[i-1] == 'C') {
                c++;
            }
            psaA[i] = a;
            psaB[i] = b;
            psaC[i] = c;
        }
        // start with the X section, consider either being
        // followed by some section Y or Z
        // [i, i+X) must all be X
        // [i+X, i+X+Y) must all be Y OR [i+X, i+X+Z) must all be Z
        // total bad - min (XinY, YinX) for any consecutive sections X, Y
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            // if the current index is less than
            // the sum of two letter sections continue
            if (a+b <= i) {
                ans = Math.min(ans, getMin(psaA, psaB, i));
                ans = Math.min(ans, getMin(psaB, psaA, i));
            }
            if (a+c <= i) {
                ans = Math.min(ans, getMin(psaA, psaC, i));
                ans = Math.min(ans, getMin(psaC, psaA, i));
            }
            if (b+c <= i) {
                ans = Math.min(ans, getMin(psaB, psaC, i));
                ans = Math.min(ans, getMin(psaC, psaB, i));
            }
        }
        // the reason this works is because we push the # of swaps required
        // for the section that wraps around the end and front of the array 
        // to the remaining swaps, so after computing min doable swaps, the remaining
        // # of swaps is that section (if such a section exists).
        // Consider a case where the optimal solution has A's at the end and
        // front. We compute the min swaps between B and C, the remaining
        // bad are the A swaps.
        System.out.println(ans);
    }
    static int getMin(int[] first, int[] second, int i) {
        int numFirst = first[n], numSecond = second[n];
        int badFirst = numFirst - (first[i-numSecond] - first[i-numSecond - numFirst]);
        int badSecond = numSecond - (second[i] - second[i-numSecond]);
        int firstInSecond = first[i] - first[i-numSecond];
        int secondInFirst = second[i-numSecond] - second[i-numSecond-numFirst];
        return badFirst + badSecond - Math.min(firstInSecond, secondInFirst);
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