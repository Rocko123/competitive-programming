import java.util.*;
import java.io.*;
public class acp_diverse_arrays {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // find first subarray starting from L ending at R with exactly K
        // since the R is the first one that makes exactly K, all following arrays working
        // maintain a frequency array for the current L, R
        // when you move L, decrease the freq, if it becomes zero you need to move R
        int n = readInt(), k = readInt();
        int[] a = new int[n+1], freq = new int[(int)1e6+1];
        for (int i = 1; i <= n; i++) a[i] = readInt();

        long ans = 0;
        int l = 1, r = 1, cnt = 0;
        for (; l <= n && r <= n; r++) {
            if (freq[a[r]] == 0) cnt++;
            freq[a[r]]++;
            while (cnt >= k) {
                ans += (n-r+1);
                freq[a[l]]--;
                if (freq[a[l]] == 0) {cnt--;}
                l++;
            }
        }
        System.out.println(ans);
    } 
    private static final int BUFFER_SIZE = 1 << 16;
	private static int LENGTH = -1;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE], buf = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
    private static byte read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}
    private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}
    public static int readInt() throws IOException {
		int ret = 0;
		byte c;
		do {
			c = read();
		} while (c <= ' ');
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0');
		if (neg)
			return -ret;
		return ret;
	}
}