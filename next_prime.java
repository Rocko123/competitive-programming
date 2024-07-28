import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class next_prime {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        int n = Integer.parseInt(br.readLine());
        
        if (n <= 1) {
        	n = 2;
        } else if (n <= 3) {
        	
        } else {
        	for (int i = 2; i <= Math.sqrt(n); i++) {
            	if (n % i == 0) {
            		n++;
            		i = 1;
            	}
            }
        }
        
		System.out.println(n);

	}

}
