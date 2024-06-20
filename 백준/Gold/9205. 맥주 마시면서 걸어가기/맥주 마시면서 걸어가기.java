import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static int[][] map;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		String[] tem;

		for(int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(in.readLine());
			int[][] arr = new int[n+2][n+2];

			map = new int[n+2][n+2];
			
			
			for(int i =0; i<=n+1; i++) {
				tem = in.readLine().split(" ");
				arr[i][0] = Integer.parseInt(tem[0]);
				arr[i][1] = Integer.parseInt(tem[1]);				
			}
			
			for(int i =0; i<n+2; i++) {
				for(int j=0; j<n+2; j++) {
					if(i==j) continue;
					
					map[i][j] = Math.abs(arr[i][0]-arr[j][0]) + Math.abs(arr[i][1]-arr[j][1]); 	
					if(map[i][j]<=1000) {
						map[i][j]=1;
						
					}
					else {
						map[i][j]=100000;
					}
				}
			}
			

			for(int k=0; k<n+2; k++) {
				for(int j=0; j<n+2; j++) {
					for(int i=0; i<n+2; i++) {
						if(i==j) continue;					 
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
						
					}
				}
			}
			

			if(map[0][n+1] <=1000) sb.append("happy").append("\n");
			else sb.append("sad").append("\n");
			
		}
		
		System.out.println(sb);
	}

	
}