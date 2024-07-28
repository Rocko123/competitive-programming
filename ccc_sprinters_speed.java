import java.io.*;
import java.util.*;
public class ccc_sprinters_speed {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int n = readInt();
		
		// greedy attempt with times
		int[] sortedTimes = new int[n];
		HashMap<Integer, Integer> timeSpeed = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int t = readInt();
			int x = readInt();
			sortedTimes[i] = t;
			timeSpeed.put(t, x);
		}

		
		Arrays.sort(sortedTimes);
		double maxSpeed = 0.0;
		for (int i = 1; i < n; i++) {
			double speed = (double) (Math.abs(timeSpeed.get(sortedTimes[i])-timeSpeed.get(sortedTimes[i-1]))/ (double)(sortedTimes[i]-sortedTimes[i-1]));
			if (speed > maxSpeed) {
				maxSpeed = speed;
			}
		}
		System.out.println(maxSpeed);
		// if this doesn't work start casting everything as a double
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
