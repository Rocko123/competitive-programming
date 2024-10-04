import java.util.*;
import java.io.*;
public class ccc_wireless {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, k;
    public static void main(String[] args) throws IOException{
        m = readInt(); n = readInt(); k = readInt(); // row, col
        int[][] bit = new int[m+2][n+2];

        // each cell is an intersection
        // updates in O(n) time
        // 2d dsa the bit rate then run psa 

        for (int i = 0; i < k; i++) {
            int x = readInt(), y = m-readInt()+1, r = readInt(), b = readInt();
            int nlx = Math.max(1, x-r), nrx = Math.min(x+r, n), ndy = Math.min(m, y+r), nuy = Math.max(1, y-r);
            // dif[r1][c1] += x    dif[r1][c2+1] -=x
            // dif[r2+1][c1] -= x   dif[r2+1][c2+1] += x 
            // where r1, c1 is top left and r2, c2 is bottom right
            bit[nuy][nlx] += b; bit[nuy][nrx+1] -= b;
            bit[ndy+1][nlx] -= b; bit[ndy+1][nrx+1] += b;

            // for (int j = 1; j <= m+1; j++) System.out.println(Arrays.toString(bit[j]));

            for (int j = 1; j <= r; j++) {
                int nx = (int) Math.floor(Math.sqrt(r*r-j*j));
                // System.out.println("Dist "  + nx);
                if (good(y-j, x-nx)) {
                    bit[y-j][nlx] -= b; bit[y-j][x-nx] += b;
                    bit[y-j+1][nlx] += b; bit[y-j+1][x-nx] -= b;
                }
                if (good(y-j, x+nx)) {
                    bit[y-j][x+nx+1] -= b; bit[y-j][nrx+1] += b;
                    bit[y-j+1][x+nx+1] += b; bit[y-j+1][nrx+1] -= b;

                }
                if (good(y+j, x-nx)) {
                    bit[y+j][nlx] -= b; bit[y+j][x-nx] += b;
                    bit[y+j+1][nlx] += b; bit[y+j+1][x-nx] -= b;
                }
                if (good(y+j, x+nx)) {
                    bit[y+j][x+nx+1] -= b; bit[y+j][nrx+1] += b;
                    bit[y+j+1][x+nx+1] += b; bit[y+j+1][nrx+1] -= b;
                }
                // for (int a = 0; a <= m+1; a++) System.out.println( a + " " + Arrays.toString(bit[a]));
                // System.out.println();
            }
        }
        

        int max = -1, freq = -1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                bit[i][j] += bit[i-1][j] + bit[i][j-1] - bit[i-1][j-1];
                if (bit[i][j] > max) {
                    max = bit[i][j];
                    freq = 1;
                } else if (bit[i][j] == max) {
                    freq++;
                }
            }
        }
        System.out.println(max);
        System.out.println(freq);
        // for (int i = 1; i <= m; i++) System.out.println(Arrays.toString(bit[i]));
    }
    static boolean good (int ny, int nx) {
        return ny >= 1 && ny <= m && nx >= 1 && nx <= n;
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