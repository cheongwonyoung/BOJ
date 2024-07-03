import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		// 거의 소수 : 소수의 N제곱 꼴
		// 정수를 구하고, 제곱?
		// 10의 14승임으로 
		// 10의 7승 이하의 소수만 찾아내면 될듯(10,000,000)
		
		// 2 3 5 7 11 13 17 19 29 ..
		int n = 10000000;
		int count = 0;
		boolean[] prime = new boolean[n+1];
		
		for(int i=0; i<=n; i++) {
			prime[i] = true;
		}
		
		prime[0] = prime[1] = false;
		
		// 체로 소수 구하기
		// 해당 값의 배수들 지워나가기
		for(int i=2; i<=Math.sqrt(n); i++) {
			// 소수가 아니면 continue
			if(!prime[i]) continue;
			for(int j=i*2; j<=n; j+=i) {
				prime[j] = false;
			}
		}
		
		// 거의 소수 구하기
		for(int i=2; i<=n; i++) {
			// 소수면 제곱꼴로 거의 소수 구하기
			if(prime[i]) {
				int pow = 2;
				while(true) {
					long num = (long)Math.pow(i, pow++);
					if(num<a) continue; 
					if(num>b) break;
					count++;
				}
			}
		}
		

		System.out.println(count);
		
	}
}