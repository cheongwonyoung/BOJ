import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] arr;
	static boolean[][] check;
	static int l,w,maxTime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// bfs로 최단 다른 육지로 갈 수 있는 최단거리들 파악
		// 그 중 가장 오래 걸리는 곳
		StringTokenizer st = new StringTokenizer(in.readLine());
		l = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		arr = new char[l][w];
		check = new boolean[l][w];
		
		for(int i=0; i<l; i++) {
			String tem = in.readLine();
			for(int j=0; j<w; j++) {
				arr[i][j] = tem.charAt(j);
			}
		}
		
		for(int i=0; i<l; i++) {
			for(int j=0; j<w; j++) {
				if(arr[i][j]=='W') continue;
				check = new boolean[l][w];
				bfs(i, j);
			}
		}
		
		System.out.println(maxTime);
		
	}

	private static void bfs(int row, int col) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {row, col, 0});
		check[row][col] = true;

		int time = 0;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			row = temp[0];
			col = temp[1];
			time = temp[2];
			
			if(time>maxTime) maxTime=time;
			
			for(int d=0; d<4; d++) {
				int nr = dr[d]+row;
				int nc = dc[d]+col;
				
				if(nr<0 || nc<0 || nr>=l || nc>=w || arr[nr][nc]=='W' ||check[nr][nc]) continue;
				
				queue.offer(new int[] {nr, nc, time+1});
				check[nr][nc] = true;
			}
			
			
		}
	}
}