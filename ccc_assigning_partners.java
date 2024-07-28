import java.util.*;
import java.io.*;
public class ccc_assigning_partners {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt(); 
    	String [] students = new String[n];
    	Map<String, String> map = new HashMap<>();
    	for(int i = 0; i < n; i++) {
    		students[i] = next();
    	}
    	for(int i = 0; i < n; i++) {
    		map.put(students[i], next());
    	}
    	for(String key : map.keySet()) {
    		String val = map.get(key);
    		if(key.equals(val) || !map.get(val).equals(key)) {
    			System.out.println("bad"); return;
    		}
    	}
    	System.out.println("good");
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
