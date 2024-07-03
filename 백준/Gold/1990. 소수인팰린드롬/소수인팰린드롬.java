import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int range = 100000000;
		boolean[] prime = new boolean[range+1];
		prime[0] = true;
		prime[1] = true;
		
		
		for(int i=2; i<=Math.sqrt(range); i++) {
			// false : 소수
			if(!prime[i]) {
				int j =2;
				while(true) {
					int num = i*j;
					if(num>range) break;
					prime[num] = true;
					j++;
				}
			}
		}
		
		for(int num=a; num<=b; num++) {
			if(prime[num]) continue; 
			boolean flag = isPall(String.valueOf(num));
			if(flag) sb.append(num).append("\n");
		}
		
		sb.append(-1);
		System.out.println(sb);
		
		
	}

	private static boolean isPall(String num) {

		int len = num.length();
		for(int i=0; i<len/2; i++) {
			if(num.charAt(i)!=num.charAt(len-1-i)) return false;
		}
		
		return true;
	}
}