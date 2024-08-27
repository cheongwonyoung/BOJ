import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	static int n;
	static List<Long> list = new ArrayList<>();
//	static int[] number = {0,1,2,3,4,5,6,7,8,9};
	static int[] number = {9,8,7,6,5,4,3,2,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		// 1,000,000보다 작은(6자리 자연수 중) 값 중
		// 0~9를 사용하여 만들 수 있는 자연수를 만든다.
		// 만든 자연수를 List에 넣어 정렬한 후 N번째 값을 찾는다
		// 만약 list의 크기보다 n이 크면 -1 출력
		
		dfs(0, 0);
	
		Collections.sort(list);
		if(list.size()<n) {
			System.out.println(-1);
		}
		else {			
			System.out.println(list.get(n-1));
		}
		
	}
	private static void dfs(long num, int cnt) {
		if(cnt==10) {
			if(!list.contains(num)) {				
				list.add(num);
			}
			return;
		}
		
	
		// 현재 위치의 값을 안 쓴 경우
		dfs(num, cnt+1);
		// 현재 위치의 값을 쓴 경우
		dfs(num*10+number[cnt], cnt+1);
		
		
		
	}
}