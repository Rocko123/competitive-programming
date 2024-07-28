import java.util.*;
import java.io.*;
public class catch_the_cat {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int x = readInt();
    	int y = readInt();
    	
    	int[] dist = new int[100001];
    	boolean[] visited = new boolean[100001];
    	Queue<Integer> q = new LinkedList();
    	
    	visited[x] = true;
    	q.add(x);
    	
    	while(!q.isEmpty()) {
    		int p = q.poll();
    		int d = dist[p] + 1;
    		
    		
    		int move1 = p-1;
    		int move2 = p+1;
    		int move3 = p * 2;
    		
    		if (move1 >= 0 && !visited[move1]) {
    			dist[move1] = d;
    			visited[move1] = true;
    			q.add(move1);
    		}
    		if (move2 <= 100000 && !visited[move2]) {
    			dist[move2] = d;
    			visited[move2] = true;
    			q.add(move2);
    		}
    		if (move3 <= 100000 && !visited[move3]) {
    			dist[move3] = d;
    			visited[move3] = true;
    			q.add(move3);
    		}
    		
    		if (visited[y]) {
    			break;
    		}
    		
    	}
    	
    	System.out.println(dist[y]);
   
    	
    	
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