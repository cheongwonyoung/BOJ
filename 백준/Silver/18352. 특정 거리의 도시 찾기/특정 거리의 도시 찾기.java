import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] tem = in.readLine().split(" ");
		int n = Integer.parseInt(tem[0]); // 점점 수
		int m = Integer.parseInt(tem[1]); // 도로 수
		int k = Integer.parseInt(tem[2]); // 거리 정보
		int x = Integer.parseInt(tem[3]); // 출발 도시의 번호
		
		ArrayList<Integer>[] list = new ArrayList[n+1];
		
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int t=0; t<m; t++) {
			tem = in.readLine().split(" ");
			int s = Integer.parseInt(tem[0]);
			int e = Integer.parseInt(tem[1]);
			
			list[s].add(e);

		}
		
		int[] check = new int[n+1]; 
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(x);
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i=0; i<list[temp].size(); i++) {
				if( check[list[temp].get(i)] == 0) {
					check[list[temp].get(i)] = check[temp] + 1;
					queue.offer(list[temp].get(i));
				}
			}
		}
		
		
//		// 플로이드-워셜
//		for(int d=1; d<n+1; d++) {
//			for(int i=1; i<n+1; i++) {
//				for(int j=1; j<n+1; j++) {
//					if(arr[i][j] > arr[i][d] +arr[d][j]) {
//						arr[i][j] = arr[i][d]+arr[d][j];
//					}
//				}
//			}
//		}
		
		
//		//출력문
//		for(int i=0; i<n+1; i++) {
//			for(int j=0; j<n+1; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// 결과 출력
		boolean flag = true;
		for(int i=1; i<n+1; i++) {
			if(check[i] == k && x!=i) {
				sb.append(i).append("\n");
				flag = false;
			}
		}
		if(flag) sb.append(-1).append("\n");
		
		System.out.println(sb);
	}
	
}