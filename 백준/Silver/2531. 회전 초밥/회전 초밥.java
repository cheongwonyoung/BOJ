import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] dish = new int[N*2];
		int[] chobab = new int[d+1];
				
		// 쿠폰 사용
		int cnt = 1;
		chobab[c]++;
		
		for(int i=0; i<N; i++) {
			dish[i] = Integer.parseInt(in.readLine());
			if(i<k) {
				chobab[dish[i]]++;
				if(chobab[dish[i]]==1) {					
					cnt++;
				}
			}
			dish[N+i] = dish[i];
		}
		
		int maxCnt = cnt;
		for(int i=k; i<N+k; i++) {
			if(chobab[dish[i-k]]!=0) {
				chobab[dish[i-k]]--;
				if(chobab[dish[i-k]]==0)cnt--;
			}	
			
			chobab[dish[i]]++;
			if(chobab[dish[i]]==1) {
				cnt++;
			}
			
			
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
		
		
	}
}