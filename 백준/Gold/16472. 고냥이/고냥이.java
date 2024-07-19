import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		
		
		// set에 현재 위치 값 넣고 시작
		// left:0, right:0에서 시작
		// right-left로 길이 업데이트
		// set에 right위치 원소를 넣었을 때 길이가 n이하면 우측 포인터 이동
		// n보다 크면 좌측 포인터 이동
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		// a~z 각 개수
		int[] alphaCnt = new int[26];
		
		String alpha = in.readLine();
		int len = alpha.length();

		int result = 1;
		int left = 0;
		int right = 0;
		
		int cnt=1;
		alphaCnt[alpha.charAt(0)-'a']++;
		
		while(left<=right) { 
			if(cnt<=n)
				result = Math.max(result, right-left+1);

			if(cnt<=n) {
				right++;
				if(right==len) break;
				
				alphaCnt[alpha.charAt(right)-'a']++;
				if(alphaCnt[alpha.charAt(right)-'a']==1) {
					cnt++;
				}
			}
			else {
				if(alphaCnt[alpha.charAt(left)-'a']>0) {
					alphaCnt[alpha.charAt(left)-'a']--;
					if(alphaCnt[alpha.charAt(left)-'a']==0) cnt--;
				}
				left++;
			}	
		}
		
		System.out.println(result);
		
	}
}