import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(st.nextToken());
		
		for(int tc=0; tc<TC; tc++) {
			
			st = new StringTokenizer(in.readLine());
			// 지점의 수
			int n = Integer.parseInt(st.nextToken());
			// 도로의 개수
			int m = Integer.parseInt(st.nextToken());
			// 웜홀의 개수
			int w = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n+1][n+1];
			for(int i=0; i<=n; i++) {
				for(int j=0; j<=n; j++) {
					arr[i][j] = Integer.MAX_VALUE;
				}
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				arr[e][s] = Math.min(t,arr[e][s]);
				arr[s][e] = Math.min(t,arr[e][s]);
			}
			for(int i=0; i<w; i++) {
				st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());				
				arr[s][e] = Math.min(-t,arr[s][e]);
			}
			
			for(int k=1; k<=n; k++) {
				for(int i=1; i<=n; i++) {
					for(int j=1; j<=n; j++) {
						if(arr[i][k]==Integer.MAX_VALUE || arr[k][j]==Integer.MAX_VALUE) continue;
						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}
				}
			}

			boolean flag = false;
			for(int i=1; i<=n; i++) {
				if(arr[i][i]<0) {
					flag=true;
					break;
				}
			}
			if(flag) {				
				sb.append("YES").append("\n");
			}
			else {
				sb.append("NO").append("\n");				
			}
			
		}
		System.out.println(sb);
	}
}