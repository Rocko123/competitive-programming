import java.util.*;
import java.io.*;
public class list_minimum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = readInt();
        }
        mergeSort(nums, 0, n-1);
        for (int i: nums) System.out.println(i);
    }
    static void mergeSort(int[] nums, int L, int R) {
        if (L < R) {
            int M = (L+R)/2;
            mergeSort(nums, L, M);
            mergeSort(nums, M+1, R);
            merge(nums, L, M, R);
        }
    }

    static void merge (int[] nums, int L, int M, int R) {
        // these two subarrays are sorted
        int n1 = M-L+1;
        int n2 = R-M;
        // 0 0 0 0 0
        // L = 0, R = 4, M = 2

        // fill these arrays with what is in nums
        int[] arr1 = new int[n1]; int[] arr2 = new int[n2];
        for (int i = 0; i < n1; i++) arr1[i] = nums[L+i];
        for (int i = 0; i < n2; i++) arr2[i] = nums[M+1+i];

        // pointers
        int i = 0, j = 0, k = L;

        // sort elements
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                nums[k] = arr1[i];
                i++;
            } else {
                nums[k] = arr2[j];
                j++;
            }
            k++;
        }
        // one array will finish before the other, fill in left over elements
        while (i < n1) {
            nums[k] = arr1[i];
            i++; k++;
        }
        while (j < n2) {
            nums[k] = arr2[j];
            j++; k++;
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
