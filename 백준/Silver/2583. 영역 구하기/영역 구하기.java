import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n,m, areaCnt;
	static boolean[][] check;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<>();
		check = new boolean[m][n];
		
		// 직삭각형들의 영역 체크
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			int leftUnderCol = Integer.parseInt(st.nextToken());		
			int leftUnderRow = m-Integer.parseInt(st.nextToken());
			int rightUpCol = Integer.parseInt(st.nextToken());
			int rightUpRow = m-Integer.parseInt(st.nextToken());
			
			for(int row=rightUpRow; row<leftUnderRow; row++) {
				for(int col=leftUnderCol; col<rightUpCol; col++) {
					check[row][col] = true;
				}
			}
		}
	
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(check[i][j]) continue;
				// 영역 탐색
				areaCnt++;
				int area = bfs(i, j);
				list.add(area);
			}
		}
		
		sb.append(areaCnt).append("\n");
		list.sort((o1,o2)->
		{ 
			return o1-o2;
		});
		
		for(int val : list) {
			sb.append(val).append(" ");
		}
		
		System.out.println(sb);
		
	}
	private static int bfs(int row, int col) {
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {row,col});
		check[row][col] = true;
		int area = 1;
		while(!queue.isEmpty()) {
			
			int[] temp = queue.poll();
			row = temp[0];
			col = temp[1];
			
			for(int d=0; d<4; d++) {
				int nr = dr[d] + row;
				int nc = dc[d] + col;
				
				if(nr<0 || nc<0 || nr>=m || nc>=n || check[nr][nc]) continue;
				
				queue.offer(new int[] {nr,nc});
				check[nr][nc] = true;
				area++;
				
				
			}
		}
		return area;
		
	}
}