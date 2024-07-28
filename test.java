import java.io.*;
import java.util.*;

public class test {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        boolean[]visited = new boolean[r*c+2];

        int[][] arr = new int[r+2][c+2];

        ArrayList<Integer>[]graph = new ArrayList[r*c];
        for(int i = 0; i < r*c; i++) graph[i] = new ArrayList<>();

        boolean check = true;
        int sum1 = 0;

        for(int i = 0; i < r; i++){
            String a = br.readLine();
            for(int x = 0; x < a.length(); x++){
                if(a.charAt(x) == '*') check = false;

                if(a.charAt(x) == 'S') {
                    arr[i][x] = 1;
                    sum1 += 1;
                }
                if(a.charAt(x) == 'M') {
                    arr[i][x] = 5;
                    sum1 += 5;
                }
                if(a.charAt(x) == 'L') {
                    arr[i][x] = 10;
                    sum1 += 10;
                }
            }
        }


        int sum = 0;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(arr[i][j] != 0){
                    if(checkUp(arr, i, j)) {
                        graph[i*r+j].add((i-1)*r+j);
                        graph[(i-1)*r+j].add(i*r+j);
                    }
                    if(checkDown(arr, i, j)) {
                        graph[i*r+j].add((i+1)*r+j);
                        graph[(i+1)*r+j].add(i*r+j);
                    }
                    if(checkLeft(arr, i, j)) {
                        graph[i*r+j].add(i*r+j-1);
                        graph[i*r+j-1].add(i*r+j);
                    }
                    if(checkRight(arr, i, j)) {
                        graph[i*r+j].add(i*r+j+1);
                        graph[i*r+j+1].add(i*r+j);
                    }

                }
            }
        }

        int b = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        visited[b*r+e] = true;
        Queue<Integer>queue = new LinkedList<>();

        queue.add(b*r+e);
        sum += arr[b][e];

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next: graph[cur]){
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    sum += arr[next/r][next%r];
                }
            }
        }

        //if(!check) System.out.println(sum);
        System.out.println(sum1);



    }


    public static boolean checkUp(int[][]arr, int i, int j){
        if(arr[i][j] != 0 && i-1 >= 0 && arr[i-1][j] != 0) return true;
        else return false;
    }

    public static boolean checkDown(int[][]arr, int i, int j){
        if(arr[i][j] != 0 && i+1 < arr.length && arr[i+1][j] != 0) return true;
        else return false;
    }

    public static boolean checkLeft(int[][]arr, int i, int j){
        if(arr[i][j] != 0 && j-1 >= 0 && arr[i][j-1] != 0) return true;
        else return false;
    }

    public static boolean checkRight(int[][]arr, int i, int j){
        if(arr[i][j] != 0 && j+1 < arr[i].length && arr[i][j+1] != 0) return true;
        else return false;
    }
}