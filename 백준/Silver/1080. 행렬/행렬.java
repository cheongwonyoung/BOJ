import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// A->B행렬 변환
		// 3x3크기의 부분 행렬의 원소를 뒤집을 수 있음
		// 몇번 걸리나 ?
		
		// 현재 위치의 A와 B의 원소가 다르면 일단 뒤집어야 함. --> 이게 최선의 선택(그리디)
		// 현재 위치를 3x3의 좌측상단을 기준으로 진행.
		// 뒤집은 횟수가 결과.
		
		
		String[] input = in.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		int result = 0;
		int[][] A = new int[n][m];
		for(int i=0; i<n; i++) {
			input = in.readLine().split("");
			for(int j=0; j<m; j++) {
				A[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int[][] B = new int[n][m];
		for(int i=0; i<n; i++) {
			input = in.readLine().split("");
			for(int j=0; j<m; j++) {
				B[i][j] = Integer.parseInt(input[j]);
			}
		}

		if(n>=3&&m>=3) {
			for(int i=0; i<n-2; i++) {
				for(int j=0; j<m-2; j++) {
					if(A[i][j]!=B[i][j]) {
						reverse(i,j,A);
						result++;
					}
				}
			}
		}
		
		boolean check = isSame(A,B);
		
		if(result!=0 && check) System.out.println(result);
		else {
			boolean flag = true;
			out : for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(A[i][j]!=B[i][j]) {
						flag=false;
						break out;
					}
				}
			}
			if(flag) System.out.println(0);
			else System.out.println(-1);
		}
		
	}

	private static boolean isSame(int[][] a, int[][] b) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]!=b[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void reverse(int row, int col, int[][] a) {
		for(int i=row; i<row+3; i++) {
			for(int j=col; j<col+3; j++) {
				if(a[i][j]==1) a[i][j]=0;
				else a[i][j] = 1;
			}
		}
	}
	
	

}