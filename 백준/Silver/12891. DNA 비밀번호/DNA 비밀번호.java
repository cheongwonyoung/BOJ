import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		
		int S = Integer.parseInt(input[0]);
		int P = Integer.parseInt(input[1]);
		
		String[] str = in.readLine().split("");
		
		input = in.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		int G = Integer.parseInt(input[2]);
		int T = Integer.parseInt(input[3]);
		
		int left = 0;
		int right = P-1;
		
		int count = 0;
		
		int[] alphaCnt = new int[4];
		for(int i=left; i<=right; i++) {
			if(str[i].equals("A")) {
				alphaCnt[0]++;
			}
			else if(str[i].equals("C")) {
				alphaCnt[1]++;
			}
			else if(str[i].equals("G")) {
				alphaCnt[2]++;
			}
			else if(str[i].equals("T")) {
				alphaCnt[3]++;
			}
		}
		
		while(true) {
			if(A<=alphaCnt[0] && C<=alphaCnt[1] && G<=alphaCnt[2] && T<=alphaCnt[3]) {
				count++;
			}
			
			if(str[left].equals("A")) {
				alphaCnt[0]--;
			}
			else if(str[left].equals("C")) {
				alphaCnt[1]--;
			}
			else if(str[left].equals("G")) {
				alphaCnt[2]--;
			}
			else if(str[left].equals("T")) {
				alphaCnt[3]--;
			}

			
			left++;
			right++;
			if(right==S) break;

			if(str[right].equals("A")) {
				alphaCnt[0]++;
			}
			else if(str[right].equals("C")) {
				alphaCnt[1]++;
			}
			else if(str[right].equals("G")) {
				alphaCnt[2]++;
			}
			else if(str[right].equals("T")) {
				alphaCnt[3]++;
			}
			
			
			
		}
		
		
		System.out.println(count);
		
	}
}