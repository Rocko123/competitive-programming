import java.io.*;
import java.util.*;

public class ccc_math_problem {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		double k = readInt();
		double p = readInt();
		double x = readInt();
		double m = 1;
		
		double prev = Double.MAX_VALUE;
		while (true) {
			double f = (double) m * x + (double)(k * p / m);
			
			if (f < prev) {
				prev = f;
			} else if (f > prev) {
				System.out.format("%.3f\n", prev);
				break;
			}
			m++;
		}
		// too dumb to implement AM GM and somehow passes as 4th fastest Java 8 sub...
	}
	
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine().trim());
		}
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
