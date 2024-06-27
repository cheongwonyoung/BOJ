import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		// 0~무한대 채널
		// 고장난 버튼이 주어졌을 때,
		// 100->N으로 이동하기 위해 버튼을 몇 번 눌러야하는지 구해라
		
		// 맨 앞자리부터 가능한 숫자들 체크
		// 사용할 수 없다면 최대한 근접한 수 파악
		
		int result = 0;
		String n = in.readLine();
		int m = Integer.parseInt(in.readLine());
		
		
		// 고장난 버튼 체크
		boolean[] doNotUseNum = new boolean[10];
		if(m!=0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for(int i=0; i<m; i++) {
				int num = Integer.parseInt(st.nextToken());
				doNotUseNum[num] = true;
			}
		}

		// 직접 -, +만 눌러스 이동하는 경우
		result = Math.abs(Integer.parseInt(n)-100);
		
		for(int i=0; i<1000000; i++) {
			String now = ""+i;
			
			int len = now.length();
			boolean flag=true;
			for(int j=0; j<len; j++) {
				if(doNotUseNum[now.charAt(j)-'0']) {
					flag = false;
					break;
				}
			}
			if(flag)
			result = Math.min(result, len+Math.abs(Integer.parseInt(n)-i));
		}
		System.out.println(result);
	}

}