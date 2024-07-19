import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		
		int cnt=0;
		if(n==1) cnt=0;
		else {
			boolean[] prime = new boolean[n+1];
			prime[1] = true;
			for(int i=2; i<=Math.sqrt(n); i++) {
				if(prime[i]) continue;
				for(int j=i+i; j<=n; j+=i) {
					prime[j] = true;
				}
			}
			
			List<Integer> list = new ArrayList<Integer>();
			for(int i=2; i<n+1; i++) {
				if(!prime[i]) list.add(i);
			}
			
			int left = 0;
			int right = 0;
			int sum = list.get(0);

			while(left<=right) {
				if(sum==n) {
					cnt++;
				}
				if(sum<=n) {
					right++;
					if(right==list.size()) break;
					sum += list.get(right);
				}
				else {
					sum -= list.get(left);
					left++;
				}
			}
		}
		
		
		
		System.out.println(cnt);
		
	}
}