import java.util.*;
import java.io.*;
public class ccc_floor_plan {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int flooring = readInt();
    	int r = readInt();
    	int c = readInt();
    	
    	
    	ArrayList<Integer> rooms = new ArrayList<Integer>();
    	char matrix[][] = new char[r][c];
    	for (int i = 0; i < r; i ++) {
    		matrix[i] = readLine().toCharArray();
    	}
    	
    	for (int i = 0; i < r; i++) {
    		for (int j = 0; j < c; j++) {
    			if (matrix[i][j] == '.') {
    				int roomSize = 0;
    				Queue<int[]> q = new LinkedList();
    				q.add(new int[] {i, j});
    				matrix[i][j] = 'I'; // marking it as visited
    				while (!q.isEmpty()) {
    					roomSize++;
    					int y = q.peek()[0];
    					int x = q.peek()[1];
    					q.poll();
    					if (y + 1 < r && matrix[y+1][x] == '.') {
    						matrix[y+1][x] = 'I';
    						q.add(new int[] {y+1, x});
    					}
    					if (y - 1 >= 0 && matrix[y-1][x] == '.') {
    						matrix[y-1][x] = 'I';
    						q.add(new int[] {y-1, x});
    					}
    					if (x + 1 < c && matrix[y][x+1] == '.') {
    						matrix[y][x+1] = 'I';
    						q.add(new int[] {y, x+1});
    					}
    					if (x - 1 >= 0 && matrix[y][x-1] == '.') {
    						matrix[y][x-1] = 'I';
    						q.add(new int[] {y, x-1});
    					}
    				}
    				rooms.add(roomSize);
    			}
    		}
    	}
    	
    	int floorable = 0;
    	Collections.sort(rooms, Collections.reverseOrder());
    	for (int i: rooms) {
    		if (flooring - i >= 0) {
    			flooring -= i;
    			floorable++;
    		} else {
    			break;
    		}
    	}
    	
    	if (floorable != 1) {
    		System.out.printf("%d rooms, %d square metre(s) left over", floorable, flooring);
    	} else {
    		System.out.printf("1 room, %d square metre(s) left over", flooring);
    	}
    	
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