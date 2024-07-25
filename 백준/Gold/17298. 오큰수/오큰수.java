import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		int[] result = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<n; i++) {
			// 스택에 마지막으로 넣은 인덱스 위치 값보다 현재가 크면
			// 스택에 저장된 인덱스 위치들의 오큰수는 현재 인덱스이다.
	
			while(!stack.isEmpty() &&  arr[stack.peek()] < arr[i]) {
				int idx = stack.pop();
				result[idx] = arr[i];
			}
			
						
			stack.push(i);
			
		}
		
		for(int num : result) {
			if(num==0) num = -1;
			sb.append(num).append(" ");
		}
		
		System.out.println(sb);
		
	}
}