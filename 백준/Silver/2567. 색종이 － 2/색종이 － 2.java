import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		boolean[][] arr = new boolean[101][101];
		
		int n = Integer.parseInt(in.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = 100-Integer.parseInt(st.nextToken());
			
			for(int r=row; r>row-10; r--) {
				for(int c=col; c<col+10; c++) {
					arr[r][c]=true;
				}				
			}
			
		}

		int cnt = 0;
		
		for(int r=0; r<=100; r++) {
			for(int c=0; c<=100; c++) {
				if(arr[r][c]) {
					// 색종이 내부인지
					for(int d=0; d<4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(nr<0 || nc<0 || nr>100 || nc>100)continue;
						
						if(!arr[nr][nc]) {
							cnt++;
						}
						
					}
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}