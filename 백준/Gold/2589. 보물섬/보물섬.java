import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static String[][] arr;
	static boolean[][] check;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int row, col;
	static int maxVal = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		row = Integer.parseInt(tem[0]);
		col = Integer.parseInt(tem[1]);
		
		arr = new String[row][col];
		for(int i=0; i<row; i++) {
			tem = in.readLine().split("");
			for(int j=0; j<col; j++) {
				arr[i][j] = tem[j];
			}
		}
		
		// L : 육지
		// W : 바다
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(arr[i][j].equals("L")) {					
					check = new boolean[row][col];
					bfs(i,j,0);
				}
			}
		}
		System.out.println(maxVal);
	}

	private static void bfs(int r, int c, int cnt) {
		
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c,cnt});
		check[r][c] = true;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];
			cnt = temp[2];
			if(maxVal<cnt) maxVal = cnt;
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr<0 || nc<0 || nr>=row || nc>=col || check[nr][nc] || arr[nr][nc].equals("W")) continue;
				
				check[nr][nc] = true;
				queue.offer(new int[] {nr,nc,cnt+1});
				
			}
		}
		
		
	}
}